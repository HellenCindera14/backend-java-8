package com.example.copieproject.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.copieproject.model.Product;

@Repository
public class ProductDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

   public String createProduct(Product product) {
    try {
        String sql = "INSERT INTO products (id, name, price) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, product.getId(), product.getName(), product.getPrice());
        return "Berhasil menyimpan new product: " + product.getId();
    }catch (Exception e) {
        e.printStackTrace();
        return "Cannot save products: " + e.getMessage();
    }
   }

   public String updateProduct(long productId, Product product) {
    try {
        String sql = "UPDATE product SET name = ?, price = ? WHERE id = ?";
        jdbcTemplate.update(sql, product.getName(), product.getPrice(), productId);
        return "Berjay mengupdate product: " + productId;
    }catch (Exception e) {
        e.printStackTrace();
        return "Cannot update products: " + e.getMessage();
    }
   }

   public String deleteProduct(int id) {
    try {
        String sql = "DELETE FROM product WHERE id = ?";
        jdbcTemplate.update(sql, id);
        return "Berjay menghapus product: " + id;
    }catch (Exception e) {
        e.printStackTrace();
        return "Cannot delete products: " + e.getMessage();
    }
   }

public Product getProductById(int productId) {
    return null;
}

public int updateProductById(int id) {
    return 0;
}
}
