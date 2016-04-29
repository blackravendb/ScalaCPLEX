class SimpleScala extends OPLBase {

  val x = dvar[Double]
  val y = dvar[Double]
  val z = dvar[Int]

  //dvar float 'x

  goal maximize x + y

  constraints add 2.0 ** x ++ y + 10.0 <= 20.0
  constraints add x * 2 + y + 10 <= 20

  constraints add x ++ 3.0 ** y >= 10.0
  constraints add x + 3 * y >= 10
}
