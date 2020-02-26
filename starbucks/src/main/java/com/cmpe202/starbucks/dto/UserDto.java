package com.cmpe202.starbucks.dto;

import com.cmpe202.starbucks.model.Card;

import java.util.List;

public class UserDto {
	private long id;
	
	private String firstname;

	private String username;

    private String password;

    private List<Card> ownedCards;

    public UserDto(){

    }

    public UserDto(String username, String password, List<Card> ownedCards) {
        this.username = username;
        this.password = password;
        this.ownedCards = ownedCards;
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
    
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
}
