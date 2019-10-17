package com.switchfully.spring.dependencyinjection;

import com.switchfully.spring.dependencyinjection.calculator.TaxCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApplicationTest {
    ApplicationContext applicationContext;

    @Autowired
    ApplicationTest(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Test
    void givenSpringConfiguredTaxCalculator_whenYearlyIncomeIs23000_thenTaxesAre10350() {
        // Given
        TaxCalculator taxCalculator = applicationContext.getBean(TaxCalculator.class);
        double expectedTaxes = 10350.0;
        double yearlyIncome = 23000.0;
        // When
        double actualTaxes = taxCalculator.calculateTaxesForIncome(yearlyIncome);
        // Then
        assertEquals(expectedTaxes, actualTaxes);
    }

    @Test
    void givenDefaultSpringConfiguration_whenExecuted_theSpringContextContains31Beans() {
        // Given
        int expectedBeanCount = 31;
        // When
        int actualBeanCount = applicationContext.getBeanDefinitionCount();
        Stream.of(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
        // Then
        assertEquals(expectedBeanCount, actualBeanCount);
        assertTrue(applicationContext.containsBean("application"));
        assertFalse(applicationContext.containsBean("americanTestConfig"));
    }
}