package test;
import org.junit.Test;
import sample.AddExpression;
import sample.DivideExpression;
import sample.DivideExpression;
import sample.TerminalExpression;
import static org.junit.Assert.*;
public class DivideExpressionTest {

    @Test
    public void solve() {
        TerminalExpression a = new TerminalExpression(20);
        TerminalExpression b = new TerminalExpression(10);
        DivideExpression div = new DivideExpression(a, b);
        System.out.println("~~~~ DivideExpression:solve() test " + CalculatorStackTest.testCount);
        assertEquals(div.solve(), 2, 0.001);

        a = new TerminalExpression(40);
        b = new TerminalExpression(20);
        div = new DivideExpression(a, b);
        System.out.println("~~~~ DivideExpression:solve() test " + CalculatorStackTest.testCount);
        assertEquals(div.solve(), 2, 0.001);
        CalculatorStackTest.testCount++;
    }
}