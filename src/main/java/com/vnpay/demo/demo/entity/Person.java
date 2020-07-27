package com.vnpay.app.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Integer personid;

    @Column(name = "person_name")
    private String personname;

    @Override
    public String toString() {
        return "Person{" +
                "personid=" + personid +
                ", personname='" + personname + '\'' +
                '}';
    }
}
