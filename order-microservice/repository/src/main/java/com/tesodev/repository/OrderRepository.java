package com.tesodev.repository;

import com.tesodev.entity.Ordering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Ordering, Integer> {
    List<Ordering> findAllByOrderingId(Integer orderingId);
    Ordering findByOrderingId(Integer orderingId);


    @Modifying
    @Query(value = "delete from ordering o where o.ordering_id = :orderingId ",nativeQuery = true)
    void deleteOrder(@Param("orderingId")Integer orderingId);
}
