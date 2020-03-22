package sample;

public class DivideExpression extends BinaryExpression {
    public DivideExpression(Expression x, Expression y) {
        super(x, y);
    }

    public double solve() {
        return x.solve() / y.solve();
    }
}