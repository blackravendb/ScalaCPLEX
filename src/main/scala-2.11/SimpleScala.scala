/**
  * Created by Dennis on 26.04.2016.
  */
class SimpleScala extends OPLBase {

  //val X = new dvar[Double]("X")
  //val Y = new dvar[Double]("Y")
  // dvar float+ y
  dvar float 'x
  dvar float 'y

  // val a = 2 + 2 + 'y

  solver maximize 'x + 'y

  //val expr:ExpressionScala = 2.0 times 'x plus 'y plus 10.0
  //val a = expr eq 20
  //val b = a.eq(20.0)
  //println(a)

  solver add 2.0 ** 'x ++ 'y + 10.0 <= 20.0
  solver add 'x ++ 3.0 ** 'y >= 10.0

  val as = new Assignment
  as.put("x", 20.0)
  as.put("y", 2.0)
  solver.solve(as)
}

/*
variable: x
variable: y
maximize: (x+y)
constraint: ((2.0*x)+(y+10.0)) <= 20.0
constraint: (x+(3.0*y)) >= 10.0
VARIABLES
0.0 = x
10.0 = y
CONSTRAINTS
true = ((2.0*x)+(y+10.0)) <= 20.0
true = (x+(3.0*y)) >= 10.0
 */