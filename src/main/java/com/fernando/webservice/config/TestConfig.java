package com.fernando.webservice.config;

import com.fernando.webservice.model.entities.Category;
import com.fernando.webservice.model.entities.Order;
import com.fernando.webservice.model.entities.Product;
import com.fernando.webservice.model.entities.User;
import com.fernando.webservice.model.entities.enums.OrderStatus;
import com.fernando.webservice.repositories.CategoryRepository;
import com.fernando.webservice.repositories.OrderRepository;
import com.fernando.webservice.repositories.ProductRepository;
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
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        Category category1 = new Category(null, "Roupas");
        Category category2 = new Category(null, "Remédios");
        Category category3 = new Category(null, "Filmes");
        Category category4 = new Category(null, "Eletrônicos");
        Category category5 = new Category(null, "Livros");

        categoryRepository.saveAll(Arrays.asList(category1, category2,  category3, category4, category5));

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "", category3);
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "",  category4);
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "", category4);
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "", category4);
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "",  category5);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        User u1 = new  User(null, "Carlos", "carlos@gmail", "123", "9000-0000");
        User u2 = new  User(null, "Maria", "maria@gmail", "1234", "8000-0000");
        Order o1 = new  Order(null, Instant.now(), OrderStatus.WATING_PAYMENT, u1);
        Order o2 = new  Order(null, Instant.now(),OrderStatus.PAID,u2);

        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2));
    }
}