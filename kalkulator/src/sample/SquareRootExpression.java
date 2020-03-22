package sample;

public class SquareRootExpression extends UnaryExpression {
    public SquareRootExpression(Expression x) {
        super(x);
    }

    public double solve() {
        return Math.sqrt(this.x.solve());
    }
}