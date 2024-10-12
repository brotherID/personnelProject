package org.payment.bankCheck.repository;


import org.payment.bankCheck.entities.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Authorities,Long> {
    Optional<Authorities> findByUsername(String name);
}
