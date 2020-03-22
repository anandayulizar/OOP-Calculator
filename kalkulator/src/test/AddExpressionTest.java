package test;

import org.junit.Test;
import sample.AddExpression;
import sample.CalculatorStack;
import sample.TerminalExpression;

import static org.junit.Assert.*;

public class AddExpressionTest {

    @Test
    public void solve() {
        TerminalExpression a = new TerminalExpression(10);
        TerminalExpression b = new TerminalExpression(20);
        AddExpression add = new AddExpression(a, b);
        System.out.println("~~~~ AddExpression:solve() test " + CalculatorStackTest.testCount);
        assertEquals(add.solve(), 30, 0.001);

        a = new TerminalExpression(30);
        b = new TerminalExpression(40);
        add = new AddExpression(a, b);
        System.out.println("~~~~ AddExpression:solve() test " + CalculatorStackTest.testCount);
        assertEquals(add.solve(), 70, 0.001);

        CalculatorStackTest.testCount++;
    }
}