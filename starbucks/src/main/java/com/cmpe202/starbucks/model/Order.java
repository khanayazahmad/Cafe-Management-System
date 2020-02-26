package com.cmpe202.starbucks.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "order_details")
public class Order {

    @Id
    @Column(name="ORDER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="USER_ID")
    private User user;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="order_menu", joinColumns={@JoinColumn(name="ORDER_ID")}, inverseJoinColumns={@JoinColumn(name="MENU_ID")})
    private List<Menu> menuItems;

    @Column(name = "TOTAL_PRICE")
    private Double totalPrice;


    public Order(){

    }

    public Order(List<Menu> menuItems, Double totalPrice) {
        this.menuItems = menuItems;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Menu> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<Menu> menuItems) {
        this.menuItems = menuItems;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
