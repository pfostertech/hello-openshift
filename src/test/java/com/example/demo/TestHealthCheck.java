package com.example.demo;

import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD;

import com.example.demo.health.AppHealthIndicator;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Status;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
public class TestHealthCheck {

    @Autowired
    public AppHealthIndicator indicator;

    @Test
    @DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
    public void testHealthCheckFails() {
        indicator.setUnhealthy();
        Assert.assertFalse(indicator.isHealthy());
        Assert.assertEquals(Status.DOWN, indicator.health().getStatus());
    }

    @Test
    @DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
    public void testHealthCheckPasses() {
        Assert.assertTrue(indicator.isHealthy());
        Assert.assertEquals(Status.UP, indicator.health().getStatus());
    }

}
