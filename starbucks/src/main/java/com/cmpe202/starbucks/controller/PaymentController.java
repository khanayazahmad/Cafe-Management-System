package com.cmpe202.starbucks.controller;


import com.cmpe202.starbucks.dto.NewCardDto;
import com.cmpe202.starbucks.dto.OrderDto;
import com.cmpe202.starbucks.dto.PaymentDto;
import com.cmpe202.starbucks.model.Menu;
import com.cmpe202.starbucks.model.User;
import com.cmpe202.starbucks.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/payment")
public class PaymentController {

    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    @RequestMapping(method = RequestMethod.POST, value = "/")
    @PreAuthorize("hasRole('ROLE_USER')")
    public @ResponseBody
    ResponseEntity<String> orderPayment(@RequestBody PaymentDto paymentDto){

        return paymentService.orderPayment(paymentDto.getNewCardDto(),paymentDto.getOrderDto());
    }

    @GetMapping(value="/fake")
    public @ResponseBody
    PaymentDto get(){
        User u = new User();
        u.setId((long)1);
        NewCardDto cd = new NewCardDto("123456789","1234",(double)20,u);
        OrderDto od = new OrderDto();
        od.setUser(u);
        od.setTotalPrice((double)10);
        List<Menu> list = new ArrayList<>();
        Menu m1 = new Menu();
        m1.setId(1);
        Menu m2 = new Menu();
        m1.setId(2);
        list.add(m1);
        list.add(m2);
        od.setMenuItems(list);
        return new PaymentDto(cd,od);


    }




}
