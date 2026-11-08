package org.example.controller;

import org.example.model.OrderRequest;
import org.example.model.OrderResponse;
import org.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/orders/")
@RestController
@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500"})
public class OrderController {
    @Autowired
    OrderService service;

    @GetMapping
    public List<OrderResponse> getOrders() {
        return service.getOrders();
    }

    @PostMapping("register")
    public boolean saveOrder(@RequestBody OrderRequest request) {
        return service.saveOrder(request);
    }
}
