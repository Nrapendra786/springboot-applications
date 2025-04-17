package com.techwaala.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class OrderManagementService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderManagementService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderManagementService() {

    }

    public Long createOrder(UserOrder userOrder) {
//        if(Objects.isNull(userOrder.getId())){
//            userOrder.setId(orderRepository.count() + 1);
//        }
        return orderRepository.save(userOrder).getId();
    }

    public Optional<List<UserOrder>> getAllUserOrders(Long userId) {
        return orderRepository.findAllOrderInfoByUserId(userId);
    }
}
