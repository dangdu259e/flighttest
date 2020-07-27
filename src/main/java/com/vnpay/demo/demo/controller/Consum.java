package com.vnpay.demo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.html.parser.Entity;
import java.util.Arrays;

@Controller
public class Consum {
    @Autowired
    RestTemplate restTemplate;
    @GetMapping(value = "/content")
    public String getAirway(Model model){
        String url = "https://vnticket.vnpaytest.vn/vnticketapi/search_flight_qh?data={data}";
        String result = restTemplate.getForObject(url, String.class, "{\"original\":\"HAN\",\"destination\":\"DAD\",\"itinerary_type\":\"2\",\"depart_date\":\"2020-08-15\",\"return_date\":\"2020-08-20\",\"adult\":1,\"child\":1,\"infant\":0,\"prefer_airline\":[\"VN\"],\"prefer_classify\":[\"VN-ECO\",\"VJ-ECO\",\"QH-ECO\"],\"mobile\":\"0975966872\",\"app_id\":\"VCB|EN\",\"request_id\":\"94ba4be546e84a87a78c4b134c76d54e\",\"request_date\":\"20200529140525\",\"checksum\":\"0\",\"version\":\"2.0\"}");
        model.addAttribute("searchform", result);
        return "call_api";

    }
}
