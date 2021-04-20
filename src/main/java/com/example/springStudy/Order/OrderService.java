package com.example.springStudy.Order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
