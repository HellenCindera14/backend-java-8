package com.example.copieproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.copieproject.dao.RegisterDao;
import com.example.copieproject.model.RegisterUser;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/user")
public class RegisterController {

    @Autowired
    RegisterDao registerDao;

    @PostMapping("/register")
    public String register(@RequestBody RegisterUser user) {
        try {
            String rows = registerDao.registerUser(user);
            return "Berhasil registrasi: " + rows + " row(s)";
        } catch (Exception e) {
            e.printStackTrace();
            return "Terjadi error saat registrasi: " + e.getMessage();
        }
    }
}
