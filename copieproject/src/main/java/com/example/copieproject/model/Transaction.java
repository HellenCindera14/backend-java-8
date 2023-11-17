package com.example.copieproject.model;

public class Transaction {
    private int id;
    private int userId;
    private int productId;
    
    public Transaction() {
    }

    public Transaction(int id, int userId, int productId) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Transaction [id=" + id + ", userId=" + userId + ", productId=" + productId + "]";
    }

    




    



    

  




    
    
}
