package com.example.shop.order;

import com.example.shop.member.Member;
import com.example.shop.member.MemberRepository;
import com.example.shop.order.dto.OrderCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Long createOrder(OrderCreateRequest request){
        Member member = memberRepository.findById(request.getMemberId());
        if (member == null) {
            throw new RuntimeException("주문할 회원을 찾을 수 없습니다.");
        }

        // String 날짜를 LocalDateTime으로 변환
        LocalDateTime orderDateTime = LocalDateTime.parse(request.getOrderDate());
        Order order = new Order(
                member,
                orderDateTime,
                request.getOrderStatus(),
                request.getOrderPrice(),
                request.getPointUsed(),
                request.getCashAmount()
       );

       orderRepository.save(order);

       return order.getId();
    }

    @Transactional
    public List<Order> getAllOrders() { return orderRepository.findAll(); }

    @Transactional
    public Order getOrderById(Long id){
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
