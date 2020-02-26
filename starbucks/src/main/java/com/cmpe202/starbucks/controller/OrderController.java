package com.cmpe202.starbucks.controller;

import com.cmpe202.starbucks.dto.OrderDto;
import com.cmpe202.starbucks.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/order")
public class OrderController {


    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    @PreAuthorize("hasRole('ROLE_USER')")
    public @ResponseBody
    ResponseEntity<String> addCard(@RequestBody OrderDto orderDto){

        return orderService.addOrder(orderDto);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/get/byUserId/{userId}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public @ResponseBody
    List<OrderDto> getAllOrdersByUserId(@PathVariable(value = "userId") Long userId){

        return orderService.getAllOrdersByUser(userId);
    }



}
