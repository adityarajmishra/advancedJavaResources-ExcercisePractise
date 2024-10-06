package com.skillovilla.java_advanced.assignment3.level10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Level11Test {

    private Class<?> orderProcessorClass;
    private Object orderProcessorInstance;

    @BeforeEach
    void setUp() throws Exception {
        orderProcessorClass = Class.forName("com.skillovilla.java_advanced.assignment3.level10.OrderProcessor");
        orderProcessorInstance = orderProcessorClass.getDeclaredConstructor().newInstance();
    }

    @Test
    void testGetProductNamesInOrders() throws Exception {
        Method getProductNamesInOrdersMethod = orderProcessorClass.getMethod("getProductNamesInOrders", List.class);

        Product product1 = new Product("Laptop");
        Product product2 = new Product("Smartphone");
        Product product3 = new Product("Tablet");

        Order order1 = new Order(Arrays.asList(product1, product2));
        Order order2 = new Order(Arrays.asList(product2, product3));

        List<Order> orders = Arrays.asList(order1, order2);
        List<String> result = (List<String>) getProductNamesInOrdersMethod.invoke(orderProcessorInstance, orders);

        assertEquals(Arrays.asList("Laptop", "Smartphone", "Tablet"), result);
    }
}
