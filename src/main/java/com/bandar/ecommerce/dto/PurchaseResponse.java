package com.bandar.ecommerce.dto;

import lombok.Data;

@Data		// generate constructor for final fields
public class PurchaseResponse {

	private final String orderTrackingNumber;
}
