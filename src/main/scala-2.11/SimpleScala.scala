/**
  * Created by Dennis on 26.04.2016.
  */
class SimpleScala extends OPLBase {

  val X = new dvar[Double]
  val Y = new dvar[Double]

  solver maximize X + Y

  solver add 2 * X + Y + 10 <= 20
  solver add X + 3 * Y >= 10
}
