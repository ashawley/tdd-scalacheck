/** Dollar.scala */

case class Dollar(toInt: Int) {
  val currency = "USD"
  def times(multiplier: Int) = {
    Dollar(toInt * multiplier)
  }
  def equals(that: Dollar) = {
    toInt == that.toInt
  }
}

object Dollar {
  def fromInt(amount: Int) = Dollar(amount)
}
