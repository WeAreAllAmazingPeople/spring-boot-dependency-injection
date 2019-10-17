package com.switchfully.spring.dependencyinjection.calculator;

import com.switchfully.spring.dependencyinjection.calculator.calculations.TaxCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaxCalculator {

    private final TaxCalculation taxCalculation;

    @Autowired
    public TaxCalculator(TaxCalculation taxCalculation) {
        this.taxCalculation = taxCalculation;
    }

    public double calculateTaxesForIncome(double yearlyIncome) {
        return taxCalculation.calculateTaxes(yearlyIncome);
    }
}
