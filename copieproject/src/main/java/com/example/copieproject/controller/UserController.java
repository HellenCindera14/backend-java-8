package com.example.copieproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.copieproject.dao.UserDao;
import com.example.copieproject.model.User;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @PostMapping("/save")
    public String save( @RequestBody User user) {
        try {
            String rows = userDao.createUser(user);
            return "Berhasil menyimpan new user: " + rows;
        } catch (Exception e) {
            e.printStackTrace();
            return "Cannot save users: " + e.getMessage();
        } 
    }

    @PostMapping("/update/{userId}")
    public String update(@PathVariable Long userId, @RequestBody User user) {
        try {
            // Pass userId to the updateUser method
            String rows = userDao.updateUser(userId, user);
            return "Berhasil mengupdate user: " + rows;
        } catch (Exception e) {
            e.printStackTrace();
            return "Cannot update users: " + e.getMessage();
        }
    }
    

    @GetMapping("/delete/{userId}")
    public String delete(@PathVariable("userId") int id) {
        try {
            String rows = userDao.deleteUser(id);
            return "Berhasil menghapus user: " + rows;
        } catch (Exception e) {
            e.printStackTrace();
            return "Cannot delete users: " + e.getMessage();
        }
    }  
}
