package com.fernando.webservice.resources;

import com.fernando.webservice.model.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> getUser() {
        User user = new User(1L, "MyFirstRequestHTTP", "luquinha@gmail.com", "123", "0000-0000");
        return ResponseEntity.ok().body(user);
    }

}
