package sample;

public class MultiplyExpression extends BinaryExpression {
    public MultiplyExpression(Expression x, Expression y) {
        super(x, y);
    }

    public double solve() {
        return x.solve() * y.solve();
    }
}