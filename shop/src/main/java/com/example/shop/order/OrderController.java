package com.example.shop.order;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    // 주문 정보 생성
    @PostMapping()
    public ResponseEntity<Void> createOrder(@RequestBody OrderCreateRequest request){
        Long orderId = orderService.createOrder(request);
        return ResponseEntity.created(URI.create("/orders/" + orderId)).build();
    }

    // 주문 목록 조회
    @GetMapping()
    public ResponseEntity<List<Order>> getAllOrder(){
        // Service 계층에서 주문 목록을 가져온다.
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    // 특정 주문 정보 조회
    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable Long orderId){
        Order order = orderService.getOrderById(orderId);
        return ResponseEntity.ok(order);
    }

    // 주문 취소
    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId){
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build(); // 204 no content
    }
}
