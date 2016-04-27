/**
  * Created by Ahmet on 26.04.2016.
  */
abstract class ExpressionScala extends Expression{

  def +(e: ExpressionScala) = new ExpressionScala {
    override def eval(as: Assignment): Double = this.sum(e).eval(as)
  }

  def -(e: ExpressionScala) = new ExpressionScala {
    override def eval(as: Assignment): Double = this.diff(e).eval(as)
  }

  def *(e: ExpressionScala) = new ExpressionScala {
    override def eval(as: Assignment): Double = this.prod(e).eval(as)
  }

  def /(e: ExpressionScala) = new ExpressionScala {
    override def eval(as: Assignment): Double = this.div(e).eval(as)
  }

  def ==(e: ExpressionScala) = this.eq(e)
  def <=(e: ExpressionScala) = this.leq(e)
  def >=(e: ExpressionScala) = this.geq(e)
}
