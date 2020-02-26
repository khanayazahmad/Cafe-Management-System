package com.cmpe202.starbucks.dto;


import com.cmpe202.starbucks.model.Menu;
import com.cmpe202.starbucks.model.User;
import java.util.List;


public class OrderDto {

    private User user;

    private List<Menu> menuItems;

    private Double totalPrice;


    public OrderDto(){

    }

    public OrderDto(List<Menu> menuItems, Double totalPrice) {
        this.menuItems = menuItems;
        this.totalPrice = totalPrice;
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
