package com.cmpe202.starbucks.dto;

public class CurrentUserDto {

    private long id;

    private String firstname;

    private String username;

    public CurrentUserDto(){

    }

    public CurrentUserDto(long id, String firstname, String username) {
        this.id = id;
        this.firstname = firstname;
        this.username = username;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
