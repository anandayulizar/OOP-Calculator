package sample;

public class Evaluate {
	private CalculatorStack stack;

	public Evaluate() {
		stack = new CalculatorStack();
	}

	public boolean isNumberCheck(String input, int idx) {
        return input.charAt(idx) >= '0' && input.charAt(idx) <= '9';
    }

	public String calculate(String input) throws Exception {
        boolean prioBinaryExp = false; // Apakah sebelumnya terdapat operator binary dengan prio tinggi (* /)
        boolean unaryExp = false; // Apakah sebelumnya terdapat operator unary (untuk saat ini -)
        int kurungCount = 0;

        int i = 0;
        boolean adaakar = false;
        boolean titik = false;
        boolean negative = false;
        while (i < input.length()) {
            char curIdx = input.charAt(i);
            System.out.println(curIdx);

            // If curIdx is a number
            if (curIdx >= '0' && curIdx <= '9') {
                double num = 0;
                while (i < input.length() && isNumberCheck(input, i)) {
                    num = (num * 10) + ((double) (input.charAt(i) - '0'));
                    i++;
                }
                TerminalExpression termNum = new TerminalExpression(num);

                if (titik) {
                    //System.out.println("ini i "+i);
                    //i-=1;
                    //System.out.println("masuk1");
                    TerminalExpression cur = stack.popNumber();
//                    System.out.println(cur.solve());
                    double num2 = num;
                    int panjang=1;
                    // baca angka dibelakang koma
                    while(num2>10){
                        num2/=10;
                        panjang++;
                    }
//                    System.out.println(num2);
                    //System.out.println("ini panjang " + panjang);
                    double blkgkoma = Math.pow(10,panjang);
                    double koma = cur.solve() + num/blkgkoma;
                    TerminalExpression hasil = new TerminalExpression(koma);
//                    System.out.println("ini hasil" + hasil.solve());
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
                    System.out.println("prioBinaryExp ! i : " + i);
                    char lastOp = stack.popOperator();
                    BinaryExpression operator;
//                  Invalid Operation: Expected a number, not an operator.
//                    if (i < input.length() - 1) {
//                        if (!isNumberCheck(input, i) && input.charAt(i) != '-' && input.charAt(i) != 'V') {
//                            System.out.println("Error setelah kali / bagi. Char di i : " + input.charAt(i));
//                            throw new Exception("ERROR : Invalid Operation");
//                        }
//                    }
//                    if (i > 1) {
//                        if (!isNumberCheck(input, i - 2)) {
//                            System.out.println("Error sebelum kali / bagi. Char di " + i + " - 2 : " + input.charAt(i - 2));
//                            System.out.println(input.charAt(i - 2));
//                            throw new Exception("ERROR : Invalid Operation");
//                        }
//                    }
                    if (lastOp == '*') {
                        operator = new MultiplyExpression(stack.popNumber(), stack.popNumber());
                        stack.push(stack.operate(operator));
                    } else if (lastOp == '/') {
                        TerminalExpression b = stack.popNumber();
                        operator = new DivideExpression(stack.popNumber(), b);
                        stack.push(stack.operate(operator));
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
                    if (!isNumberCheck(input, i + 1)) {
                        throw new Exception("ERROR : Invalid Operation");
                    }
                    if (i == 0 || !(input.charAt(i - 1) >= '0' && input.charAt(i - 1) <= '9')) {
                        unaryExp = true;
                        negative = true;
                    }
                } else if (curIdx =='(') {
                    kurungCount++;
                } else if (curIdx ==')') {
                    char operator;
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
                        stack.push(stack.operate(operation));
                    }
                    operator = stack.popOperator();
                    kurungCount--;
                } else if(curIdx == 'V') {
                    // Invalid Operation : Expected a number at the end of root operation.
                    if (!isNumberCheck(input, i + 1) && input.charAt(i + 1) != 'V') {
                        System.out.println("Error akar. Char at " + i + " + 1 : " + input.charAt(i + 1));
                        throw new Exception("ERROR : Invalid Operation");
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

        // Empty the stack until there's no + or - left
        while (!stack.isOpEmpty()) {
            // Empty Stack : Expected a terminal expression to be operated
            if (stack.numSize() < 2) {
                throw new Exception("ERROR : Empty Stack");
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
            stack.push(stack.operate(operation));
        }

        double temp = stack.popNumber().solve();
        System.out.println("Solve : " + temp);
        return Double.toString(temp);
    }

    public static void main(String[] args) {
        Evaluate stack = new Evaluate();
        String str = "V2.56";
        String hasilString = "";
        
        try {
            hasilString = stack.calculate(str);
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