package com.example.demo.services;

import com.example.demo.services.dto.Order;
import com.example.demo.services.dto.OrderLine;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.swagger.parser.OpenAPIParser;
import io.swagger.v3.parser.core.models.SwaggerParseResult;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Service
public class Processor {



    public boolean doProcessor() throws IOException {

        // READ Json
        SwaggerParseResult result = new OpenAPIParser().readLocation("swagger.json", null, null);

        final var paths = result.getOpenAPI().getPaths();


        // Read YAML
        final var mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();


        final var value = mapper.readValue(new File("src/main/resources/test.yml"), Order.class);
        mapper.readValue(new File("src/main/resources/test.yml"), Order.class);

        // WRITE YAML
        final var test = new Order();
        test.setOrderNo("xpt11")
                .setOrderLines(List.of(
                        new OrderLine()
                        .setUnitPrice(BigDecimal.valueOf(10.209))
                        .setItem("Item")
                        .setQuantity(1022)
                ));
        mapper.writeValue(new File("src/main/resources/test2.yml"), test);


        return Boolean.TRUE;
    }
}
