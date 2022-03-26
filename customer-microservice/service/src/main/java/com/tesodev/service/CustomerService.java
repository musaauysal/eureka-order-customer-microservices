package com.tesodev.service;

import com.tesodev.common.exception.BusinessException;
import com.tesodev.entity.Customer;
import java.util.List;

public interface CustomerService {
    Customer retrieveCustomerByCustomerName(String customerName);

    Customer create(Customer customer) throws BusinessException;

    Customer update(Customer customer) throws BusinessException;

    void deleteCustomer(Integer customerId);

    List<Customer> getAll();

    List<Customer> getById(Integer customerId);

    Customer get(Integer customerId);


}
