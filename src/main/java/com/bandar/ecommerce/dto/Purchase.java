package com.bandar.ecommerce.dto;

import java.util.Set;

import com.bandar.ecommerce.entity.Address;
import com.bandar.ecommerce.entity.Customer;
import com.bandar.ecommerce.entity.Order;
import com.bandar.ecommerce.entity.OrderItem;

import lombok.Data;

@Data
public class Purchase {

	private Customer customer;
	private Address shippingAddress;
	private Address billingAddress;
	private Order order;
	private Set<OrderItem> orderItems;
}
