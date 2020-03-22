package sample;
import java.util.Stack;

class CalculatorStack {
    // numStack consists of numbers
    private Stack<TerminalExpression> numStack;
    // opStack consists of expressions
    private Stack<Character> opStack;

    public CalculatorStack() {
        numStack = new Stack<TerminalExpression>();
        opStack = new Stack<Character>();
    }

    public void push(TerminalExpression num) {
        numStack.push(num);
    }

    public void push(char op) {
        opStack.push(op);
    }

    public TerminalExpression popNumber() {
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

    public TerminalExpression numPeek() {
        return numStack.peek();
    }

    public char opPeek() {
        return opStack.peek();
    }

    public TerminalExpression operate(Expression op) {
        // Calculate for expressions

        TerminalExpression retValue = new TerminalExpression(op.solve());
        return retValue;
    }
    
}