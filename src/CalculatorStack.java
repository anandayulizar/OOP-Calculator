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
        // Calculate for expressions

        TerminalExpression retValue = new TerminalExpression(op.solve());
        return retValue;
    }

    public String calculate(String input) {
        boolean prioBinaryExp = false; // Apakah sebelumnya terdapat operator binary dengan prio tinggi (* /)
        boolean unaryExp = false; // Apakah sebelumnya terdapat operator unary (untuk saat ini -)
        int kurungCount = 0;

        int i = 0;
        while (i < input.length()) {
            char curIdx = input.charAt(i);
            // System.out.println(curIdx);

            // If curIdx is a number
            if (curIdx >= '0' && curIdx <= '9') {
                double num = 0;
                while (i < input.length() && input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                    num = (num * 10) + ((double) (input.charAt(i) - '0'));
                    i++;
                }
                i--;
                // System.out.println(num);
                TerminalExpression termNum = new TerminalExpression(num);

                // If the previous char is a unary operator, calculate first
                if (unaryExp) {
                    NegativeExpression negNum = new NegativeExpression(termNum);
                    // System.out.println(negNum.solve());
                    termNum.x = negNum.solve();
                    
                    unaryExp = false;
                }

                // If the previous char is a high priority binary operator, calculate first
                if (prioBinaryExp) {
                    char lastOp = this.popOperator();
                    BinaryExpression operator;
                    if (lastOp == '*') {
                        operator = new MultiplyExpression(this.popNumber(), termNum);
                        this.pushNumber(this.operate(operator));
                    } else if (lastOp == '/') {
                        operator = new DivideExpression(this.popNumber(), termNum);
                        this.pushNumber(this.operate(operator));
                    }

                    prioBinaryExp = false;
                } else {
                    this.pushNumber(termNum);
                }
                
                // System.out.println(i);
            }

            // If index i is an operator
            else {
                if (curIdx == '*' || curIdx == '/') {
                    // Higher priorities
                    prioBinaryExp = true;
                } else if (curIdx =='-') {
                    if (!(input.charAt(i-1) >= '0' && input.charAt(i-1) <= '9')) {
                        // Apply unary expression to next number
                        unaryExp = true;
                    }
                } else if (curIdx =='(') {
                    kurungCount++;
                } else if (curIdx ==')') {
                    char operator;
                    while (opStack.peek() != '(') {
                        TerminalExpression a = numStack.pop();
                        TerminalExpression b = numStack.pop();
                        operator = this.popOperator();
                        BinaryExpression operation;
                        if (operator == '+') {
                            operation = new AddExpression(b, a);
                        } else {
                            operation = new SubtractExpression(b, a);
                        }
                        this.pushNumber(this.operate(operation));
                    }
                    operator = this.popOperator();
                    kurungCount--;
                }

                if (!unaryExp && curIdx != ')') {
                    // If unary don't push to stack
                    this.pushOperator(curIdx);
                }
            }
            i++;
        }

        // Butuh exception klo kurungCount > 0, brarti belom nemu kurungTutup
        // jadinya error

        // Empty the stack until there's no + or - left
        while (!opStack.empty()) {
            // System.out.println("Top:");
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

        return Double.toString(numStack.pop().solve());
    }

    public static void main(String[] args) {
        // For Debugging

        CalculatorStack a = new CalculatorStack();
        String result = a.calculate("(1+(2-5))*3-(5/-2)");
        System.out.println(result);   
    }
}