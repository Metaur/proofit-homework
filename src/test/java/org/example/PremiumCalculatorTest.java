package org.example;

import org.example.builder.PolicyBuilder;
import org.example.model.PolicyStatus;
import org.example.model.RiskType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class PremiumCalculatorTest {
    private final PremiumCalculator calculator = new PremiumCalculator();

    @Test
    void calculateSimple() {
        var policy = new PolicyBuilder("Sample", PolicyStatus.APPROVED)
                .addObject("House")
                .addSubObject("fire", RiskType.FIRE, "100.00")
                .addSubObject("theft", RiskType.THEFT, "8.00")
                .end()
                .build();

        Assertions.assertEquals(new BigDecimal("2.28"), calculator.calculate(policy));
    }

    @Test
    void calculateComplex() {
        var policy = new PolicyBuilder("Sample", PolicyStatus.APPROVED)
                .addObject("House")
                .addSubObject("1", RiskType.FIRE, "100.00")
                .addSubObject("2", RiskType.THEFT, "10.00")
                .end()
                .addObject("Car")
                .addSubObject("1", RiskType.FIRE, "50.00")
                .addSubObject("2", RiskType.FIRE, "40.00")
                .addSubObject("3", RiskType.FIRE, "10.00")
                .addSubObject("4", RiskType.THEFT, "50.00")
                .end()
                .addObject("Boat")
                .addSubObject("1", RiskType.THEFT, "40.00")
                .addSubObject("2", RiskType.THEFT, "2.50")
                .addSubObject("3", RiskType.FIRE, "300.00")
                .end()
                .build();

        Assertions.assertEquals(new BigDecimal("17.13"), calculator.calculate(policy));
    }
}