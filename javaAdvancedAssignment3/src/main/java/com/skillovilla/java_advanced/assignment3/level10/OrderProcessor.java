package com.skillovilla.java_advanced.assignment3.level10;

import java.util.List;
import java.util.stream.Collectors;

public class OrderProcessor {
    public List<String> getProductNamesInOrders(List<Order> orders){
        return orders.stream()
                .flatMap(order -> order.getProducts().stream())
                .map(Product::getName)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}
