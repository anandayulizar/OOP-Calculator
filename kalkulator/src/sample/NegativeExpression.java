package sample;

public class NegativeExpression extends UnaryExpression {
    public NegativeExpression(Expression x) {
        super(x);
    }

    public double solve() {
        return -1 * this.x.solve();
    }
}