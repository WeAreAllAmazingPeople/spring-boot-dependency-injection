package com.switchfully.spring.dependencyinjection.calculator.calculations;

import org.springframework.stereotype.Component;

@Component("FrenchCalculation")
public class FrenchTaxCalculation implements TaxCalculation {

    private static final double FRENCH_TAX_RATE = 0.48;

    @Override
    public double calculateTaxes(double yearlyIncome) {
        return yearlyIncome * FRENCH_TAX_RATE;
    }
}
