package com.cmpe202.starbucks.dto;

import com.cmpe202.starbucks.model.User;

public class SelectedCardDto {

    private static SelectedCardDto cardInstance;

    private String cardNumber;

    private String cardCode;

    private double balance;

    private User user;

    private SelectedCardDto() {
        this.cardNumber = "000000000";
        this.cardCode = "000";
        this.balance = 0.00;
        this.user = null;
    }

    /**
     * Return class instance
     *
     * @return Card instance
     */
    public static SelectedCardDto getInstance() {
        if (cardInstance == null) {
            cardInstance = new SelectedCardDto();
        }
        return cardInstance;
    }

    /** Reset Card Details */
    public void resetCard() {
        this.cardNumber = "000000000";
        this.cardCode = "000";
        this.balance = 0.00;
        this.user = null;
    }

    /**
     *
     * @param num  card number
     * @param code card code
     * @param amnt card amount
     */
    public void setCard(String num, String code, double amnt) {
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

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
