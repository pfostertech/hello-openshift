package com.example.demo;

import com.example.demo.health.AppHealthIndicator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChaosController {

    private final AppHealthIndicator indicator;

    public ChaosController(AppHealthIndicator indicator) {
        this.indicator = indicator;
    }

    @GetMapping("/chaos")
    public String processRequest() {
        indicator.setUnhealthy();
        return "Marking as unhealthy";
    }


}
