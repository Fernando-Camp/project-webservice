package com.fernando.webservice.config;

import com.fernando.webservice.model.entities.User;
import com.fernando.webservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new  User(null, "Carlos", "carlos@gmail", "123", "9000-0000");
        User u2 = new  User(null, "Maria", "maria@gmail", "1234", "8000-0000");

        userRepository.saveAll(Arrays.asList(u1,u2));
    }
}
