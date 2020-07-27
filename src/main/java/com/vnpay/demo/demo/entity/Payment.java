package com.vnpay.app.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "payer_id")
    private Integer payerid;

    @Column(name = "cost")
    private Integer cost;

    @Column(name = "status")
    private Boolean status;

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", payerid=" + payerid +
                ", cost=" + cost +
                ", status=" + status +
                '}';
    }
}
