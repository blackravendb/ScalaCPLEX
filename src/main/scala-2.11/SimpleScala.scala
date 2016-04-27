/**
  * Created by Dennis on 26.04.2016.
  */
class SimpleScala extends OPLBase {

  val X = new dvar[Double]
  val Y = new dvar[Double]

  solver maximize X + Y

  
}
