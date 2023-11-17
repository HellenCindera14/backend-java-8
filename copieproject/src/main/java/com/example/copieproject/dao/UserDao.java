package com.example.copieproject.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.copieproject.model.User;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String  createUser(User user) {
        try {
            Integer rows = jdbcTemplate.update(
                    "INSERT INTO public.userrs (name, email, saldo) VALUES (?, ?, ?)",
                    new Object[] {user.getName(), user.getEmail(), user.getSaldo()});
            return "Berhasil menyimpan new user: " + rows.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Terjadi error di services: " + e.getMessage();
        }
    }

     public String updateUser(Long userId, User user) {
        String query = "UPDATE userrs SET name = ?, email = ? WHERE id = ?";
        
        try {
            int rowsUpdated = jdbcTemplate.update(query, user.getName(), user.getEmail(), userId);
            
            if (rowsUpdated > 0) {
                return "Berhasil mengupdate user. Jumlah baris yang diperbarui: " + rowsUpdated;
            } else {
                return "Gagal mengupdate user. User dengan ID " + userId + " tidak ditemukan.";
            }
        } catch (DataAccessException e) {
            throw new RuntimeException("Kesalahan saat mengupdate pengguna", e);
        }
    }

    public String deleteUser(int id) {
        try {
            Integer rows = jdbcTemplate.update(
                    "DELETE FROM public.userrs WHERE id = ?",
                    new Object[] {id});
            return "Berhasil menghapus user: " + rows.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Terjadi error di services: " + e.getMessage();
        }
    }

    public String getUserId(int userId) {
        return null;
    }
}
