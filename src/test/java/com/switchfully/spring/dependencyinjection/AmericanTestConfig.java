package com.switchfully.spring.dependencyinjection;

import com.switchfully.spring.dependencyinjection.calculator.TaxCalculator;
import com.switchfully.spring.dependencyinjection.calculator.calculations.TaxCalculation;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.switchfully.spring.dependencyinjection.calculator.calculations")
public class AmericanTestConfig {
    @Bean("testAmericanCalculator")
    public TaxCalculator getAmericanTaxCalculatorForTesting(@Qualifier("AmericanCalculation") TaxCalculation taxCalculation) {
        return new TaxCalculator(taxCalculation);
    }
}
