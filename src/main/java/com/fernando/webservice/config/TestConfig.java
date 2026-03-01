package com.fernando.webservice.config;

import com.fernando.webservice.model.entities.*;
import com.fernando.webservice.model.entities.enums.OrderStatus;
import com.fernando.webservice.model.entities.enums.PaymentType;
import com.fernando.webservice.repositories.*;
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
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        Category category1 = new Category(null, "Eletrônicos");
        Category category2 = new Category(null, "Livros");
        Category category3 = new Category(null, "Computadores");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getCategories().add(category2);
        p2.getCategories().add(category1);
        p2.getCategories().add(category3);
        p3.getCategories().add(category3);
        p4.getCategories().add(category3);
        p5.getCategories().add(category2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        User u1 = new  User(null, "Carlos", "carlos@gmail", "123", "9000-0000");
        User u2 = new  User(null, "Maria", "maria@gmail", "1234", "8000-0000");
        Order o1 = new  Order(null,  Instant.parse("2019-06-20T21:53:06Z"), OrderStatus.WATING_PAYMENT, u1);
        Order o2 = new  Order(null,  Instant.parse("2019-07-20T19:00:00Z"),OrderStatus.PAID,u2);
        Order o3 = new  Order(null,  Instant.parse("2019-08-20T08:31:02Z"),OrderStatus.WATING_PAYMENT,u1);

        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2, o3));

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));

        Payment payment1 = new Payment(null, Instant.parse("2019-08-20T12:00:00Z"), 0.0, PaymentType.PIX, o2);
        o1.setPayment(payment1);
        orderRepository.save(o1);
    }
}