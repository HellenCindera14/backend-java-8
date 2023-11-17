package com.example.copieproject.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.copieproject.model.Transaction;

@Repository
public class TransactionDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public String saveTransaction(Transaction transaction) {
        try {
            int rows = jdbcTemplate.update(
                    "INSERT INTO public.transaction (id,user_id, product_id) VALUES (?, ?, ?)",
                    new Object[] { transaction.getId(), transaction.getUserId(), transaction.getProductId() });
            return "berhasil: " + rows;
        }catch (Exception e) {
            e.printStackTrace();
            return "tidak berhasil disimpan: " + e.getMessage();
        }
    }

    public String deleteTransaction(Transaction transaction) {
        try {
            int rows = jdbcTemplate.update("DELETE FROM public.transaction WHERE id= ?",
                    new Object[] { transaction.getId() });
            return "berhasil: " + rows;
        } catch (Exception e) {
            e.printStackTrace();
            return "tidak berhasil disimpan: " + e.getMessage();
        }
        
    }

    public String updateTransaction(Transaction transaction) {
        try {
            int rows = jdbcTemplate.update("UPDATE * from transaction SET user_id= ? WHERE id=?",
                    new Object[] { transaction.getUserId(), transaction.getId() });
            return "berhasil" + rows;
        } catch (Exception e) {
            e.printStackTrace();
            return "gagal: " + e.getMessage();
        }
    }

    public int save(Transaction transaction) {
        return 0;
    }
}
