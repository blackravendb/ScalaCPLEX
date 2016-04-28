class SimpleScala extends OPLBase {

  val x = dvar[Double]
  val y = dvar[Double]
  val z = dvar[Int]

  goal maximize x + y

  //val expr:ExpressionScala = 2.0 times 'x plus 'y plus 10.0
  //val a = expr eq 20
  //val b = a.eq(20.0)
  //println(a)
  constraints add 2.0 ** x ++ y + 10.0 <= 20.0
  constraints add x * 2 + y + 10 <= 20

  constraints add x ++ 3.0 ** y >= 10.0
  constraints add x + 3 * y >= 10
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