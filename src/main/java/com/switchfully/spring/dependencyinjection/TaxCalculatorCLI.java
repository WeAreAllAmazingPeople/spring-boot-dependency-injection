package com.switchfully.spring.dependencyinjection;

import com.switchfully.spring.dependencyinjection.calculator.TaxCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TaxCalculatorCLI implements CommandLineRunner {
    private final ApplicationContext applicationContext;
    private final TaxCalculator taxCalculator;

    @Autowired
    public TaxCalculatorCLI(ApplicationContext applicationContext, TaxCalculator taxCalculator) {
        this.applicationContext = applicationContext;
        this.taxCalculator = taxCalculator;
    }

    @Override
    public void run(String... strings) {
        double taxesToPay = taxCalculator.calculateTaxesForIncome(23000);
        System.out.println("\n\n\nTAX CALCULATION\n\n\n");
        System.out.println(String.format("You have %s taxes to pay!", taxesToPay));
        System.out.println("\n\n\n-------------------------------------------------");
    }
}
