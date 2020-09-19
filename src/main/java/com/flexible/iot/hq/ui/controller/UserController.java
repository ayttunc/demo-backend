package com.flexible.iot.hq.ui.controller;

import com.flexible.iot.hq.service.UserService;
import com.flexible.iot.hq.shared.dto.UserDto;
import com.flexible.iot.hq.ui.model.request.UserDetailRequestModel;
import com.flexible.iot.hq.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUser() {
        return "get user was called";
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailRequestModel userDetails) {

        UserRest returnValue = new UserRest();
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);

        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, returnValue);

        return returnValue;
    }

    @PutMapping
    public String updateUser(@RequestBody UserDetailRequestModel userDetails) {
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser(@RequestBody UserDetailRequestModel userDetails) {
        return "delete user was called";
    }
}
