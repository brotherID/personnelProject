package org.payment.bankCheck.service;

import org.payment.bankCheck.dtos.DiscountDTO;

public interface DiscountService {

    DiscountDTO createDiscount(DiscountDTO discountDTO);
    DiscountDTO  getDiscountByIdDiscount(String idDiscount);
}
