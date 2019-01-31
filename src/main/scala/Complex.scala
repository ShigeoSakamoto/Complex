class Complex(val x: Double, val y: Double) {
  def abs(): Double = Math.sqrt(x * x + y * y)
  def add(c: Complex): Complex = new Complex(x + c.x, y + c.y)
  def sub(c: Complex): Complex = new Complex(x - c.x, y - c.y)
  def multiplication(c: Complex): Complex = new Complex(x * c.x - y * c.y, y * c.x + x * c.y)
  def equal(c: Complex): Boolean = x == c.x && y == c.y
  def conjugate(): Complex = new Complex(x, -1 * y)
  def re(): Double = x
  def im(): Double = y
  def pow(n: Int): Complex = {
    n match {
      case 1 => this
      case _ => this.multiplication(this.pow(n - 1))
    }
  }

  override def toString: String = {
    if (y < 0) {
      x + "-" + Math.abs(y) + "i"
    } else {
      x + "+" + Math.abs(y) + "i"
    }
  }
}
