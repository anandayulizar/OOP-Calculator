package sample;

abstract class UnaryExpression extends Expression {
    protected Expression x;

    public UnaryExpression(Expression x) {
        this.x = x;
    }

    abstract public double solve();
}