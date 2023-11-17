package com.example.copieproject.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.copieproject.response.ResponseMessage;

@Repository
public class LoginDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public ResponseMessage loginUser(String email, String password) {
        try {
            // Cek apakah user dengan email dan password yang diberikan ada di database
            Integer count = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM public.userrs WHERE email = ? AND password = ?",
                Integer.class, email, password);

            if (count > 0) {
                return new ResponseMessage("Login berhasil");
            } else {
                return new ResponseMessage("Email atau password salah");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage("Terjadi error di services: " + e.getMessage());
        }
    }
}
