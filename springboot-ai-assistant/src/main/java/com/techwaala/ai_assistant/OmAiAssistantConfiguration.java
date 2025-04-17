
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
    @Description("Create an order. The Order Id is identified with orderId. "
               + "The order quantity is identified by orderQuantity."
               + "The user is identified by userId. "
               + "The order quantity should be a positive whole number."
               + "If any of the parameters like userId and the order quantity is missing"
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
