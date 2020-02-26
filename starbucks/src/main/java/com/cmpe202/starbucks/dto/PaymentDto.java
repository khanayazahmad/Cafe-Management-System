package com.cmpe202.starbucks.dto;

public class PaymentDto {

    private NewCardDto newCardDto;
    private OrderDto orderDto;

    public PaymentDto(NewCardDto newCardDto, OrderDto orderDto) {
        this.newCardDto = newCardDto;
        this.orderDto = orderDto;
    }

    public NewCardDto getNewCardDto() {
        return newCardDto;
    }

    public void setNewCardDto(NewCardDto newCardDto) {
        this.newCardDto = newCardDto;
    }

    public OrderDto getOrderDto() {
        return orderDto;
    }

    public void setOrderDto(OrderDto orderDto) {
        this.orderDto = orderDto;
    }
}
