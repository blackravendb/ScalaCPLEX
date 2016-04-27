import scala.collection.mutable.ListBuffer

/**
  * Created by Dennis on 26.04.2016.
  */
trait OPLBase extends OPL{
  val solver = new Solver

  implicit def constant(value: Double) = new ExpressionScala {
    override def eval(as: Assignment): Double = solver.constant(value).eval(as)
  }

  implicit def constant(value: Int) = new ExpressionScala {
    override def eval(as: Assignment): Double = solver.constant(value).eval(as)
  }

}
