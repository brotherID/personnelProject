package org.payment.bankCheck.repository;

import org.payment.bankCheck.entities.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository  extends JpaRepository<Discount,String> {
}
