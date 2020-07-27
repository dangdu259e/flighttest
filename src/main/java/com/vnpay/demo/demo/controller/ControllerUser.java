package com.vnpay.demo.demo.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vnpay.app.demo.entity.Person;
import com.vnpay.demo.demo.Object.DataSend;
import com.vnpay.demo.demo.entity.BookingForm;
import com.vnpay.demo.demo.entity.Transport;
import com.vnpay.demo.demo.jsonObject.Flight;
import com.vnpay.demo.demo.model.SearchForm;
import com.vnpay.demo.demo.repository.TransportDAO;
import com.vnpay.demo.demo.service.TransportService;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Controller  //không được thao tác ở DAO phải thao tác với tầng service
public class ControllerUser {
    // cần phải moi ra từ chuỗi json trả về các chuyến bay theo tuần
    // trong 1 ngày thì phải lấy đc list chuyến bay trong 1 ngày
    // từ cái list view data thông tin chi tiết 1 chuyến bay như cái form
    @Autowired
    TransportDAO transportDAO;
    @Autowired
    TransportService transportService;

    @GetMapping(value = "/")
    public String home(Model model){
       List<Transport>list = transportDAO.findAll();

        model.addAttribute("transport", new Transport());
        model.addAttribute("list", list);
        return "index";
    }
    @PostMapping(value = "/SearchForm")
        public String saveBooking(Model modelbooking,
            @ModelAttribute("searchform") SearchForm searchForm){
                modelbooking.addAttribute("searchform",searchForm);
                return "Result";
        }


//    @PostMapping(value = "call_result")
//    public String callresult(Transport transport,Model model){
//        model.addAttribute("searchform",transportService.getAllTransport());
//        return "Result";
//    }

    @PostMapping(value = "call_result")
    public String callresult(BookingForm bookingForm, Model model) throws JsonProcessingException {
        model.addAttribute("bookingForm",bookingForm);
        DataSend dataSend = new DataSend();

        //formart date
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        if(bookingForm.getItinerary_type().equals("1")){
            bookingForm.setReturn_date(bookingForm.getDepart_date());
        }
        bookingForm.setDepart_date(simpleDateFormat.format(new Date(bookingForm.getDepart_date())));
        bookingForm.setReturn_date(simpleDateFormat.format(new Date(bookingForm.getReturn_date())));
        dataSend.setFormSend(bookingForm);

        ObjectMapper objectMapper = new ObjectMapper();
        String a = objectMapper.writeValueAsString(dataSend);
        model.addAttribute("datasend",a);
        //
        String url = "https://vnticket.vnpaytest.vn/vnticketapi/search_flight_qh?data={data}";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class, a);
        System.out.println(result);
        model.addAttribute("searchForm", result);

        //Json to Object
        Gson gson = new Gson();
        Flight flight = gson.fromJson(result,Flight.class);
        flight.toString();
        return  "Result";
    }

    @GetMapping(value = "/DatVe")
    public String DatVe (Model model){
        model.addAttribute("bookingForm", new BookingForm());
        model.addAttribute("airports",transportService.getAllTransport());
        return "DatVe";
    }
    @GetMapping(value = "/DatVe-B2")
    public String DatVeB2(){
        return "DatVe-B2";
    }
    @GetMapping(value = "/DatVe-B2-detail")
    public String DatVeB2detail(){
        return "DatVe-B2-detail";
    }
    @GetMapping(value = "/DatVe-B3")
    public String DatVeB3(){
        return "DatVe-B3";
    }
    @GetMapping(value = "/DatVe-B4")
    public String DatVeB4(){
        return "DatVe-B4-error";
    }
    @GetMapping(value = "/DatVe-B5")
    public String DatVeB5(){
        return "DatVe-B5";
    }

//    @PostMapping(value = "/control")

//    @PostMapping(value = "/save")
//    public String postt(Model model, @ModelAttribute ("searchform"), SearchForm searchForm){
//        model.addAttribute()
//        return "save"
//    }

//    @GetMapping(value = "/apicontroller")
//    public String ApiController(Model model){
//        model.addAttribute("message",)
//        return "index";
//    }
}
