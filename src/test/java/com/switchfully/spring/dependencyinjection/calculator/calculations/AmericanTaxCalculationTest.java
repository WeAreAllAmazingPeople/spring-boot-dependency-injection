package com.switchfully.spring.dependencyinjection.calculator.calculations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AmericanTaxCalculationTest {

    @Test
    public void calculateTaxes_givenAYearlyIncome_thenCalculateAmericanTaxes() throws Exception {
        TaxCalculation taxCalculation = new AmericanTaxCalculation();

        double calculatedTaxes = taxCalculation.calculateTaxes(10000);

        assertEquals(calculatedTaxes, 2750.0, 0);
    }

}