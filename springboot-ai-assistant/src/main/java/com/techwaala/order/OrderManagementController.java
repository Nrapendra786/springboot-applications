package com.techwaala.order;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order_management_application")
public class OrderManagementController {

    private final OrderManagementService orderManagementService;

    public OrderManagementController(OrderManagementService orderManagementService){
        this.orderManagementService=orderManagementService;
    }

    @PostMapping("/createOrder")
    public ResponseEntity<?> createOrder(@RequestBody UserOrder orderInfo) {
          var orderId = orderManagementService.createOrder(orderInfo);
          return ResponseEntity.status(HttpStatus.CREATED).body("Order ID " + orderId + " is created");
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> findUserOrder(@PathVariable("userId") Long userId) {
        var userOrders = orderManagementService.getAllUserOrders(userId);
        if(userOrders.isPresent()){
            return ResponseEntity.ok().body(userOrders.get());
        }
        return ResponseEntity.noContent().build();
    }
}