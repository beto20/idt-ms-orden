package org.example.service;

import org.example.model.OrderRequest;
import org.example.model.OrderResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final List<OrderResponse> registeredOrders = new ArrayList<>();
    private long nextId = 1005L;

//    @Autowired
//    OrderRepository repository;

    @Override
    public synchronized List<OrderResponse> getOrders() {
//        repository.getOrders();

        // 1. Orden Electrónica / Tech
        OrderResponse order1 = new OrderResponse("Ana", "Martínez", 1649.97);
        order1.setId(1001L);
        order1.setProducts(List.of(
                new OrderResponse.Product("Monitor 4K 27\"", "Monitor IPS UHD 144Hz", 1, 450.00),
                new OrderResponse.Product("Laptop Gamer", "Intel i7, 32GB RAM, RTX 4060", 1, 1199.97)
        ));

        // 2. Orden de Artículos de Oficina
        OrderResponse order2 = new OrderResponse("Carlos", "Gómez", 385.50);
        order2.setId(1002L);
        order2.setProducts(List.of(
                new OrderResponse.Product("Silla Ergonómica", "Silla de oficina con soporte lumbar", 1, 280.00),
                new OrderResponse.Product("Lámpara LED", "Lámpara de escritorio regulable USB", 2, 35.00),
                new OrderResponse.Product("Organizador de Escritorio", "Organizador metálico negro", 1, 35.50)
        ));

        // 3. Orden de Fotografía / Video
        OrderResponse order3 = new OrderResponse("Lucía", "Fernández", 2430.00);
        order3.setId(1003L);
        order3.setProducts(List.of(
                new OrderResponse.Product("Cámara Mirrorless", "Cámara 24MP con objetivo 18-55mm", 1, 1800.00),
                new OrderResponse.Product("Trípode de Carbono", "Trípode ligero para viajes", 1, 250.00),
                new OrderResponse.Product("Tarjeta SD 256GB", "Tarjeta de memoria alta velocidad V60", 2, 190.00)
        ));

        // 4. Orden de Audio y Accesorios
        OrderResponse order4 = new OrderResponse("Diego", "Vargas", 149.95);
        order4.setId(1004L);
        order4.setProducts(List.of(
                new OrderResponse.Product("Audífonos Inalámbricos", "Cancelación de ruido activa ANC", 1, 129.95),
                new OrderResponse.Product("Cable USB-C 2m", "Cable de carga rápida trenzado", 2, 10.00)
        ));

        List<OrderResponse> orders = new ArrayList<>(List.of(order1, order2, order3, order4));
        orders.addAll(registeredOrders);
        return orders;
    }

    @Override
    public synchronized boolean saveOrder(OrderRequest request) {
        if (request == null || request.getClientName() == null || request.getClientName().isBlank()
                || request.getClientLastname() == null || request.getClientLastname().isBlank()
                || request.getProducts() == null || request.getProducts().isEmpty()) {
            return false;
        }
        List<OrderResponse.Product> products = new ArrayList<>();
        double amount = 0;
        for (OrderRequest.Product product : request.getProducts()) {
            if (product == null || product.getName() == null || product.getName().isBlank()
                    || product.getQuantity() <= 0 || product.getPrice() <= 0
                    || !Double.isFinite(product.getPrice())) {
                return false;
            }
            products.add(new OrderResponse.Product(product.getName().trim(), "",
                    product.getQuantity(), product.getPrice()));
            amount += product.getQuantity() * product.getPrice();
        }
        OrderResponse order = new OrderResponse(request.getClientName().trim(),
                request.getClientLastname().trim(), Math.round(amount * 100.0) / 100.0);
        order.setId(nextId++);
        order.setProducts(products);
        registeredOrders.add(order);
        return true;
    }
}
