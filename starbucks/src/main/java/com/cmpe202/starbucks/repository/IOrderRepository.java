package com.cmpe202.starbucks.repository;

import com.cmpe202.starbucks.model.Order;
import com.cmpe202.starbucks.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IOrderRepository extends CrudRepository<Order, Long> {

    List<Order> findByUser(User user);
}
