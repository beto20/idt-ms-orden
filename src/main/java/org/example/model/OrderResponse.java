package org.example.model;

import java.util.List;

public class OrderResponse {

    public OrderResponse(String clientName, String clientLastname, double amount) {
        this.clientName = clientName;
        this.clientLastname = clientLastname;
        this.amount = amount;
    }

    private long id;
    private String clientName;
    private String clientLastname;
    private double amount;
    private List<Product> products;

    public static class Product {
        public Product(String name, String description, int quantity, double price) {
            this.name = name;
            this.description = description;
            this.quantity = quantity;
            this.price = price;
        }

        private String name;
        private String description;
        private int quantity;
        private double price;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientLastname() {
        return clientLastname;
    }

    public void setClientLastname(String clientLastname) {
        this.clientLastname = clientLastname;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
