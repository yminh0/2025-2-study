package com.example.shop.order.dto;

import lombok.Getter;
import lombok.NoArgsConstructor; //

@Getter
@NoArgsConstructor //
public class OrderCreateRequest {

    private Long memberId;

    private String orderStatus;
    private String orderDate;
    private int orderPrice;
    private int pointUsed;
    private int cashAmount;

}