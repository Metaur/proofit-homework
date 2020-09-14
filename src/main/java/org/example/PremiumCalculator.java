package org.example;

import org.example.calculators.Premium;
import org.example.factory.PremiumFactory;
import org.example.model.Policy;
import org.example.model.RiskType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PremiumCalculator {
    private static final int DECIMAL_PLATES = 2;

    private final PremiumFactory factory = new PremiumFactory();
    private final List<Premium> premiumCalc = Arrays.stream(RiskType.values())
            .map(factory::get)
            .collect(Collectors.toList());

    public BigDecimal calculate(Policy policy) {
        return premiumCalc.stream()
                .map(p -> p.calculate(policy))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(DECIMAL_PLATES, RoundingMode.HALF_UP);
    }
}
