package org.payment.bankCheck.repository;

import org.payment.bankCheck.entities.Check;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckRepository extends JpaRepository<Check,String> {
}
