
object dvarType extends Enumeration {
  val float, float_+ = Value
}

class OPLBase extends OPL{
  val solver = new Solver


  /*
  implicit def constant(value: Double) = new ExpressionScala {
    override def eval(as: Assignment): Double = solver.constant(value).eval(as)
    override def toString: String = value.toString
  }
  }*/

  implicit def constant(value: Double): ExpressionScala = {
    println("Double " + value)
    new ExpressionScala {
      override def eval(as: Assignment): Double = solver.constant(value).eval(as)

      override def toString: String = value.toString
    }
  }
/*
  implicit class constantNumber(value: Int) {

    val constantValue = new ExpressionScala {
      override def eval(as: Assignment): Double = solver.constant(value).eval(as)
      override def toString: String = value.toString
    }


    def plus(e: Any): ExpressionScala = e match {
      case n:Double => {
        val that = new ExpressionScala {
          override def eval(as: Assignment): Double = solver.constant(4).eval(as)
          override def toString: String = value.toString
        }
        constantValue + that
      }
      case s: Symbol => {
        val that = new ExpressionScala {
          override def eval(as: Assignment): Double = as.get(s.name)
          override def toString: String = s.name
        }
        constantValue + that
      }
      case _ => throw new IllegalArgumentException
    }

    def times(e: Any): ExpressionScala = e match {
      case n:Double => {
        val that = new ExpressionScala {
          override def eval(as: Assignment): Double = solver.constant(4).eval(as)
          override def toString: String = value.toString
        }
        constantValue + that
      }
      case n:Int => {
        val that = new ExpressionScala {
          override def eval(as: Assignment): Double = solver.constant(4).eval(as)
          override def toString: String = value.toString
        }
        constantValue + that
      }
      case s: Symbol => {
        val that = new ExpressionScala {
          override def eval(as: Assignment): Double = as.get(s.name)
          override def toString: String = s.name
        }
        constantValue + that
      }
      case _ => throw new IllegalArgumentException
    }
  }
*/
  implicit def variable(symbol: Symbol) = {
    new ExpressionScala {
      override def eval(as: Assignment): Double = as.get(symbol.name)
      override def toString: String = symbol.name
    }
  }

  def dvar: dvar = new dvar

  class dvar {
    var typeName: dvarType.Value = dvarType.float

    def float(symbol: Symbol) = {
      typeName = dvarType.float
      solver.variable(symbol.name)
    }
  }

  override def toString: String = super.toString
}
