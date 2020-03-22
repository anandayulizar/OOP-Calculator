package test;

import static org.junit.Assert.*;
import sample.CalculatorStack;
import sample.TerminalExpression;

public class CalculatorStackTest {
    private CalculatorStack<TerminalExpression> calstack;
    public static int testCount = 1;

    @org.junit.Before
    public void setUp() {
        System.out.println("Set up for test count : " + CalculatorStackTest.testCount);
        TerminalExpression a = new TerminalExpression(10);
        char b = '*';
        calstack = new CalculatorStack();
        calstack.push(a);
        calstack.push(b);
        CalculatorStackTest.testCount++;
    }

    @org.junit.Test
    public void push() throws Exception {
        TerminalExpression a = new TerminalExpression(10);
        char b = '*';

        calstack.push(a);
        System.out.println("~~~~ CalculatorStack:push() test : " + CalculatorStackTest.testCount + "~~~~");
        assertEquals(calstack.numPeek(), a);

        calstack.push(b);
        System.out.println("~~~~ CalculatorStack:push() test : " + CalculatorStackTest.testCount + "~~~~");
        assertEquals(calstack.opPeek(), b);
    }

    @org.junit.Test
    public void popNumber() {
        System.out.println("~~~~ CalculatorStack:popNumber() test : " + CalculatorStackTest.testCount + "~~~~");
        assertEquals(calstack.popNumber().solve(), 10, 0.0001);
    }

    @org.junit.Test
    public void popOperator() {
        System.out.println("~~~~ CalculatorStack:popOperator() test : " + CalculatorStackTest.testCount + "~~~~");
        assertEquals(calstack.popOperator(), '*');
    }

    @org.junit.Test
    public void isOpEmpty() {
        char temp = calstack.popOperator();
        System.out.println("~~~~ CalculatorStack:isOpEmpty() test : " + CalculatorStackTest.testCount + "~~~~");
        assertEquals(calstack.isOpEmpty(), true);

        calstack.push(temp);
        calstack.push(temp);
        calstack.push(temp);
        calstack.push(temp);
        System.out.println("~~~~ CalculatorStack:isOpEmpty() test : " + CalculatorStackTest.testCount + "~~~~");
        assertEquals(calstack.isOpEmpty(), false);
    }

    @org.junit.Test
    public void isNumEmpty() {
        TerminalExpression temp = calstack.popNumber();
        System.out.println("~~~~ CalculatorStack:isNumEmpty() test : " + CalculatorStackTest.testCount + "~~~~");
        assertEquals(calstack.isNumEmpty(), true);

        calstack.push(temp);
        calstack.push(temp);
        calstack.push(temp);
        calstack.push(temp);
        System.out.println("~~~~ CalculatorStack:isNumEmpty() test : " + CalculatorStackTest.testCount + "~~~~");
        assertEquals(calstack.isNumEmpty(), false);
    }

    @org.junit.Test
    public void numSize() {
        System.out.println("~~~~ CalculatorStack:numSize() test : " + CalculatorStackTest.testCount + "~~~~");
        assertEquals(calstack.numSize(), 1);

        TerminalExpression temp = new TerminalExpression(20);
        calstack.push(temp);
        calstack.push(temp);
        calstack.push(temp);
        temp = calstack.popNumber();
        char tempChar = calstack.popOperator();
        System.out.println("~~~~ CalculatorStack:numSize() test : " + CalculatorStackTest.testCount + "~~~~");
        assertEquals(calstack.numSize(), 3);

        temp = calstack.popNumber();
        temp = calstack.popNumber();
        temp = calstack.popNumber();
        System.out.println("~~~~ CalculatorStack:numSize() test : " + CalculatorStackTest.testCount + "~~~~");
        assertEquals(calstack.numSize(), 0);
    }

    @org.junit.Test
    public void opSize() {
        System.out.println("~~~~ CalculatorStack:opSize() test : " + CalculatorStackTest.testCount + "~~~~");
        assertEquals(calstack.numSize(), 1);

        TerminalExpression temp = new TerminalExpression(20);
        calstack.push(temp);
        calstack.push(temp);
        calstack.push(temp);
        temp = calstack.popNumber();
        char tempChar = calstack.popOperator();
        System.out.println("~~~~ CalculatorStack:opSize() test : " + CalculatorStackTest.testCount + "~~~~");
        assertEquals(calstack.numSize(), 3);

        CalculatorStackTest.testCount++;
    }

    @org.junit.After
    public void deallocateTest() {
        calstack = null;
    }
}