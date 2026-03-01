package com.fernando.webservice.config;

import com.fernando.webservice.model.entities.Category;
import com.fernando.webservice.model.entities.Order;
import com.fernando.webservice.model.entities.User;
import com.fernando.webservice.model.entities.enums.OrderStatus;
import com.fernando.webservice.repositories.CategoryRepository;
import com.fernando.webservice.repositories.OrderRepository;
import com.fernando.webservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        Category category = new Category(null, "Roupas");
        Category category2 = new Category(null, "Remédios");

        categoryRepository.saveAll(Arrays.asList(category, category2));

        User u1 = new  User(null, "Carlos", "carlos@gmail", "123", "9000-0000");
        User u2 = new  User(null, "Maria", "maria@gmail", "1234", "8000-0000");
        Order o1 = new  Order(null, Instant.now(), OrderStatus.WATING_PAYMENT, u1);
        Order o2 = new  Order(null, Instant.now(),OrderStatus.PAID,u2);

        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2));
    }
}