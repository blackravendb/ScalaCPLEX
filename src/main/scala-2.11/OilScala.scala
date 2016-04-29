class OilScala extends OPLBase{
  val rawMaterial: Double = 205
  val products: Array[String] = Array("light", "medium", "heavy")
  val demand: Array[Double] = Array(59, 12, 13)
  val processes: Array[String] = Array("p1", "p2")
  val production: Array[Array[Double]] = Array(Array(12, 16), Array(1, 7), Array(4, 2))
  val consumption: Array[Double] = Array(25, 30)
  val cost: Array[Double] = Array(300, 400)
  //
  val solver: Solver = new Solver
  val run: ExprListScala = variables(processes)
  goal minimize run.sumProd(constants(cost))
  constraints add run.sumProd(constants(consumption)) <= constant(rawMaterial)
  var q: Int = 0

  while (q < products.length) {
    var x: ExpressionScala = 0
    var p: Int = 0
    while (p < processes.length) {
      val c = constant(production(q)(p))
      x = x + run.scalaGet(p) + c
      p += 1
    }
    constraints add x >= constant(demand(q))
    q += 1

  }
  //
  val as: Assignment = new Assignment
  as.put("p1", 2.25)
  as.put("p2", 2.0)
  solver.solve(as)
}