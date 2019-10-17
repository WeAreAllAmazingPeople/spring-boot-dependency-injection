package com.switchfully.spring.dependencyinjection.calculator.calculations;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BelgianTaxCalculation implements TaxCalculation {

    private static final double BELGIAN_TAX_RATE = 0.45;

    @Override
    public double calculateTaxes(double yearlyIncome) {
        return yearlyIncome * BELGIAN_TAX_RATE;
    }

}
