/**
  * Created by Dennis on 26.04.2016.
  */
trait OPLBase {
val solver = new Solver

  def dvar(name: String) = new ExpressionScala(solver.variable(name))
}
