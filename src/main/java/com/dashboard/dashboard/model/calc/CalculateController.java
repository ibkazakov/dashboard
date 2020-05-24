package com.dashboard.dashboard.model.calc;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class CalculateController {

    @PostMapping("calculate")
    public void calculate(Date calculationDateTime) {

    }
}
