package com.example.copieproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.copieproject.dao.ProductDao;
import com.example.copieproject.dao.TransactionDao;
import com.example.copieproject.dao.UserDao;
import com.example.copieproject.model.Product;
import com.example.copieproject.model.Transaction;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Transaction")
public class TransactionController {

    @Autowired
    TransactionDao transactionDao;

    @Autowired
    ProductDao productDao;

    @Autowired
    UserDao userDao;

    @PostMapping("/beli")
    public ResponseEntity<String> save(@RequestBody Transaction transaction) {
        try {
            int rows = transactionDao.save(transaction);
            if (rows >= 1) {
                Product product = productDao.getProductById(transaction.getProductId());
                int rowsUpdated = productDao.updateProductById(product.getId()); // asumsi ada metode untuk memperbarui product
                return new ResponseEntity<>("Order baru telah disimpan. Jumlah baris diperbarui: " + rowsUpdated, HttpStatus.CREATED);
            }
            return new ResponseEntity<>("Gagal menyimpan. ID harus unik: " + rows, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Terjadi kesalahan server", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
