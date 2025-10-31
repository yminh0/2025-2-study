package com.example.shop.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    public Long createOrder(OrderCreateRequest request){
       Order order = new Order(
               request.getOrderId(),
               request.getOrderDate(),
               request.getOrderStatus()
       );

       orderRepository.save(order);

       return order.getId();
    }

    @Transactional
    public List<Order> getAllOrders() { return orderRepository.findAll(); }

    @Transactional
    public Order getOrder(Long id){
        Order order = orderRepository.findById(id);

        if(order == null){
            throw new RuntimeException("주문 정보를 찾을 수 없습니다.");
        }

        return order;
    }

    @Transactional
    public void deleteOrder(Long id){
        Order order = orderRepository.findById(id);

        if (order == null){
            throw new RuntimeException("주문 정보를 찾을 수 없습니다.");
        }

        // Repository를 통해 삭제
        orderRepository.deleteById(id);
    }
}
