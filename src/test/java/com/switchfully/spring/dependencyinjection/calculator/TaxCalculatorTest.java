package com.switchfully.spring.dependencyinjection.calculator;

import com.switchfully.spring.dependencyinjection.calculator.TaxCalculator;
import com.switchfully.spring.dependencyinjection.calculator.calculations.FrenchTaxCalculation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.Times;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TaxCalculatorTest {

    @Mock
    private FrenchTaxCalculation frenchTaxCalculation;

    @InjectMocks
    private TaxCalculator taxCalculator;

    @Test
    public void calculateTaxesForIncome_verifyThatCalculateTaxesIsCalledWithYearIncome() {
        taxCalculator.calculateTaxesForIncome(25000);

        Mockito.verify(frenchTaxCalculation, new Times(1)).calculateTaxes(25000);
    }

    @Test
    public void calculateTaxesForIncome_givenCalculatedTaxesOf500_thenReturn500asResult() {
        Mockito.when(frenchTaxCalculation.calculateTaxes(25000)).thenReturn(500.0);

        double calculatedTaxes = taxCalculator.calculateTaxesForIncome(25000);

        assertEquals(calculatedTaxes, 500, 0);
    }

}