package com.cmpe202.starbucks.security;

import javax.persistence.*;

@Entity
@Table(name = "permission")
public class Permission {

    @Id
    @Column(name="PERMISSION_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="USERNAME")
    private String username;
    @Column(name="PERMISSION")
    private String permission;

    public Permission(){

    }

    public Permission(String username, String permission) {
        this.username = username;
        this.permission = permission;
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

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
