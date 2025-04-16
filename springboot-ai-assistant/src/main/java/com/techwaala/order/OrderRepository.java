package com.techwaala.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<UserOrder, Long> {
//
//    @Query(value = "select o from order_info o where o.userId:=userId")
//    List<OrderInfo> findAllOrderInfoByUserId(Long userId);

    @Query("SELECT o FROM UserOrder o WHERE o.userId = :userId")
    Optional<List<UserOrder>> findAllOrderInfoByUserId(@Param("userId") Long userId);
}
