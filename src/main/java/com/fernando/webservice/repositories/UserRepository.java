package com.fernando.webservice.repositories;

import com.fernando.webservice.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
