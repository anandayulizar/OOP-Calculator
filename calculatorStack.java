import java.util.Stack;

class calculatorStack {
    private Stack<Double> numStack;
    private Stack<Character> opStack;

    public calculatorStack() {
        numStack = new Stack<Double>();
        opStack = new Stack<Character>();
    }

    public void push(double num) {
        numStack.push(num);
    }

    public void push(char op) {
        opStack.push(op);
    }

    public double pop_number() {
        return numStack.pop();
    }

    public char pop_operator() {
        return opStack.pop();
    }

    public static double operate(double a, double b, char op) {
        // Temporary calculate for expressions

        double retValue;
        switch(op) {
            case '+':
                retValue = a + b;
                break;
            case '-':
                retValue = a - b;
                break;
            case '*':
                retValue = a * b;
                break;
            case '/':
                retValue = a / b;
                break;
            default:
                retValue = a + b;
        }

        return retValue;
    }

    public double calculate(String input) {
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
                this.push(num);
                // System.out.println(num);
            }

            // If index i is an operator
            else {
                if (curIdx == '*' || curIdx == '/') {
                    // Higher priorities
                    double nextNum = (double) (input.charAt(i + 1) - '0');
                    // System.out.println(nextNum);
                    i++;
                    this.push(operate(this.pop_number(), nextNum, curIdx));
                } else {
                    // + or -
                    this.push(curIdx);
                }
            }


        }

        // Empty the stack until there's no + or - left
        while (!opStack.empty()) {
            // System.out.println(numStack.peek());
            // System.out.println(opStack.peek());
            double a = numStack.pop();
            double b = numStack.pop();
            this.push(operate(b, a, this.pop_operator()));
        }

        return numStack.pop();
    }

    public static void main(String[] args) {
        // For Debugging

        calculatorStack a = new calculatorStack();
        System.out.println(a.calculate("1+3*5-4/2"));
    }
}