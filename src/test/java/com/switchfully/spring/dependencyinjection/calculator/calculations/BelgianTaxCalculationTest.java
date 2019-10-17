package com.switchfully.spring.dependencyinjection.calculator.calculations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BelgianTaxCalculationTest {

    @Test
    public void calculateTaxes_givenAYearlyIncome_thenCalculateBelgianTaxes() throws Exception {
        TaxCalculation taxCalculation = new BelgianTaxCalculation();

        double calculatedTaxes = taxCalculation.calculateTaxes(10000);

        assertEquals(calculatedTaxes, 4500.0, 0);
    }

}