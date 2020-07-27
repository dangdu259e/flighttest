package com.vnpay.demo.demo.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TranResponse {
    private Integer id;
    private String transport;

    public String toString() {
        return transport;
    }
}
