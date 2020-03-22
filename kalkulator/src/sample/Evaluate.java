package sample;

public class Evaluate {
	private CalculatorStack<TerminalExpression> stack;

	public Evaluate() {
		stack = new CalculatorStack<TerminalExpression>();
	}

	public boolean isNumberCheck(String input, int idx) {
        return input.charAt(idx) >= '0' && input.charAt(idx) <= '9';
    }

    public TerminalExpression operate(Expression op) {
        // Calculate for expressions
        TerminalExpression retValue = new TerminalExpression(op.solve());
        return retValue;
    }

	public String calculate(String input) throws Exception {
        boolean prioBinaryExp = false; // Apakah sebelumnya terdapat operator binary dengan prio tinggi (* /)
        boolean unaryExp = false; // Apakah sebelumnya terdapat operator unary (untuk saat ini -)
        int kurungCount = 0;

        int i = 0;
        boolean adaakar = false;
        boolean titik = false;
        boolean negative = false;
        boolean angkaSebelumAkar = false;
        while (i < input.length()) {
            char curIdx = input.charAt(i);

            // If curIdx is a number
            if (curIdx >= '0' && curIdx <= '9') {
                double num = 0;
                while (i < input.length() && isNumberCheck(input, i)) {
                    num = (num * 10) + ((double) (input.charAt(i) - '0'));
                    i++;
                }
                TerminalExpression termNum = new TerminalExpression(num);

                if (titik) {
                    if (i + 1 < input.length() && input.charAt(i) == '.') {
                        throw new Exception("ERROR : Expected a Number");
                    }
                    TerminalExpression cur = stack.popNumber();
                    double num2 = num;
                    int panjang=1;
                    // baca angka dibelakang koma
                    while(num2>10){
                        num2/=10;
                        panjang++;
                    }
                    double blkgkoma = Math.pow(10,panjang);
                    double koma = cur.solve() + num/blkgkoma;
                    TerminalExpression hasil = new TerminalExpression(koma);
                    stack.push(hasil);
                    // stack.popOperator();
                    titik = false;
                } else {
                    stack.push(termNum);
                }

                if (i < input.length() && input.charAt(i) == '.') {
                    i++;
                    titik = true;
                    continue;
                }

                i--;

                if (unaryExp) {
                    if (adaakar) {
                        SquareRootExpression result = new SquareRootExpression(stack.popNumber());
                        while(!stack.isOpEmpty() && stack.opPeek() == 'V'){
                            termNum.x = result.solve();
                            result = new SquareRootExpression(termNum);
                            stack.popOperator();
                        }
                        adaakar = false;
                        if (angkaSebelumAkar) {
                        	termNum.x *= stack.popNumber().solve();
                        	angkaSebelumAkar = false;
                        }
                        stack.push(termNum);
                    }

                    if (negative) {
                        NegativeExpression negNum = new NegativeExpression(stack.popNumber());
                        termNum.x = negNum.solve();
                        stack.push(termNum);
                        stack.popOperator();
                        negative = false;
                    }

                    unaryExp = false;
                }

                if (prioBinaryExp) {
                    char lastOp = stack.popOperator();
                    if (lastOp != '*' && lastOp != '/') {
                        throw new Exception("ERROR : Operator overload");
                    }
                    BinaryExpression operator;
                    if (lastOp == '*') {
                        operator = new MultiplyExpression(stack.popNumber(), stack.popNumber());
                        stack.push(operate(operator));
                    } else if (lastOp == '/') {
                        TerminalExpression b = stack.popNumber();
                        if (b.solve() == 0) {
                            throw new Exception("ERROR : Cannot divide by zero");
                        }
                        operator = new DivideExpression(stack.popNumber(), b);
                        stack.push(operate(operator));
                    }
                    prioBinaryExp = false;
                }
            }

            // If index i is an operator
            else {
                if (curIdx == '*' || curIdx == '/') {
                    // Higher priorities
                    prioBinaryExp = true;
                } else if (curIdx =='-') {
                    // Invalid Operation : Expected a number after negative expression
                    if (!isNumberCheck(input, i + 1) && input.charAt(i + 1) != 'V') {
                        throw new Exception("ERROR : Expected a number after operation");
                    }

                    unaryExp = true;
                    negative = true;
                    if (i == 0 || (i - 1 > 0 && !isNumberCheck(input, i-1))) {
                        // 
                    } else {
                        stack.push('+');
                    }
                } else if (curIdx =='(') {
                    kurungCount++;
                } else if (curIdx ==')') {
                    char operator;
                    if (kurungCount == 0) {
                        throw new Exception("ERROR : Missing parentheses");
                    } else {
                        while (stack.opPeek() != '(') {
                            TerminalExpression a = stack.popNumber();
                            TerminalExpression b = stack.popNumber();
                            operator = stack.popOperator();
                            BinaryExpression operation;
                            if (operator == '+') {
                                operation = new AddExpression(b, a);
                            } else {
                                operation = new SubtractExpression(b, a);
                            }
                            stack.push(operate(operation));
                        }
                        operator = stack.popOperator();
                        kurungCount--;
                    }
                } else if(curIdx == 'V') {
                    // Invalid Operation : Expected a number at the end of root operation.
                    if (!isNumberCheck(input, i + 1) && input.charAt(i + 1) != 'V') {
                        throw new Exception("ERROR : Expected a number at the end of root");
                    }
                    if (isNumberCheck(input, i - 1)) {
                    	angkaSebelumAkar = true;
                    }
                    adaakar = true;
                    unaryExp = true;
                }

                if (curIdx != ')') {
                    // If unary don't push to stack
                    stack.push(curIdx);
                }
            }
            i++;
        }

        // Butuh exception klo kurungCount > 0, brarti belom nemu kurungTutup
        // jadinya error
        if (kurungCount > 0) {
            throw new Exception("ERROR : Missing parentheses");
        }

        // Empty the stack until there's no + or - left
        while (!stack.isOpEmpty()) {
            // Empty Stack : Expected a terminal expression to be operated
            if (stack.numSize() < 2) {
                throw new Exception("ERROR : Expected a terminal expression");
            }
            TerminalExpression a = stack.popNumber();
            TerminalExpression b = stack.popNumber();
            char operator = stack.popOperator();
            BinaryExpression operation;
            if (operator == '+') {
                operation = new AddExpression(b, a);
            } else {
                operation = new SubtractExpression(b, a);
            }
            stack.push(operate(operation));
        }

        double temp = stack.popNumber().solve();
        return Double.toString(temp);
    }

    public static void main(String[] args) {
        Evaluate calculate = new Evaluate();
        String str = "1.1.1";
        String hasilString = "";
        
        try {
            hasilString = calculate.calculate(str);
            double hasilDouble = Double.parseDouble(hasilString);
            long hasilLong = (long)hasilDouble;
            if (hasilDouble == hasilLong) {
                hasilString = Long.toString(hasilLong);
            }
        } catch (Exception e) {
            hasilString = e.getMessage();
        }
        System.out.println(hasilString);
    }
}