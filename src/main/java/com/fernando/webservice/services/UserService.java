package com.fernando.webservice.services;

import com.fernando.webservice.model.entities.User;
import com.fernando.webservice.repositories.UserRepository;
import com.fernando.webservice.services.exceptions.DataBaseException;
import com.fernando.webservice.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        User user = userRepository.getReferenceById(id);
        try {
            userRepository.delete(user);
        }
        catch (ObjectOptimisticLockingFailureException e) {
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    public User update(Long id, User user) {
        try {
            User x = userRepository.getReferenceById(id);
            updateData(x, user);
            return userRepository.save(x);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public void updateData(User x, User user) {
        x.setName(user.getName());
        x.setEmail(user.getEmail());
        x.setPhone(user.getPhone());
    }
}
