package org.example.calculators.impl;

import org.example.model.PolicySubObject;
import org.example.model.RiskType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class TheftPremiumTest extends PremiumTest {
    public TheftPremiumTest() {
        super(new TheftPremium());
    }

    @Test
    void testIsApplicable() {
        var valid = new PolicySubObject("test1", new BigDecimal("1"), RiskType.THEFT);
        var invalid = new PolicySubObject("test2", new BigDecimal("1"), RiskType.FIRE);

        Assertions.assertTrue(premium.isApplicable(valid));
        Assertions.assertFalse(premium.isApplicable(invalid));
    }

    @Test
    void testDefaultCoeff() {
        var expected = new BigDecimal("0.11");
        testCoeff(expected, "0", "1", "1.11", "10", "14.99");
    }

    @Test
    void testAdjustedCoeff() {
        var expected = new BigDecimal("0.05");
        testCoeff(expected, "15", "15.00", "15.01", "101", "200", "999");
    }
}
