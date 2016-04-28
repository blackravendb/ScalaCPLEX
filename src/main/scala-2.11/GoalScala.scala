/**
  * Created by Dennis on 28.04.2016.
  */
class GoalScala(solver : Solver) {

  def maximize (e : ExpressionScala) = solver maximize = e

  def minimize (e : ExpressionScala) = solver minimize = e
}
