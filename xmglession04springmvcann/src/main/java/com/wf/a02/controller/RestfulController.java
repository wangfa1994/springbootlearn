package com.wf.controller;

import com.wf.dto.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestfulController {

    @PostMapping(value = "/echo/user")
    public User user(@RequestBody User user) {
        return user;
    }
}
