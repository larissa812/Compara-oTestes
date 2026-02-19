package sbst.calculator;

public class CalculatorService {

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    public double calculate(double firstNumber, double secondNumber, char operator) {
        switch (operator) {
            case ADDITION:
                return firstNumber + secondNumber;
            case SUBTRACTION:
                return firstNumber - secondNumber;
            case MULTIPLICATION:
                return firstNumber * secondNumber;
            case DIVISION:
                if (secondNumber == 0) {
                    throw new IllegalArgumentException("Divisão por zero não é permitida.");
                }
                return firstNumber / secondNumber;
            default:
                throw new IllegalArgumentException("Operador inválido.");
        }
    }

    public static boolean isValidOperator(char operator) {
        return operator == ADDITION || operator == SUBTRACTION
                || operator == MULTIPLICATION || operator == DIVISION;
    }
}
