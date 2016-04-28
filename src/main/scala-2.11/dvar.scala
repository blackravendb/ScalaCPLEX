import com.sun.javaws.exceptions.InvalidArgumentException

class Dvar[T <: AnyVal]() extends ExpressionScala{
  var value : Double = 0
  override def eval(as: Assignment): Double = as.get(this.toString)

  override def toString = " " + super.toString + " "

  def :=(value : T) = value match {
    case i: Int => this.value = i.toDouble
    case d : Double => this.value = d
    case f : Float => this.value = f.toDouble
    case _ => throw new InvalidArgumentException(Array[String]{"Unsupported type: " + value.getClass().getName()})
  }
}
