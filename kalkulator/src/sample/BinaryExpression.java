package sample;

abstract class BinaryExpression extends Expression {
    protected Expression x;
    protected Expression y;

    public BinaryExpression(Expression x, Expression y) {
        this.x = x;
        this.y = y;
    }

    abstract public double solve();
}