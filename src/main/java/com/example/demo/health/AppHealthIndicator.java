package com.example.demo.health;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class AppHealthIndicator implements HealthIndicator {

    private static final Logger logger = LoggerFactory.getLogger(AppHealthIndicator.class);

    private boolean isHealthy = true;


    @Override
    public Health health() {
        if (isHealthy) {
            return Health.up().build();
        } else {
            return Health.down().withDetail("Healthy", false).build();
        }
    }

    public boolean isHealthy() {
        return isHealthy;
    }

    public void setUnhealthy() {
        logger.info("Marking as unhealthy...");
        this.isHealthy = false;
    }
}
