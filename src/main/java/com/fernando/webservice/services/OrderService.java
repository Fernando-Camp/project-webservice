package com.fernando.webservice.services;

import com.fernando.webservice.model.entities.Order;
import com.fernando.webservice.model.entities.User;
import com.fernando.webservice.repositories.OrderRepository;
import com.fernando.webservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Order> findAllByUserId(Long id){
        Optional<User> user = userRepository.findById(id);
        return user.get().getOrders();
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.get();
    }
}
