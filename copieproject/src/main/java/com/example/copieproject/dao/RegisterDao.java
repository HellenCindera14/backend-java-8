package com.example.copieproject.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.copieproject.model.RegisterUser;

@Repository
public class RegisterDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String registerUser(RegisterUser user) {
        try {
            Integer rows = jdbcTemplate.update(
                    "INSERT INTO public.userrs (name, email, password) VALUES (?, ?, ?)",
                    new Object[] {user.getName(), user.getEmail(), user.getPassword()});
            return rows.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Terjadi error di services: " + e.getMessage();
        }
    }
}
