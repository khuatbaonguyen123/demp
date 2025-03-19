package com.mentorship.news_aggregation.services;

import com.mentorship.news_aggregation.dtos.UserDto;
import com.mentorship.news_aggregation.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.mentorship.news_aggregation.entities.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String signUpUser(UserDto userDto) {

        if(userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new RuntimeException("Email already taken");
        }

        User user = transferToUser(userDto);
        userRepository.save(user);

        return "User signed up successfully";
    }

    private User transferToUser(UserDto userDto) {
        User user = new User();
        
        user.setId(userDto.getId());
        user.setFullName(userDto.getFullName());
        user.setEmail(userDto.getEmail());
        
        String hashedPassword = passwordEncoder.encode(userDto.getPassword());

        return user;
    }

}
