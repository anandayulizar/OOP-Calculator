package sample;


public class AddExpression extends BinaryExpression {
    public AddExpression(Expression x, Expression y) {
        super(x, y);
    }

    public double solve() {
        return x.solve() + y.solve();
    }
}