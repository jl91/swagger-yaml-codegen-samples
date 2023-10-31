package com.example.demo.services.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Order {
    private String orderNo;
    private List<OrderLine> orderLines;
}
