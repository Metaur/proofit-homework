# Premium calculator

### Prerequisites

- Java 14

### Motivation

This section will cover the decisions made during this homework.

#### Why DI is not used

I tried to make the solution as light as possible so that it could be used as a pluggable library. It could be used anywhere it is needed (e.g. different modules).

#### Java 14?

Need to stay up-to-date with modern technologies. I would rather use Kotlin, but that is not specified in the requirements.

#### Extending risk types

Adding new risk types is easy. You just need to add a new enum value and an appropriate class, extending the `Premium` interface. In the case of missing a premium class, the project won't be able to compile, as all risk types should be covered with premium calculation classes.

### Things to consider

#### Better coefficient configuration

Now the coefficients and their limits are described in the `Premium` implementations. The configuration could be stored in the `.properties` file, which is loaded during runtime and appropriate values injected into premium calculation classes.

#### Currency support

In a production-level application, I would consider adding currency support to properly normalize insured amounts of the policy. That would require adjusting the `Policy` model and `PremiumCalculator.calculate` signature.
