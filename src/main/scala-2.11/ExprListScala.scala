/**
  * Created by Ahmet on 28.04.2016.
  */
class ExprListScala(capa: Int) extends ExprList(capa) {

  def sumProd(that: ExprListScala): ExpressionScala = {
    return zip(that, (x: ExpressionScala, y: ExpressionScala) => x * y).sum
  }

  def zip(that: ExprList, f: (ExpressionScala, ExpressionScala) => ExpressionScala): ExprListScala = {
    val resize: Int = Math.min(size, that.size)
    val result = new ExprListScala(resize)
    var i: Int = 0
    while (i < resize) {
      result.add(f(get(i).asInstanceOf[ExpressionScala], that.get(i).asInstanceOf[ExpressionScala]))
      i += 1
    }

    result
  }

  def scalaGet(x: Int) = { // Ugly
    get(x).asInstanceOf[ExpressionScala]
  }

  def sum(f: ExpressionScala => ExpressionScala): ExpressionScala = {
    return map(f).reduce((x, y) => x + y)
  }

  override def sum: ExpressionScala = {
    return sum(x => x)
  }

  def map(f: ExpressionScala => ExpressionScala): ExprListScala = {
    return map((i, x) => f(x))
  }

  def map(f: (Int, ExpressionScala) => ExpressionScala): ExprListScala = {
    val result = new ExprListScala(size)
    var i: Int = 0
    while (i < size) {
      result.add(f(i, get(i).asInstanceOf[ExpressionScala]))
      i += 1
    }

    result
  }

  def reduce(f: (ExpressionScala, ExpressionScala) => ExpressionScala): ExpressionScala = {
    var x: Option[ExpressionScala] = None

    import scala.collection.JavaConversions._

    for (e <- this) {
      val expressionScala = e.asInstanceOf[ExpressionScala]
      if (x.isEmpty) {
        x = Some(expressionScala)
      }
      else {
        x = Some(f(x.get, expressionScala))
      }
    }

    x.get
  }

}
