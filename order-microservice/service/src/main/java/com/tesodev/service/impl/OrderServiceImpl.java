package com.tesodev.service.impl;



import com.tesodev.entity.Ordering;
import com.tesodev.repository.OrderRepository;
import com.tesodev.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Ordering create(Ordering ordering) {
        return orderRepository.save(ordering);
    }

    @Override
    public Ordering update(Ordering ordering) {
        return orderRepository.save(ordering);
    }

    @Override
    @Transactional
    public void deleteOrder(Integer orderingId) {
        orderRepository.deleteOrder(orderingId);
    }

    @Override
    public List<Ordering> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Ordering> getById(Integer orderingId) {
        return orderRepository.findAllByOrderingId(orderingId);
    }

    @Override
    public Ordering get(Integer orderingId) {
        return orderRepository.findByOrderingId(orderingId);
    }

}
