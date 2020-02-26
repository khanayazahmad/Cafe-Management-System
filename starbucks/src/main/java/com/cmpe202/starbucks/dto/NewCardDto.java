package com.cmpe202.starbucks.dto;

import com.cmpe202.starbucks.model.User;

public class NewCardDto {

    private String cardNumber;

    private String cardCode;

    private Double balance;

    private User user;

    public NewCardDto() {

    }

    public NewCardDto(String cardNumber, String cardCode, Double balance, User user) {
        this.cardNumber = cardNumber;
        this.cardCode = cardCode;
        this.balance = balance;
        this.user = user;
    }


    /**
     *
     * @param num  card number
     * @param code card code
     * @param amnt card amount
     */
    public void setCard(String num, String code, Double amnt) {
        this.cardNumber = num;
        this.cardCode = code;
        this.balance = amnt;
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

    public double getBalance() {
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
