package com.example.demo.services.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class OrderLine {

    private String item;
    private Integer quantity;
    private BigDecimal unitPrice;
}
