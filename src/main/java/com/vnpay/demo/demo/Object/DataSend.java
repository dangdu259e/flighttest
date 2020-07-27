package com.vnpay.demo.demo.Object;

import com.vnpay.demo.demo.entity.BookingForm;
import com.vnpay.demo.demo.model.SearchForm;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Getter
@Setter
public class DataSend {
    private String original;
    private String destination;
    //
    private String itinerary_type ;

//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//    private LocalDate depart_date;
    private String depart_date;

//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//    private LocalDate return_date;
    private String return_date;

    private Integer adult;
    private Integer child;
    private Integer infant;


    private  String[] prefer_airline= {"VN"};

    private String[] prefer_classify={"VN-ECO","VJ-ECO","QH-ECO"};
    private String mobile = "0975966872";
    private String app_id = "VCB|EN";
    private String request_id= "94ba4be546e84a87a78c4b134c76d54e";
    private String request_date= "20200529140525";
    private String checksum="0";
    private String version="2.0";
//    private SearchForm searchForm;

    public void setFormSend(BookingForm bookingForm){
        this.original = bookingForm.getOriginal();
        this.destination = bookingForm.getDestination();
        this.itinerary_type= bookingForm.getItinerary_type();
        this.depart_date = bookingForm.getDepart_date();
        this.return_date = bookingForm.getReturn_date();
        this.adult = bookingForm.getAdult();
        this.child = bookingForm.getChild();
        this.infant = bookingForm.getInfant();
    }
}
