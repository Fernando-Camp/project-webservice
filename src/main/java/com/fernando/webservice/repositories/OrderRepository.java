package com.fernando.webservice.repositories;

import com.fernando.webservice.model.entities.Order;
import com.fernando.webservice.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
