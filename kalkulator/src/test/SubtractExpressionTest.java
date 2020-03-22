package test;

import org.junit.Test;
import sample.SubtractExpression;
import sample.TerminalExpression;

import static org.junit.Assert.*;

public class SubtractExpressionTest {

    @Test
    public void solve() {
        TerminalExpression a = new TerminalExpression(10);
        TerminalExpression b = new TerminalExpression(20);
        SubtractExpression add = new SubtractExpression(a, b);
        System.out.println("~~~~ SubtractExpression:solve() test " + CalculatorStackTest.testCount);
        assertEquals(add.solve(), -10, 0.001);

        a = new TerminalExpression(30);
        b = new TerminalExpression(10);
        add = new SubtractExpression(a, b);
        System.out.println("~~~~ SubtractExpression:solve() test " + CalculatorStackTest.testCount);
        assertEquals(add.solve(), 20, 0.001);

        CalculatorStackTest.testCount++;
    }
}