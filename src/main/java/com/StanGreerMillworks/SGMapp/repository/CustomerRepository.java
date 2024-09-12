package com.StanGreerMillworks.SGMapp.repository;

import com.StanGreerMillworks.SGMapp.domain.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerInfo, Long> {
    Optional<CustomerInfo> findByPhone1OrPhone2(String phone1, String phone2);
}
