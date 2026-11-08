package org.example.model;

import java.util.List;

public class OrderRequest {

    public OrderRequest() {
    }


    public OrderRequest(String clientName, String clientLastname) {
        this.clientName = clientName;
        this.clientLastname = clientLastname;
    }

    private long id;
    private String clientName;
    private String clientLastname;
    private List<Product> products;

    public static class Product {
        public Product() {
        }

        public Product(String name, int quantity, double price) {
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }

        private String name;
        private int quantity;
        private double price;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
