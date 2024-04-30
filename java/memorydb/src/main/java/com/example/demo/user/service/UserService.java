package com.example.demo.user.service;

import com.example.demo.user.db.UserRepository;
import com.example.demo.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserEntity save(UserEntity user){
        // save

    }
}
