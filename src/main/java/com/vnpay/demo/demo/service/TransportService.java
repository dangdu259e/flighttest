package com.vnpay.demo.demo.service;

import com.vnpay.demo.demo.entity.Transport;
import com.vnpay.demo.demo.repository.TransportDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransportService {
    @Autowired
    TransportDAO transportDAO;
    public Iterable<Transport> getAllTransport(){
        return this.transportDAO.findAll();
    }
    public Transport findById(int id){
        return transportDAO.findById(id).get();
    }
    public void deleteTransport(Transport trans){
        transportDAO.delete(trans);
    }
    public Transport addTransport(Transport trans){
        return transportDAO.save(trans);
    }
}
