package test;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import sample.CalculatorStack;
import sample.Expression;
import sample.TerminalExpression;

public class CalculatorStackTest {
    private CalculatorStack calstack;

    @org.junit.Before
    public void setUp() throws Exception {
        System.out.println("Set up for a new test count...");
        calstack = new CalculatorStack();
    }

    @org.junit.Test
    public void push() throws Exception {
        System.out.println("~~~~ push() test ~~~~");
        TerminalExpression a = new TerminalExpression(10);
        char b = '*';

        calstack.push(a);
        assertEquals(calstack.numPeek(), a);

        calstack.push(b);
        assertEquals(calstack.opPeek(), b);
    }

    @org.junit.Test
    public void popNumber() {
        System.out.println("~~~~ popNumber() test ~~~~");
    }

    @org.junit.Test
    public void popOperator() {
    }

    @org.junit.Test
    public void isOpEmpty() {
    }

    @org.junit.Test
    public void isNumEmpty() {
    }

    @org.junit.Test
    public void numSize() {
    }

    @org.junit.Test
    public void opSize() {
    }

    @org.junit.After
    public void deallocateTest() {
        calstack = null;
    }
}