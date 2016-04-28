/**
  * Created by Ahmet on 26.04.2016.
  */
abstract class ExpressionScala extends Expression {

  def +(e: ExpressionScala): ExpressionScala = {
    //println("Action: +")
    val expr: Expression = this.sum(e)

    ExpressionScala.createExpression(expr)
  }

  def -(e: ExpressionScala): ExpressionScala = {
    //println("Action: -")
    val expr: Expression = this.diff(e)

    ExpressionScala.createExpression(expr)
  }

  def *(e: ExpressionScala): ExpressionScala = {
    //println("Action: *")
    val expr: Expression = this.prod(e)

    ExpressionScala.createExpression(expr)
  }

  def /(e: ExpressionScala): ExpressionScala = {
    //println("Action: /")
    val expr: Expression = this.div(e)

    ExpressionScala.createExpression(expr)
  }

  def ++(e: ExpressionScala): ExpressionScala = this + e
  def --(e: ExpressionScala): ExpressionScala = this - e
  def **(e: ExpressionScala): ExpressionScala = this * e
  // : am ende eines operators macht es zu einem infix operator
  def ::(e: ExpressionScala): ExpressionScala = this / e
  def :/(e: ExpressionScala): ExpressionScala = this / e


  def ==(e: ExpressionScala) = this.eq(e)
  def <=(e: ExpressionScala) = this.leq(e)
  def >=(e: ExpressionScala) = this.geq(e)


  /*

  def plus(a: Any): ExpressionScala = a match {
    case e:ExpressionScala => this + e
    case s:Symbol => this + new ExpressionScala {
      override def eval(as: Assignment): Double = as.get(s.name)
      override def toString: String = s.name
    }
    case doubleOrInt @(_: Double | _: Int) => {
      val d = a.asInstanceOf[Double]
      this + new ExpressionScala {
        override def eval(as: Assignment): Double = d
        override def toString: String = d.toString
      }
    }
    case _ => throw new IllegalArgumentException(a.getClass.getName)
  }
    def times(a: Any): ExpressionScala = a match {
      case e:ExpressionScala => this * e
      case s:Symbol => this * new ExpressionScala {
        override def eval(as: Assignment): Double = as.get(s.name)
      }
      case doubleOrInt @ (_:Double | _:Int) => {
        val d = a.asInstanceOf[Double]
        this * new ExpressionScala {
          override def eval(as: Assignment): Double = d
        }
      }
      case _ => throw new IllegalArgumentException
    }
    */
  /*
def ===(a: AnyVal): Constraint = {
  //println(a.getClass.getName)

  val that = new ExpressionScala {
    override def eval(as: Assignment): Double = {
      if(a.isInstanceOf[Int])
        a.asInstanceOf[Int].toDouble
      else
        a.asInstanceOf[Double]
    }
  }
  this.eq(that)
}

def <=:(a: AnyVal): Constraint = {
  //println(a.getClass.getName)
  val d = if(a.isInstanceOf[Int])
        a.asInstanceOf[Int].toDouble
      else
        a.asInstanceOf[Double]

  val that = new ExpressionScala {
    override def eval(as: Assignment): Double = d

    override def toString: String = "" + d
  }
  this.leq(that)
}

def >==(a: AnyVal): Constraint = {
  //println(a.getClass.getName)
  val self = this
  val that = new ExpressionScala {
    override def eval(as: Assignment): Double = {
      if(a.isInstanceOf[Int])
        a.asInstanceOf[Int].toDouble
      else
        a.asInstanceOf[Double]
    }

    override def toString: String = a.toString
  }
  this.geq(that)
}
*/
}

object ExpressionScala {

  def createExpression(expr: Expression) = new ExpressionScala {
    override def eval(as: Assignment): Double = expr.eval(as)
    override def toString = expr.toString
  }
}