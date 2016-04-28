/**
  * Created by Dennis on 26.04.2016.
  */

trait Assignable[T] {
  var value : T = _

  def := (x : T) : Unit = {value = x}
}

class VariableScala[T](val name: String) extends ExpressionScala with Assignable[T]  {
  override def eval(as: Assignment): Double = as.get(name)
}

class DVariableScala[T](val name: String) extends ExpressionScala with Assignable[T] {
  override def eval(as: Assignment): Double = as.get(name)
}
