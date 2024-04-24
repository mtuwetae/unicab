package com.jemgroup.unicab.service;

import com.jemgroup.unicab.dto.OrderDTO;
import com.jemgroup.unicab.entity.Order;
import com.jemgroup.unicab.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Order saveOrder(OrderDTO orderDTO){
        Order orderDetails = new Order();
        orderDetails.setPickupLocation(orderDTO.getPickupLocation());
        orderDetails.setSeatAvailability(orderDTO.getSeatAvailability());
        orderDetails.setDestinationRoute(orderDTO.getDestinationRoute());
        orderDetails.setEmptySeatAvailability(orderDTO.getEmptySeatAvailability());
        try {
            orderRepository.save(orderDetails);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return orderDetails;
    }
}
