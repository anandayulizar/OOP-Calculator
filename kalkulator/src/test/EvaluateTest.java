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

    }
}