/**
  * Created by Ahmet on 26.04.2016.
  */
abstract class ExpressionScala extends Expression{

  def +(e: ExpressionScala) = new ExpressionScala {
    val selfExpression: Expression = this.sum(e)
    override def eval(as: Assignment): Double = selfExpression.eval(as)
    override def toString = selfExpression.toString
  }

  def -(e: ExpressionScala) = new ExpressionScala {
    val selfExpression: Expression = this.diff(e)
    override def eval(as: Assignment): Double = selfExpression.eval(as)
    override def toString = selfExpression.toString
  }

  def *(e: ExpressionScala) = new ExpressionScala {
    val selfExpression: Expression = this.prod(e)
    override def eval(as: Assignment): Double = selfExpression.eval(as)
    override def toString = selfExpression.toString
  }

  def /(e: ExpressionScala) = new ExpressionScala {
    val selfExpression: Expression = this.div(e)
    override def eval(as: Assignment): Double = selfExpression.eval(as)
    override def toString = selfExpression.toString
  }

  def ==(e: ExpressionScala) = this.eq(e)
  def <=(e: ExpressionScala) = this.leq(e)
  def >=(e: ExpressionScala) = this.geq(e)
}
