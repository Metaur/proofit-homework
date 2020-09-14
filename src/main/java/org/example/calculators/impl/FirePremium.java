package org.example.calculators.impl;

import org.example.calculators.Premium;
import org.example.model.PolicySubObject;
import org.example.model.RiskType;

import java.math.BigDecimal;

public class FirePremium implements Premium {
    private static final BigDecimal COEFF_ADJUSTED = new BigDecimal("0.024");
    private static final BigDecimal COEFF_DEFAULT = new BigDecimal("0.014");
    private static final BigDecimal ADJUST_LIMIT = new BigDecimal("100.00");

    @Override
    public boolean isApplicable(PolicySubObject policySubObject) {
        return policySubObject.getRiskType() == RiskType.FIRE;
    }

    @Override
    public BigDecimal getCoefficient(BigDecimal sumInsured) {
        return sumInsured.compareTo(ADJUST_LIMIT) > 0 ? COEFF_ADJUSTED : COEFF_DEFAULT;
    }
}
