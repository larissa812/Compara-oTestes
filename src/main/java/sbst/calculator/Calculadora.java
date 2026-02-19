package sbst.calculator;

import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstNumber = scanner.nextDouble();
        char operator = scanner.next().charAt(0);
        double secondNumber = scanner.nextDouble();

        CalculatorService service = new CalculatorService();
        System.out.println(service.calculate(firstNumber, secondNumber, operator));
    }
}
