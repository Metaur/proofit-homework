package org.example.calculators.impl;

import org.example.calculators.Premium;
import org.example.model.PolicySubObject;
import org.example.model.RiskType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Stream;

class FirePremiumTest extends PremiumTest {
    public FirePremiumTest() {
        super(new FirePremium());
    }

    @Test
    void testIsApplicable() {
        var valid = new PolicySubObject("test1", new BigDecimal("1"), RiskType.FIRE);
        var invalid = new PolicySubObject("test2", new BigDecimal("1"), RiskType.THEFT);

        Assertions.assertTrue(premium.isApplicable(valid));
        Assertions.assertFalse(premium.isApplicable(invalid));
    }

    @Test
    void testDefaultCoeff() {
        var expected = new BigDecimal("0.014");
        testCoeff(expected, "0", "1", "1.11", "25", "99", "99.99", "100", "100.00");
    }

    @Test
    void testAdjustedCoeff() {
        var expected = new BigDecimal("0.024");
        testCoeff(expected, "100.01", "101", "200", "999");
    }
}