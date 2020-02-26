package com.cmpe202.starbucks.dto;

import com.cmpe202.starbucks.model.User;

public class CardDetailsDto {


    private String cardNumber;

    private Double balance;

    public CardDetailsDto() {

    }

    public CardDetailsDto(String cardNumber, Double balance) {
        this.cardNumber = cardNumber;
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    public double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }


}
