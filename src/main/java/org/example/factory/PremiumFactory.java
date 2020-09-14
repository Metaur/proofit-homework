package org.example.factory;

import org.example.calculators.Premium;
import org.example.calculators.impl.FirePremium;
import org.example.calculators.impl.TheftPremium;
import org.example.model.RiskType;

public class PremiumFactory {

    public Premium get(RiskType type) {
        return switch (type) {
            case FIRE -> new FirePremium();
            case THEFT -> new TheftPremium();
        };
    }
}
