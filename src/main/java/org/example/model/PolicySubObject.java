package org.example.model;

import java.math.BigDecimal;

public class PolicySubObject {
    private String name;
    private BigDecimal sumInsured;
    private RiskType riskType;

    public PolicySubObject(String name, BigDecimal sumInsured, RiskType riskType) {
        this.name = name;
        this.sumInsured = sumInsured;
        this.riskType = riskType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(BigDecimal sumInsured) {
        this.sumInsured = sumInsured;
    }

    public RiskType getRiskType() {
        return riskType;
    }

    public void setRiskType(RiskType riskType) {
        this.riskType = riskType;
    }
}
