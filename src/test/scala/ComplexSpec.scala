import org.scalatest._

class ComplexSpec extends FlatSpec with DiagrammedAssertions {

  val c1 = new Complex(1,1)

  assert(c1.toString() === "1.0+1.0i")
  assert((new Complex(-1, -1)).toString() === "-1.0-1.0i")

  assert(c1.abs() === Math.sqrt(2))

  val c2 = new Complex(2,2)
  val c3 = new Complex(3,3)

  assert(c1.add(c2).equal(c3))
  assert(c1.sub(c2).equal(new Complex(-1, -1)))

  val c4 = new Complex(0,1)
  assert(c4.multiplication(c4).equal(new Complex(-1, 0)))

  assert((new Complex(1,0)).multiplication(new Complex(1,0)).equal(new Complex(1,0)))

  assert((new Complex(1,1)).conjugate().equal(new Complex(1, -1)))

  c2.multiplication(c3).conjugate().equal(c2.conjugate().multiplication(c3.conjugate()))
  c2.conjugate().conjugate().equal(c2)
  assert(c2.abs() === c2.conjugate().abs())

  assert((new Complex(2,3)).re() === 2)
  assert((new Complex(2,3)).im() === 3)

  assert(c2.add(c2.conjugate()).re() === c2.re() * 2)
  assert(c2.sub(c2.conjugate()).im() === c2.im() * 2)

  c1.pow(2).equal(c1.multiplication(c1))
  c1.pow(2).equal(c1.multiplication(c1))

}
