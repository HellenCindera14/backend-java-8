package com.example.copieproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.copieproject.dao.ProductDao;
import com.example.copieproject.model.Product;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @PostMapping("/save")
    public String saveProduct(@RequestBody Product product) {
        try {
            productDao.createProduct(product);
            return "Berhasil menyimpan new product: " + product.getId();

        } catch (Exception e) {
            e.printStackTrace();
            return "Cannot save products: " + e.getMessage();
        }
    }

    @PostMapping("/update")
    public String updateProduct(@RequestBody Product product) {
        try {
            productDao.updateProduct(product.getId(), product);
            return "Berjay mengupdate product: " + product.getId();
        } catch (Exception e) {
            e.printStackTrace();
            return "Cannot update products: " + e.getMessage();
        }

    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        try {
            productDao.deleteProduct(id);
            return "Berjay menghapus product: " + id;
        } catch (Exception e) {
            e.printStackTrace();
            return "Cannot delete products: " + e.getMessage();
        }
    }
}
