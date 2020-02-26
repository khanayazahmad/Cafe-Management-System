package com.cmpe202.starbucks.service;

import com.cmpe202.starbucks.dto.OrderDto;
import com.cmpe202.starbucks.model.Order;
import com.cmpe202.starbucks.model.User;
import com.cmpe202.starbucks.repository.IOrderRepository;
import com.cmpe202.starbucks.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final IOrderRepository orderRepository;
    private final IUserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public OrderService(IOrderRepository orderRepository, IUserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.modelMapper = new ModelMapper();
    }

    public ResponseEntity<String> addOrder(OrderDto orderDto){
        Order order = modelMapper.map(orderDto,Order.class);
        order = orderRepository.save(order);
        if(null != order){
            return ResponseEntity.ok("Order added with number: "+ order.getId());

        }else{
            return new ResponseEntity<>("Order could not be added", HttpStatus.BAD_REQUEST);

        }

    }

    public List<OrderDto> getAllOrdersByUser(Long userId){
        Optional<User> userFound = userRepository.findById(userId);
        User user = new User();
        List<OrderDto> orderDtoList = new ArrayList<>();

        userFound.ifPresent(result->{
            user.setId(result.getId());
            user.setFirstname(result.getFirstname());
        });

        if(userFound.isPresent()){
            List<Order> ordersFound = orderRepository.findByUser(user);
            ordersFound.forEach(order->{
                order.setUser(user);
                orderDtoList.add(modelMapper.map(order,OrderDto.class));
            });
        }

        return orderDtoList;

    }
}
