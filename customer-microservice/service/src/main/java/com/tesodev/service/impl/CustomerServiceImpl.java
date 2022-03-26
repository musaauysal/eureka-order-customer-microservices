package com.tesodev.service.impl;


import com.tesodev.entity.Customer;
import com.tesodev.repository.CustomerRepository;
import com.tesodev.service.CustomerService;
import com.tesodev.service.validator.CustomerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

 @Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
     CustomerValidator customerValidator;

     @Override
     public Customer retrieveCustomerByCustomerName(String customerName) {
         return customerRepository.findByCustomerName(customerName);
     }

    @Transactional
    @Override
    public Customer create(Customer customer) {
       customerValidator.validateSaveForStopCauseDatabase(customer);
       return customerRepository.save(customer);
    }

    @Transactional
    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    @Transactional
    public void deleteCustomer(Integer customerId) {
        customerRepository.deleteCustomer(customerId);
    }

    @Override
    public List<Customer> getAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public List<Customer> getById(Integer customerId) {
        return customerRepository.findAllByCustomerId(customerId);
    }

    @Override
    public Customer get(Integer customerId) {
        return customerRepository.findByCustomerId(customerId);
    }

}
