package com.example.springbootcrudapp.services;

import com.example.springbootcrudapp.entities.UserEntity;
import com.example.springbootcrudapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserEntity> findById(Long id) {
        return userRepository.findById(id);
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    public void deletedUser(Long id) {
         userRepository.deleteById(id);
    }
}
