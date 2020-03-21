package sample;

abstract class Expression {
  abstract public double solve();
}

class TerminalExpression extends Expression {
  protected double x;

  public TerminalExpression(double x) {
    this.x = x;
  }

  public double solve() {
    return this.x;
  }
}

abstract class UnaryExpression extends Expression {
  protected Expression x;

  public UnaryExpression(Expression x) {
    this.x = x;
  }

  abstract public double solve();
}

abstract class BinaryExpression extends Expression {
  protected Expression x;
  protected Expression y;

  public BinaryExpression(Expression x, Expression y) {
    this.x = x;
    this.y = y;
  }

  abstract public double solve();
}

class NegativeExpression extends UnaryExpression {
  public NegativeExpression(Expression x) {
    super(x);
  }

  public double solve() {
    return -1 * this.x.solve();
  }
}

class SquareRootExpression extends UnaryExpression {
  public SquareRootExpression(Expression x) {
    super(x);
  }

  public double solve() {
    return Math.sqrt(this.x.solve());
  }
}

class SubtractExpression extends BinaryExpression {
  public SubtractExpression(Expression x, Expression y) {
    super(x, y);
  }

  public double solve() {
    return x.solve() - y.solve();
  }
}

class AddExpression extends BinaryExpression {
  public AddExpression(Expression x, Expression y) {
    super(x, y);
  }

  public double solve() {
    return x.solve() + y.solve();
  }
}

class MultiplyExpression extends BinaryExpression {
  public MultiplyExpression(Expression x, Expression y) {
    super(x, y);
  }

  public double solve() {
    return x.solve() * y.solve();
  }
}

class DivideExpression extends BinaryExpression {
  public DivideExpression(Expression x, Expression y) {
    super(x, y);
  }

  public double solve() {
    return x.solve() / y.solve();
  }
}