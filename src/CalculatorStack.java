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

    public void pushNumber(TerminalExpression num) {
        numStack.push(num);
    }

    public void pushOperator(char op) {
        opStack.push(op);
    }

    public TerminalExpression popNumber() {
        return numStack.pop();
    }

    public char popOperator() {
        return opStack.pop();
    }

    public TerminalExpression operate(Expression op) {
        // Temporary calculate for expressions

        TerminalExpression retValue = new TerminalExpression(op.solve());
        // switch(op) {
        //     case '+':
        //         retValue = a + b;
        //         break;
        //     case '-':
        //         retValue = a - b;
        //         break;
        //     case '*':
        //         retValue = a * b;
        //         break;
        //     case '/':
        //         retValue = a / b;
        //         break;
        //     default:
        //         retValue = a + b;
        // }
        
        return retValue;
    }

    public TerminalExpression calculate(String input) {
        for (int i = 0; i < input.length(); i++) {
            char curIdx = input.charAt(i);

            // If curIdx is a number
            if (curIdx >= '0' && curIdx <= '9') {
                double num = 0;
                // Takes all the number until index i meets an operator
                while (i < input.length() && input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                    num = (num * 10) + ((double) (input.charAt(i) - '0'));
                    i++;
                }
                i--;
                TerminalExpression termNum = new TerminalExpression(num);
                this.pushNumber(termNum);
                // System.out.println(num);
            }

            // If index i is an operator
            else {
                if (curIdx == '*' || curIdx == '/') {
                    // Higher priorities
                    double nextNumTemp = (double) (input.charAt(i + 1) - '0');
                    TerminalExpression nextNum = new TerminalExpression(nextNumTemp);
                    // System.out.println(nextNum);
                    BinaryExpression operator;
                    if (curIdx == '*') {
                        operator = new MultiplyExpression(this.popNumber(), nextNum);
                    } else {
                        operator = new DivideExpression(this.popNumber(), nextNum);
                    }
                    i++;
                    this.pushNumber(this.operate(operator));
                } else {
                    // + or -
                    this.pushOperator(curIdx);
                }
            }
        }

        // Empty the stack until there's no + or - left
        while (!opStack.empty()) {
            // System.out.println(numStack.peek());
            // System.out.println(opStack.peek());
            TerminalExpression a = numStack.pop();
            TerminalExpression b = numStack.pop();
            char operator = this.popOperator();
            BinaryExpression operation;
            if (operator == '+') {
                operation = new AddExpression(b, a);
            } else {
                operation = new SubtractExpression(b, a);
            }
            this.pushNumber(this.operate(operation));
        }

        return numStack.pop();
    }

    public static void main(String[] args) {
        // For Debugging

        CalculatorStack a = new CalculatorStack();
        TerminalExpression result = a.calculate("1+30*5-5");
        System.out.println(result.solve());   
    }
}