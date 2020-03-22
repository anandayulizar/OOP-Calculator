package test;

import static org.junit.Assert.*;
import sample.CalculatorStack;
import sample.Expression;
import sample.TerminalExpression;

public class CalculatorStackTest {
    private CalculatorStack calstack;
    private static int testCount = 1;

    @org.junit.Before
    public void setUp() throws Exception {
        System.out.println("Set up for test count : " + this.testCount);
        TerminalExpression a = new TerminalExpression(10);
        char b = '*';
        calstack = new CalculatorStack();
        calstack.push(a);
        calstack.push(b);
        this.testCount++;
    }

    @org.junit.Test
    public void push() throws Exception {
        TerminalExpression a = new TerminalExpression(10);
        char b = '*';

        calstack.push(a);
        System.out.println("~~~~ push() test : " + this.testCount + "~~~~");
        assertEquals(calstack.numPeek(), a);

        calstack.push(b);
        System.out.println("~~~~ push() test : " + this.testCount + "~~~~");
        assertEquals(calstack.opPeek(), b);
    }

    @org.junit.Test
    public void popNumber() {
        System.out.println("~~~~ popNumber() test : " + this.testCount + "~~~~");
        assertEquals(calstack.popNumber().solve(), 10, 0.0001);
    }

    @org.junit.Test
    public void popOperator() {
        System.out.println("~~~~ popOperator() test : " + this.testCount + "~~~~");
        assertEquals(calstack.popOperator(), '*');
    }

    @org.junit.Test
    public void isOpEmpty() {
        char temp = calstack.popOperator();
        System.out.println("~~~~ isOpEmpty() test : " + this.testCount + "~~~~");
        assertEquals(calstack.isOpEmpty(), true);

        calstack.push(temp);
        calstack.push(temp);
        calstack.push(temp);
        calstack.push(temp);
        System.out.println("~~~~ isOpEmpty() test : " + this.testCount + "~~~~");
        assertEquals(calstack.isOpEmpty(), false);
    }

    @org.junit.Test
    public void isNumEmpty() {
        TerminalExpression temp = calstack.popNumber();
        System.out.println("~~~~ isNumEmpty() test : " + this.testCount + "~~~~");
        assertEquals(calstack.isNumEmpty(), true);

        calstack.push(temp);
        calstack.push(temp);
        calstack.push(temp);
        calstack.push(temp);
        System.out.println("~~~~ isNumEmpty() test : " + this.testCount + "~~~~");
        assertEquals(calstack.isNumEmpty(), false);
    }

    @org.junit.Test
    public void numSize() {
        System.out.println("~~~~ numSize() test : " + this.testCount + "~~~~");
        assertEquals(calstack.numSize(), 1);

        TerminalExpression temp = new TerminalExpression(20);
        calstack.push(temp);
        calstack.push(temp);
        calstack.push(temp);
        temp = calstack.popNumber();
        char tempChar = calstack.popOperator();
        System.out.println("~~~~ numSize() test : " + this.testCount + "~~~~");
        assertEquals(calstack.numSize(), 3);

        temp = calstack.popNumber();
        temp = calstack.popNumber();
        temp = calstack.popNumber();
        System.out.println("~~~~ numSize() test : " + this.testCount + "~~~~");
        assertEquals(calstack.numSize(), 0);
    }

    @org.junit.Test
    public void opSize() {
        System.out.println("~~~~ opSize() test : " + this.testCount + "~~~~");
        assertEquals(calstack.numSize(), 1);

        TerminalExpression temp = new TerminalExpression(20);
        calstack.push(temp);
        calstack.push(temp);
        calstack.push(temp);
        temp = calstack.popNumber();
        char tempChar = calstack.popOperator();
        System.out.println("~~~~ opSize() test : " + this.testCount + "~~~~");
        assertEquals(calstack.numSize(), 3);
    }

    @org.junit.After
    public void deallocateTest() {
        calstack = null;
    }
}