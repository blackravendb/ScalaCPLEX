import java.util

import scala.collection.mutable

abstract class OPLBase {
  private val solver = new Solver
  protected val constraints = new ConstraintScala
  private val dVars = new mutable.ArrayBuffer[Dvar[AnyVal]]()
  private val variables = new mutable.ArrayBuffer[ExpressionScala]()
  protected val goal = new GoalScala(solver)

  implicit def constant(value: Double): ExpressionScala = {
    println("Double " + value)
    new ExpressionScala {
      override def eval(as: Assignment): Double = solver.constant(value).eval(as)

      override def toString: String = value.toString
    }
  }

  implicit def constant(value: Int): ExpressionScala = {
    println("Double " + value)
    new ExpressionScala {
      override def eval(as: Assignment): Double = solver.constant(value).eval(as)

      override def toString: String = value.toString
    }
  }

  def dvar[T <: AnyVal] = {
    val v = new Dvar[AnyVal]
    dVars += v
    v
  }

  def solve = {
    val as = new Assignment

    val constraintIterator = constraints.iterator
    while(constraintIterator hasNext){
      var constraint = constraintIterator.next()
      solver add constraint
    }

    val dvarIterator = dVars.iterator
    while (dvarIterator.hasNext) {
      var dvar = dvarIterator next()
      as put(dvar.toString, dvar.value)
    }

    solver solve(as)
  }

  def variable(name: String) = {
    val v = new VariableScala(name)
    variables += v
    v
  }

  def variables(names: Array[String]): ExprListScala = {
    val list: ExprListScala = new ExprListScala(names.length)
    var i: Int = 0
    while (i < names.length) {
      list.add(variable(names(i)))
      i += 1
    }
    list
  }

  def constants(values: Array[Double]): ExprListScala = {
    val list: ExprListScala = new ExprListScala(values.length)
    var i: Int = 0
    while (i < values.length) {
      list.add(constant(values(i)))
      i += 1
    }
    list
  }
}
