package com.example.shop.order;

import com.example.shop.member.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Getter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // 지연 로딩, 필요할 때만 가져옴
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "order_data")
    private LocalDateTime orderData;

    @Column(name = "total_price")
    private int totalPrice;

    @Column(name = "point_used")
    private int pointUsed;

    @Column(name = "cash_amount")
    private int cashAmount;

    @Column(name = "status", length = 25)
    private String status; // 대기중, 배송중, 배송완료...

    public Order(Member member, LocalDateTime orderData, String status, int totalPrice, int pointUsed, int cashAmount) {
        this.member = member;
        this.orderData = orderData;
        this.status = status;
        this.totalPrice = totalPrice;
        this.pointUsed = pointUsed;
        this.cashAmount = cashAmount;
    }
}
