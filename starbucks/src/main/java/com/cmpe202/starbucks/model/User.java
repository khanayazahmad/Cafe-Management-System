package com.cmpe202.starbucks.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name="USER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="USERNAME", nullable = false, unique = true)
    private String username;

    @Column(name="PASSWORD")
    private String password;

    
    @Column(name="FIRSTNAME")
    private String firstname;

	@Transient
    private List<Card> ownedCards;

    public User(){

    }


    public User(Long id, String username, String password, List<Card> ownedCards) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.ownedCards = ownedCards;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Card> getOwnedCards() {
        return ownedCards;
    }

    public void setOwnedCards(List<Card> ownedCards) {
        this.ownedCards = ownedCards;
    }
    
    public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
}
