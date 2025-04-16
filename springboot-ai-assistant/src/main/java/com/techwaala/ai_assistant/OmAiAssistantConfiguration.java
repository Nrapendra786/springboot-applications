
package com.techwaala.ai_assistant;

import com.techwaala.order.OrderManagementService;
import com.techwaala.order.UserOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import java.util.List;
import java.util.function.Function;

@Configuration
public class OmAiAssistantConfiguration {

    @Bean
    @Description("Create an order. The Order ID is identified with orderID. "
               + "The order quantity is identified by orderQuantity."
               + "The user is identified by userID. "
               + "The order quantity should be a positive whole number."
               + "If any of the parameters like user id and the order quantity is missing"
               + "then ask the user to provide the missing information.")
    public Function<CreateOrderRequest, Long> createOrderFn(OrderManagementService orderManagementService) {
        return createOrderRequest -> orderManagementService.createOrder(createOrderRequest.userOrder());
    }

    @Bean
    @Description("get all the orders of an user. The user ID is identified with userID.")
    public Function<GetOrderRequest, List<UserOrder>> getUserOrdersFn(OrderManagementService orderManagementService) {
        return getOrderRequest -> orderManagementService.getAllUserOrders(getOrderRequest.userId()).get();
    }
}
