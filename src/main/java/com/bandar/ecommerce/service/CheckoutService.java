package com.bandar.ecommerce.service;

import com.bandar.ecommerce.dto.Purchase;
import com.bandar.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

	PurchaseResponse placeOrder(Purchase purchase);
}
