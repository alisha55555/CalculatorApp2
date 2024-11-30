package com.example.calculatorapp2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class CalculatorHelperTest {

    CalculatorHelper calculator = new CalculatorHelper();

    @Test
    public void testAddition() {
        double result = calculator.add(2, 3);
        assertEquals(5.0, result, 0.001); // Проверяем с точностью до 0.001
    }

    @Test
    public void testSubtraction() {
        double result = calculator.subtract(10, 4);
        assertEquals(6.0, result, 0.001);
    }

    @Test
    public void testMultiplication() {
        double result = calculator.multiply(2, 3);
        assertEquals(6.0, result, 0.001);
    }

    @Test
    public void testDivision() {
        double result = calculator.divide(10, 2);
        assertEquals(5.0, result, 0.001);
    }

    @Test
    public void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
    }
}
