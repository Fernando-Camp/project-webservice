package com.fernando.webservice.resources;

import com.fernando.webservice.model.entities.Order;
import com.fernando.webservice.services.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users/orders")
public class OrderResource {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/byUser/{id}")
    public ResponseEntity<List<Order>> getByUserId(@PathVariable Long id){
        return ResponseEntity.ok().body(orderService.findAllByUserId(id));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrder() {
        return ResponseEntity.ok().body(orderService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok().body(orderService.findById(id));
    }

}
