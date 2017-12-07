package com.soso.traveller.controller;


import com.soso.traveller.entity.User;
import com.soso.traveller.entity.request.AddUserRequest;
import com.soso.traveller.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserContoller {
    private UserRepository userRepository;

    @Autowired
    public UserContoller(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAllUsers(){
        return  userRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addUser(@RequestBody AddUserRequest addUserRequest){
        User user = new User();
        user.setName(addUserRequest.getName());
        user.setSurName(addUserRequest.getSurName());
        user.setPassword(addUserRequest.getPassword());
        userRepository.save(user);
    }
}
