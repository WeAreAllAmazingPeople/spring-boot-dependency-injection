package com.switchfully.spring.dependencyinjection;

import com.switchfully.spring.dependencyinjection.calculator.TaxCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = AmericanTestConfig.class)
class ApplicationAmericaTest {
    private final TaxCalculator taxCalculator;
    private final ApplicationContext applicationContext;

    @Autowired
    public ApplicationAmericaTest(ApplicationContext applicationContext, @Qualifier("testAmericanCalculator") TaxCalculator taxCalculator){
        this.applicationContext = applicationContext;
        this.taxCalculator = taxCalculator;
    }

    @Test
    void givenCustomConfigurationWithAmericanCalculations_whenYearlyIncomeIs2300_thenTaxesAre5090() {
        // Given
        double expectedTaxes = 5090.0;
        double yearlyIncome = 23000.0;
        // When
        double actualTaxes = taxCalculator.calculateTaxesForIncome(yearlyIncome);
        // Then
        assertEquals(expectedTaxes, actualTaxes);
    }

    @Test
    void givenCustomSpringConfiguration_whenExecuted_theSpringContextContains13Beans() {
        // Given
        int expectedBeanCount = 13;
        // When
        int actualBeanCount = applicationContext.getBeanDefinitionCount();
        Stream.of(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
        // Then
        assertEquals(expectedBeanCount, actualBeanCount);
        assertTrue(applicationContext.containsBean("americanTestConfig"));
        assertFalse(applicationContext.containsBean("application"));
    }
}