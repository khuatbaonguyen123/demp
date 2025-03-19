package com.mentorship.news_aggregation.controllers;

import com.mentorship.news_aggregation.dtos.UserDto;
import com.mentorship.news_aggregation.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/signUp")
    public ResponseEntity<String> signUpUser(@RequestBody UserDto userDto) {
        String response = userService.signUpUser(userDto);
        return ResponseEntity.ok(response);
    }
}
