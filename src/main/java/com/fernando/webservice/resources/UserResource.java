package com.fernando.webservice.resources;

import com.fernando.webservice.model.entities.User;
import com.fernando.webservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUser() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }

        @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        user = userService.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user); // Retorna 201 como HTTP status code
    }

//    @PostMapping - retorna 200 como HTTP status code
//    public ResponseEntity<User> createUser(@RequestBody User user) {
//        user = userService.insert(user);
//        return ResponseEntity.ok().body(user);
//    }
}
