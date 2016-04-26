/**
  * Created by Ahmet on 26.04.2016.
  */
class ExpressionScala(expr : Expression) {
  def +(e: ExpressionScala) = new ExpressionScala(expr.sum(e.expr))
  def -(e: ExpressionScala) = new ExpressionScala(expr.diff(e.expr))
  def *(e: ExpressionScala) = new ExpressionScala(expr.prod(e.expr))
  def /(e: ExpressionScala) = new ExpressionScala(expr.div(e.expr))
  def ==(e: ExpressionScala) = expr.eq(e.expr)
  def <=(e: ExpressionScala) = expr.leq(e.expr)
  def >=(e: ExpressionScala) = expr.geq(e.expr)
}
