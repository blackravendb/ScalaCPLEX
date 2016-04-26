/**
  * Created by Dennis on 26.04.2016.
  */

trait Assignable[T] {
  var value : T = _

  def := (x : T) : Unit = {value = x}
}

class VariableScala[T] extends ExpressionScala with Assignable[T]  {
}

class dvar[T] extends ExpressionScala with Assignable[T] {
}