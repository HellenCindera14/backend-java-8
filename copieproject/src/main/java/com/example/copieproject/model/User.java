package com.example.copieproject.model;

public class User {
    private int id;
    private String name;
    private String email;
    private String saldo;

    public User() {
    }

    public User(int id, String name, String email, String saldo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Userrs [id=" + id + ", name=" + name + ", email=" + email + ", saldo=" + saldo + "]";
    }
    
}
