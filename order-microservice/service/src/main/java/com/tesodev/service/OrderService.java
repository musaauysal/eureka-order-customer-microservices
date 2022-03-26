package com.tesodev.service;



import com.tesodev.entity.Customer;
import com.tesodev.entity.Ordering;

import java.util.List;

public interface OrderService {

    Ordering create(Ordering ordering);

    Ordering update(Ordering ordering);

    void deleteOrder(Integer orderingId);

    List<Ordering> getAll();

    List<Ordering> getById(Integer orderingId);

    Ordering get(Integer orderingId);


}
