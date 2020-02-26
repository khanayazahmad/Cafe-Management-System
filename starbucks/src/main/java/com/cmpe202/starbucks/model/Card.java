

package com.cmpe202.starbucks.model;

import javax.persistence.*;


@Entity
@Table(name = "card")
public class Card {

    @Id
    @Column(name="CARD_NUMBER",length = 9)
    private String cardNumber;

    @Column(name="CARD_CODE")
    private String cardCode;

    @Column(name="BALANCE")
    private Double balance;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="OWNER_ID")
    private User user;

    public Card() {

    }

    public Card(String cardNumber, String cardCode, Double balance) {
        this.cardNumber = cardNumber;
        this.cardCode = cardCode;
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}