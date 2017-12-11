package com.switchfully.spring.dependencyinjection.calculator;

import com.switchfully.spring.dependencyinjection.calculator.calculations.TaxCalculation;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class TaxCalculator {

    private final TaxCalculation taxCalculation;

    @Inject
    public TaxCalculator(TaxCalculation taxCalculation) {
        this.taxCalculation = taxCalculation;
    }

    public double calculateTaxesForIncome(double yearlyIncome) {
        return taxCalculation.calculateTaxes(yearlyIncome);
    }
}
