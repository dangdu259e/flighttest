package com.vnpay.demo.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
@Getter
@Setter
public class BookingForm {
    private String original;
    private String destination;
    private String itinerary_type = "2";
    private String depart_date;
    private String return_date;
    private int adult;
    private int child;
    private int infant;

    @Override
    public String toString() {
        return "BookingForm{" +
                "original='" + original + '\'' +
                ", destination='" + destination + '\'' +
                ", depart_date='" + depart_date + '\'' +
                ", return_date='" + return_date + '\'' +
                ", adult=" + adult +
                ", child=" + child +
                ", infant=" + infant +
                '}';
    }
    //
//    public LocalDate getOrig_date() {
//        return orig_date;
//    }
//
//    public void setOrig_date(LocalDate orig_date) {
//        this.orig_date = orig_date;
//    }
//
//    public LocalDate getDes_date() {
//        return des_date;
//    }

//    public void setDes_date(LocalDate des_date) {
//        this.des_date = des_date;
//    }



}
