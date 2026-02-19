package sbst.calculator;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorService_LLMTest {

    private final CalculatorService calculator = new CalculatorService();

    // ============================================================3
    // ADIÇÃO
    // ============================================================

    @Test
    public void testAdditionPositiveNumbers() {
        assertEquals(5.0, calculator.calculate(2.0, 3.0, '+'), 0.0001);
    }

    @Test
    public void testAdditionNegativeNumbers() {
        assertEquals(-5.0, calculator.calculate(-2.0, -3.0, '+'), 0.0001);
    }

    @Test
    public void testAdditionWithZero() {
        assertEquals(3.0, calculator.calculate(3.0, 0.0, '+'), 0.0001);
    }

    @Test
    public void testAdditionResultZero() {
        assertEquals(0.0, calculator.calculate(-3.0, 3.0, '+'), 0.0001);
    }

    @Test
    public void testAdditionDecimalNumbers() {
        assertEquals(0.3, calculator.calculate(0.1, 0.2, '+'), 0.0001);
    }

    @Test
    public void testAdditionLargeNumbers() {
        assertEquals(2000000000.0, calculator.calculate(1000000000.0, 1000000000.0, '+'), 0.0001);
    }

    // ============================================================
    // SUBTRAÇÃO
    // ============================================================

    @Test
    public void testSubtractionPositiveNumbers() {
        assertEquals(1.0, calculator.calculate(3.0, 2.0, '-'), 0.0001);
    }

    @Test
    public void testSubtractionNegativeResult() {
        assertEquals(-1.0, calculator.calculate(2.0, 3.0, '-'), 0.0001);
    }

    @Test
    public void testSubtractionWithZero() {
        assertEquals(5.0, calculator.calculate(5.0, 0.0, '-'), 0.0001);
    }

    @Test
    public void testSubtractionResultZero() {
        assertEquals(0.0, calculator.calculate(4.0, 4.0, '-'), 0.0001);
    }

    @Test
    public void testSubtractionNegativeNumbers() {
        assertEquals(1.0, calculator.calculate(-2.0, -3.0, '-'), 0.0001);
    }

    @Test
    public void testSubtractionDecimalNumbers() {
        assertEquals(0.1, calculator.calculate(0.3, 0.2, '-'), 0.0001);
    }

    // ============================================================
    // MULTIPLICAÇÃO
    // ============================================================

    @Test
    public void testMultiplicationPositiveNumbers() {
        assertEquals(6.0, calculator.calculate(2.0, 3.0, '*'), 0.0001);
    }

    @Test
    public void testMultiplicationByZero() {
        assertEquals(0.0, calculator.calculate(5.0, 0.0, '*'), 0.0001);
    }

    @Test
    public void testMultiplicationByOne() {
        assertEquals(7.0, calculator.calculate(7.0, 1.0, '*'), 0.0001);
    }

    @Test
    public void testMultiplicationNegativeNumbers() {
        assertEquals(6.0, calculator.calculate(-2.0, -3.0, '*'), 0.0001);
    }

    @Test
    public void testMultiplicationPositiveAndNegative() {
        assertEquals(-6.0, calculator.calculate(2.0, -3.0, '*'), 0.0001);
    }

    @Test
    public void testMultiplicationDecimalNumbers() {
        assertEquals(0.06, calculator.calculate(0.2, 0.3, '*'), 0.0001);
    }

    @Test
    public void testMultiplicationLargeNumbers() {
        assertEquals(1000000.0, calculator.calculate(1000.0, 1000.0, '*'), 0.0001);
    }

    // ============================================================
    // DIVISÃO
    // ============================================================

    @Test
    public void testDivisionPositiveNumbers() {
        assertEquals(2.0, calculator.calculate(6.0, 3.0, '/'), 0.0001);
    }

    @Test
    public void testDivisionByOne() {
        assertEquals(5.0, calculator.calculate(5.0, 1.0, '/'), 0.0001);
    }

    @Test
    public void testDivisionResultDecimal() {
        assertEquals(0.5, calculator.calculate(1.0, 2.0, '/'), 0.0001);
    }

    @Test
    public void testDivisionNegativeNumbers() {
        assertEquals(2.0, calculator.calculate(-6.0, -3.0, '/'), 0.0001);
    }

    @Test
    public void testDivisionPositiveByNegative() {
        assertEquals(-2.0, calculator.calculate(6.0, -3.0, '/'), 0.0001);
    }

    @Test
    public void testDivisionZeroByNumber() {
        assertEquals(0.0, calculator.calculate(0.0, 5.0, '/'), 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivisionByZeroThrowsException() {
        calculator.calculate(5.0, 0.0, '/');
    }

    @Test
    public void testDivisionByZeroExceptionMessage() {
        try {
            calculator.calculate(10.0, 0.0, '/');
            fail("Deveria ter lançado IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Divisão por zero não é permitida.", e.getMessage());
        }
    }

    // ============================================================
    // OPERADOR INVÁLIDO
    // ============================================================

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidOperatorThrowsException() {
        calculator.calculate(1.0, 2.0, '%');
    }

    @Test
    public void testInvalidOperatorExceptionMessage() {
        try {
            calculator.calculate(1.0, 2.0, '^');
            fail("Deveria ter lançado IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Operador inválido.", e.getMessage());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidOperatorLetter() {
        calculator.calculate(1.0, 2.0, 'x');
    }

    // ============================================================
    // isValidOperator
    // ============================================================

    @Test
    public void testIsValidOperatorAddition() {
        assertTrue(CalculatorService.isValidOperator('+'));
    }

    @Test
    public void testIsValidOperatorSubtraction() {
        assertTrue(CalculatorService.isValidOperator('-'));
    }

    @Test
    public void testIsValidOperatorMultiplication() {
        assertTrue(CalculatorService.isValidOperator('*'));
    }

    @Test
    public void testIsValidOperatorDivision() {
        assertTrue(CalculatorService.isValidOperator('/'));
    }

    @Test
    public void testIsValidOperatorInvalidChar() {
        assertFalse(CalculatorService.isValidOperator('%'));
    }

    @Test
    public void testIsValidOperatorLetter() {
        assertFalse(CalculatorService.isValidOperator('a'));
    }

    @Test
    public void testIsValidOperatorNumber() {
        assertFalse(CalculatorService.isValidOperator('1'));
    }
}