package com.tesodev.repository;

import com.tesodev.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findAllByCustomerId(Integer orderingId);
    Customer findByCustomerId(Integer CustomerId);
    Customer findByCustomerName(String customerName);


    @Modifying
    @Query(value = "delete from customer c where c.customer_id = :customerId ",nativeQuery = true)
    void deleteCustomer(@Param("customerId")Integer customerId);
}
