package org.example.calculators;

import org.example.model.Policy;
import org.example.model.PolicyObject;
import org.example.model.PolicySubObject;

import java.math.BigDecimal;
import java.util.List;

public interface Premium {
    boolean isApplicable(PolicySubObject policySubObject);

    BigDecimal getCoefficient(BigDecimal sumInsured);

    default BigDecimal calculate(Policy policy) {
        var totalSumInsured = policy.getObjects()
                .stream()
                .map(PolicyObject::getSubObjects)
                .flatMap(List::stream)
                .filter(this::isApplicable)
                .map(PolicySubObject::getSumInsured)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return totalSumInsured.multiply(getCoefficient(totalSumInsured));
    }
}
