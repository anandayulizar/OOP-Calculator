package sample;
import java.util.Stack;

public class CalculatorStack<T> {
    // numStack consists of numbers
    private Stack<T> numStack;
    // opStack consists of expressions
    private Stack<Character> opStack;

    public CalculatorStack() {
        numStack = new Stack<T>();
        opStack = new Stack<Character>();
    }

    public void push(T num) {
        numStack.push(num);
    }

    public void push(char op) {
        opStack.push(op);
    }

    public T popNumber() {
        return numStack.pop();
    }

    public char popOperator() {
        return opStack.pop();
    }

    public boolean isOpEmpty() {
        return opStack.empty();
    }

    public boolean isNumEmpty() {
        return numStack.empty();
    }

    public int numSize() {
        return numStack.size();
    }

    public int opSize() {
        return opStack.size();
    }

    public T numPeek() {
        return numStack.peek();
    }

    public char opPeek() {
       return opStack.peek();
    }
}