

class VariableScala(val name: String) extends ExpressionScala{
  override def eval(as: Assignment): Double = as.get(name)
  override def toString: String = name
}