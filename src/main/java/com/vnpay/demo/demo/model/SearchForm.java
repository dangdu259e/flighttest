package com.vnpay.demo.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class SearchForm {
    private String original;
    private String destination;
    //
    //private Integer itinerary_type = 2;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate depart_date;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate return_date;

    private Integer adult;
    private Integer child;
    private Integer infant;
}
