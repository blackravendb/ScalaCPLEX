
object Main {
  def main(args: Array[String]): Unit = {
    val simpleScala = new  SimpleScala

    simpleScala.x := 10
    simpleScala.y := 20.1

    simpleScala.solve


    val oilScala = new OilScala
  }
}
