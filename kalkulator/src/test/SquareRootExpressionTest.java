package test;

import org.junit.Test;
import sample.SquareRootExpression;
import sample.TerminalExpression;

import static org.junit.Assert.*;

public class SquareRootExpressionTest {

    @Test
    public void solve() {
        System.out.println("~~~~ SquareRootExpression:solve() test " + CalculatorStackTest.testCount);
        TerminalExpression a = new TerminalExpression(10);
        SquareRootExpression neg = new SquareRootExpression(a);
        assertEquals(neg.solve(), -10, 0.001);

        System.out.println("~~~~ SquareRootExpression:solve() test " + CalculatorStackTest.testCount);
        TerminalExpression b = new TerminalExpression(0);
        neg = new SquareRootExpression(b);
        assertEquals(b.solve(), 0, 0.001);
    }
}