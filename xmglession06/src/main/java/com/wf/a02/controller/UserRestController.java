package com.wf.controller;

import com.wf.dto.User;
import org.springframework.web.bind.annotation.*;

/**
 * User {@link RestController}
 *
 * @author 小马哥
 * @since 2018/5/27
 */
@RestController
public class UserRestController {


    // 127.0.0.1:8080/echo/getUser?name=zhangsan
    @GetMapping(value = "/echo/getUser")
    public User getUser(@RequestParam String name) {
        System.out.println("hello:"+name);
        User  user = new User(); user.setName(name);user.setId(12L);
        return user;
    }



    /* 127.0.0.1:8080/echo/user
    * */
    @PostMapping(value = "/echo/user")
    public User user(@RequestBody User user) {
        return user;
    }


    /* consumers 和 produces的使用  127.0.0.1:8080/echo/user  */
    @PostMapping(value = "/echo/user1", consumes = "application/*;charset=UTF-8", produces = "application/json;charset=UTF-8")
    public User user1(@RequestBody User user) {
        return user;
    }

}
