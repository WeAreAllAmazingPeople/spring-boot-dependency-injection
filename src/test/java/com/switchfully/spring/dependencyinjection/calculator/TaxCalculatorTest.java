package com.switchfully.spring.dependencyinjection.calculator;

import com.switchfully.spring.dependencyinjection.calculator.calculations.FrenchTaxCalculation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TaxCalculatorTest {

    @Mock
    private FrenchTaxCalculation frenchTaxCalculation;

    @InjectMocks
    private TaxCalculator taxCalculator;

    @Test
    public void calculateTaxesForIncome_verifyThatCalculateTaxesIsCalledWithYearIncome() {
        taxCalculator.calculateTaxesForIncome(25000);

        verify(frenchTaxCalculation, times(1)).calculateTaxes(25000);
        // times(1) is the default and can be omitted
        // https://static.javadoc.io/org.mockito/mockito-core/3.1.0/org/mockito/Mockito.html#verify
    }

    @Test
    public void calculateTaxesForIncome_givenCalculatedTaxesOf500_thenReturn500asResult() {
        when(frenchTaxCalculation.calculateTaxes(25000)).thenReturn(500.0);

        double calculatedTaxes = taxCalculator.calculateTaxesForIncome(25000);

        assertEquals(calculatedTaxes, 500, 0);
    }

}