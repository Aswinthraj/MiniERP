package com.raj.springweb.service;

import com.raj.springweb.model.User;
import com.raj.springweb.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository,BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public User saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public boolean checkPassword(String raw,String hashed){
        return passwordEncoder.matches(raw,hashed);
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username)
                .orElseThrow(()->new RuntimeException("Username not found!"));
    }

}
