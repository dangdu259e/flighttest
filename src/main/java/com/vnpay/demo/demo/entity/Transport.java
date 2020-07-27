package com.vnpay.demo.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "transport")
public class Transport {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private String id;

    @Column(name = "transport")
    private String transport;

    @Override
    public String toString() {
        return transport;
    }
}
