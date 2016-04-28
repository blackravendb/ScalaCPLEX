/**
  * Created by Dennis on 26.04.2016.
  */
object Main {
  def main(args: Array[String]): Unit = {

    val simpleScala = new  SimpleScala

    simpleScala.x := 10
    simpleScala.y := 20.1

    simpleScala.solve

    val simple2 = new SimpleScala

    simple2.x := 100
    simple2.y := 50

    simple2 solve

    val oilScala = new OilScala


  }
}
