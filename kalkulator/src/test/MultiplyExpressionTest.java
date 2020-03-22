package test;

import org.junit.Test;
import sample.AddExpression;
import sample.MultiplyExpression;
import sample.TerminalExpression;

import static org.junit.Assert.*;

public class MultiplyExpressionTest {

    @Test
    public void solve() {
        TerminalExpression a = new TerminalExpression(10);
        TerminalExpression b = new TerminalExpression(20);
        MultiplyExpression mult = new MultiplyExpression(a, b);
        System.out.println("~~~~ MultiplyExpression:solve() test " + CalculatorStackTest.testCount);
        assertEquals(mult.solve(), 200, 0.001);

        a = new TerminalExpression(30);
        b = new TerminalExpression(40);
        mult = new MultiplyExpression(a, b);
        System.out.println("~~~~ MultiplyExpression:solve() test " + CalculatorStackTest.testCount);
        assertEquals(mult.solve(), 1200, 0.001);

        CalculatorStackTest.testCount++;
    }
}