package com.example.copieproject.controller;

import com.example.copieproject.dao.LoginDao;
import com.example.copieproject.model.LoginUser;
import com.example.copieproject.response.ResponseMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/user")
public class LoginController {

    @Autowired
    private LoginDao loginDao;

    @PostMapping("/login")
    public ResponseEntity<ResponseMessage> login(@RequestBody LoginUser loginUser) {
        try {
            ResponseMessage response = loginDao.loginUser(loginUser.getEmail(), loginUser.getPassword());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ResponseMessage("Terjadi error saat login: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
