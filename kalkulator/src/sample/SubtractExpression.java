package sample;

public class SubtractExpression extends BinaryExpression {
    public SubtractExpression(Expression x, Expression y) {
        super(x, y);
    }

    public double solve() {
        return x.solve() - y.solve();
    }
}