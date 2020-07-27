package com.vnpay.app.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ticket_id")
    private Integer ticketid;

    @Column(name = "payment_id")
    private Integer paymentid;

    @Column(name = "flight_id")
    private Integer flightid;

    @Column(name = "class")
    private String classname;

    @Column(name = "seat_number")
    private String seat_number;

    @Column(name = "owner_id")
    private Integer ownerid;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "id")
    private Integer id;

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketid=" + ticketid +
                ", paymentid=" + paymentid +
                ", flightid=" + flightid +
                ", classname='" + classname + '\'' +
                ", seat_number='" + seat_number + '\'' +
                ", ownerid=" + ownerid +
                ", cost=" + cost +
                ", id=" + id +
                '}';
    }
}
