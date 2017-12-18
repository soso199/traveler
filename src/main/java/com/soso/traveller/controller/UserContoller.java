package com.soso.traveller.controller;


import com.soso.traveller.entity.User;
import com.soso.traveller.entity.request.AddUserRequest;
import com.soso.traveller.entity.request.ChackUserRequest;
import com.soso.traveller.entity.response.LoginResponse;
import com.soso.traveller.entity.response.ResponseModel;
import com.soso.traveller.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserContoller {
    private UserRepository userRepository;

    @Autowired
    public UserContoller(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<User> findAllUsers(){
        return  userRepository.findAll();
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ResponseModel addUser(@RequestBody AddUserRequest addUserRequest){
        User user = new User();
        user.setName(addUserRequest.getName());
        user.setSurName(addUserRequest.getSurName());
        user.setEmail(addUserRequest.getEmail());
        user.setPassword(addUserRequest.getPassword());
        userRepository.save(user);

        List<User> allUser=userRepository.findAll();
        for (User usr:allUser) {
            if(usr.getEmail()!=null && usr.getEmail().equals(user.getEmail()))
                return new ResponseModel(usr.getId());
            }

        return new ResponseModel(-1);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public LoginResponse checkUser(@RequestBody ChackUserRequest chackUserRequest){
        List<User> allUser=userRepository.findAll();
        for (User user:allUser) {
            if(user.getEmail()!=null && user.getEmail().equals(chackUserRequest.getEmail()) && user.getPassword().equals(chackUserRequest.getPassword())) {
                return new LoginResponse(user.getId(),user.getName());
            }

        }

        return new LoginResponse(-1,"");
    }

}
