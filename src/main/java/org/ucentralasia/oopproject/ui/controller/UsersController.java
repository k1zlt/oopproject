package org.ucentralasia.oopproject.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.ucentralasia.oopproject.service.UserService;
import org.ucentralasia.oopproject.shared.dto.UserDto;
import org.ucentralasia.oopproject.ui.model.request.UserDetailsRequestModel;
import org.ucentralasia.oopproject.ui.model.response.UserRest;

@RestController
@RequestMapping("users") // http://localhost:8080/users

public class UsersController {
    @Autowired
    UserService userService;
    @GetMapping
    public String getUsers() {
        //read parameters
        //query to DB
        //return resource from DB to the client
        return "message form the getUsers method\n";
    }
    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel user) {
        UserRest returnValue = new UserRest();
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user,userDto);
        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser,returnValue);
        return returnValue;
    }
    @PutMapping
    public String postUser() { return "message from postUser method\n";}
    @DeleteMapping
    public String deleteUser() { return "message from deleteUser method\n";}


}
