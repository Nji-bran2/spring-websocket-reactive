package com.iwomi.reactive.services;

import com.iwomi.reactive.frameworks.UserRepository;
import com.iwomi.reactive.frameworks.data.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public UserEntity create(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }
    public boolean userExists(String name) {
        return userRepository.existsById(name);
    }
}
