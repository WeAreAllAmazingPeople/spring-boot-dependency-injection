package com.switchfully.spring.dependencyinjection.calculator.calculations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FrenchTaxCalculationTest {

    @Test
    public void calculateTaxes_givenAYearlyIncome_thenCalculateFrenchTaxes() throws Exception {
        TaxCalculation taxCalculation = new FrenchTaxCalculation();

        double calculatedTaxes = taxCalculation.calculateTaxes(10000);

        assertEquals(calculatedTaxes, 4800.0, 0);
    }

}