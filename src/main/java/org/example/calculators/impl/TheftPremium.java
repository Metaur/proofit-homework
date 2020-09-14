package org.example.calculators.impl;

import org.example.calculators.Premium;
import org.example.model.PolicySubObject;
import org.example.model.RiskType;

import java.math.BigDecimal;

public class TheftPremium implements Premium {
    private static final BigDecimal COEFF_ADJUSTED = new BigDecimal("0.05");
    private static final BigDecimal COEFF_DEFAULT = new BigDecimal("0.11");
    private static final BigDecimal ADJUST_LIMIT = new BigDecimal("15.00");

    @Override
    public boolean isApplicable(PolicySubObject policySubObject) {
        return policySubObject.getRiskType() == RiskType.THEFT;
    }

    @Override
    public BigDecimal getCoefficient(BigDecimal sumInsured) {
        return sumInsured.compareTo(ADJUST_LIMIT) >= 0 ? COEFF_ADJUSTED : COEFF_DEFAULT;
    }
}
