package org.example.builder;

import org.example.model.PolicyObject;
import org.example.model.PolicySubObject;
import org.example.model.RiskType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PolicyObjectBuilder {
    private final PolicyBuilder policyBuilder;
    private final String name;
    private final List<PolicySubObject> subObjects = new ArrayList<>();

    public PolicyObjectBuilder(PolicyBuilder policyBuilder, String name) {
        this.policyBuilder = policyBuilder;
        this.name = name;
    }

    public PolicyObjectBuilder addSubObject(String name, RiskType type, String amount) {
        subObjects.add(new PolicySubObject(name, new BigDecimal(amount), type));
        return this;
    }

    public PolicyBuilder end() {
        return policyBuilder;
    }

    public PolicyObject build() {
        return new PolicyObject(name, subObjects);
    }
}
