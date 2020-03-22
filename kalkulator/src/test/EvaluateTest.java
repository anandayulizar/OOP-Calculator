package test;

import org.junit.Test;
import sample.*;

import static org.junit.Assert.*;

public class EvaluateTest {
    private Evaluate eval;

    @org.junit.Before
    public void setUp() {
        eval = new Evaluate();
    }

    @Test
    public void isNumberCheck() {
        System.out.println("~~~~ Evaluate:isNumberCheck() test " + CalculatorStackTest.testCount);
        String inputText = "1234567890*/-+abcd";

        assertEquals(eval.isNumberCheck(inputText, 0), true);
        assertEquals(eval.isNumberCheck(inputText, 2), true);
        assertEquals(eval.isNumberCheck(inputText, 10), false);
        assertEquals(eval.isNumberCheck(inputText, 3), true);
        assertEquals(eval.isNumberCheck(inputText, inputText.length() - 1), false);
        assertEquals(eval.isNumberCheck(inputText, 7), true);
        assertEquals(eval.isNumberCheck(inputText, 14), false);
        CalculatorStackTest.testCount++;
    }

    @Test
    public void operate() {
        System.out.println("~~~~ Evaluate:operate() test " + CalculatorStackTest.testCount);
        TerminalExpression a = new TerminalExpression(16);
        TerminalExpression b = new TerminalExpression(4);
        TerminalExpression c = new TerminalExpression(1);

        DivideExpression aDivb = new DivideExpression(a, b);
        MultiplyExpression aMulb = new MultiplyExpression(a, b);
        SquareRootExpression aSqrt = new SquareRootExpression(a);
        NegativeExpression cNeg = new NegativeExpression(c);
        AddExpression aAddc = new AddExpression(a, c);

        assertEquals(eval.operate(aDivb).solve(), 4, 0.001);
        assertEquals(eval.operate(aMulb).solve(), 64, 0.001);
        assertEquals(eval.operate(aSqrt).solve(), 4, 0.001);
        assertEquals(eval.operate(cNeg).solve(), -1, 0.001);
        assertEquals(eval.operate(aAddc).solve(), 17, 0.001);
        CalculatorStackTest.testCount++;
    }

    @Test
    public void calculate() {
        System.out.println("~~~~ Evaluate:calculate() test " + CalculatorStackTest.testCount);
        String input;
        String result;

        // Test accuracy
        try {
            // Addition
            System.out.println("Add");
            input = "1+2+3";
            result = eval.calculate(input);
            assertEquals(result.equals("6.0"), true);

            // Subtraction
            System.out.println("Sub");
            input = "1-2+3";
            result = eval.calculate(input);
            assertEquals(result.equals("2.0"), true);

            // Additions and subtractions
            System.out.println("Add n sub");
            input = "1-2+3-4-4-3-2-1+3+3+2";
            result = eval.calculate(input);
            assertEquals(result.equals("-4.0"), true);

            // Multiplication
            System.out.println("Mult");
            input = "1*3+4*3";
            result = eval.calculate(input);
            assertEquals(result.equals("15.0"), true);

            // Division
            System.out.println("Div");
            input = "7*4/2+13*3-10";
            result = eval.calculate(input);
            assertEquals(result.equals("43.0"), true);

            // Square root *note that Vx denotes the square root of the number x
            System.out.println("Sqrt");
            input = "7*V4+13*3-10";
            result = eval.calculate(input);
            assertEquals(result.equals("43.0"), true);

            // Multiple square root
            System.out.println("Sqrt Sqrt Sqrt");
            input = "VVV256";
            result = eval.calculate(input);
            assertEquals(result.equals("2.0"), true);

            // Subtraction before square root
            System.out.println("Sub Sqrt");
            input = "7+V4+V16";
            result = eval.calculate(input);
            assertEquals(result.equals("13.0"), true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Test error generating
        // Division by zero
        try {
            System.out.println("Div 0");
            input = "7/0";
            result = eval.calculate(input);
            System.out.println(result);
        } catch (Exception e) {
            assertEquals(e.getMessage().equals("ERROR : Cannot divide by zero"), true);
        }

        // Invalid operation
        try {
            System.out.println("Op over");
            input = "3+5*+2";
            result = eval.calculate(input);
        } catch (Exception e) {
            assertEquals(e.getMessage().equals("ERROR : Operator overload"), true);
        }

        // Expected a number after negative
        try {
            System.out.println("Num after neg");
            input = "3+4+5-*3";
            result = eval.calculate(input);
        } catch (Exception e) {
            assertEquals(e.getMessage().equals("ERROR : Expected a number after operation"), true);
        }

        // Missing parenthesis
        try {
            System.out.println("Parenthesis");
            input = "3+((3+2)";
            result = eval.calculate(input);
        } catch (Exception e) {
            assertEquals(e.getMessage().equals("ERROR : Missing parentheses"), true);
        }

        // Invalid root
        try {
            System.out.println("Inv root");
            input = "V-4";
            result = eval.calculate(input);
        } catch (Exception e) {
            assertEquals(e.getMessage().equals("ERROR : Expected a number at the end of root"), true);
        }

        // Empty stack
        try {
            input = "3+4++++";
            result = eval.calculate(input);
        } catch (Exception e) {
            assertEquals(e.getMessage().equals("ERROR : Expected a terminal expression"), true);
        }
    }
}