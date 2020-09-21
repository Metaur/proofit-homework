package org.example.calculators.impl;

import org.example.calculators.Premium;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;
import java.util.stream.Stream;

public abstract class PremiumTest {
    protected Premium premium;

    public PremiumTest(Premium premium) {
        this.premium = premium;
    }

    protected void testCoeff(BigDecimal expected, String ...testable) {
        Stream.of(testable)
                .map(BigDecimal::new)
                .map(premium::getCoefficient)
                .forEach(result -> Assertions.assertEquals(expected, result));
    }
}
