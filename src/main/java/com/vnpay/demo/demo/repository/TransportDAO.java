package com.vnpay.demo.demo.repository;

import com.vnpay.demo.demo.entity.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportDAO extends JpaRepository<Transport,Integer> {
}
