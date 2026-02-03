
package com.wf.controller;

import com.wf.dto.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestfulController {

    // http://localhost:8080/echo/user?name=zhangsan
    @GetMapping(value = "/echo/user")
    public User user(@RequestParam String name) {
        System.out.println("request:"+name);

        User  user = new User();user.setName(name);user.setId(12L);
        return user;
    }
}

