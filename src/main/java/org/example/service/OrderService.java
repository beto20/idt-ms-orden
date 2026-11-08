package org.example.service;

import org.example.model.OrderRequest;
import org.example.model.OrderResponse;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface OrderService {
    List<OrderResponse> getOrders();
    boolean saveOrder(@RequestBody OrderRequest request);
}
