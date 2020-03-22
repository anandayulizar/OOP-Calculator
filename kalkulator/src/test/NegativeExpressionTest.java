package test;

import org.junit.Test;
import sample.NegativeExpression;
import sample.TerminalExpression;

import static org.junit.Assert.*;

public class NegativeExpressionTest {

    @Test
    public void solve() {
        System.out.println("~~~~ NegativeExpression:solve() test " + CalculatorStackTest.testCount);
        TerminalExpression a = new TerminalExpression(10);
        NegativeExpression neg = new NegativeExpression(a);
        assertEquals(neg.solve(), -10, 0.001);

        System.out.println("~~~~ NegativeExpression:solve() test " + CalculatorStackTest.testCount);
        TerminalExpression b = new TerminalExpression(0);
        neg = new NegativeExpression(b);
        assertEquals(b.solve(), 0, 0.001);
    }
}