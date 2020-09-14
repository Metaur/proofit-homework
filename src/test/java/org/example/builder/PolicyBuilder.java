package org.example.builder;

import org.example.model.Policy;
import org.example.model.PolicyStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PolicyBuilder {
    private final List<PolicyObjectBuilder> objectBuilders = new ArrayList<>();
    private final String name;
    private final PolicyStatus status;

    public PolicyBuilder(String name, PolicyStatus status) {
        this.name = name;
        this.status = status;
    }

    public PolicyObjectBuilder addObject(String name) {
        var policyObjectBuilder = new PolicyObjectBuilder(this, name);
        objectBuilders.add(policyObjectBuilder);
        return policyObjectBuilder;
    }

    public Policy build() {
        return new Policy(
                name,
                status,
                objectBuilders.stream()
                        .map(PolicyObjectBuilder::build)
                        .collect(Collectors.toList())
        );
    }
}

