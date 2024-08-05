package com.example.user.services;

import com.example.user.entities.UserEntity;
import com.example.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    private UserEntity findUserById(Long id) {
        UserEntity userFound = userRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el usuario"));
        return userFound;
    }
}
