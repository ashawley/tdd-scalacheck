/** Dollar.scala */

case class Dollar(toInt: Int) extends Money {
  val currency = "USD"
  def times(multiplier: Int) = {
    Dollar(toInt * multiplier)
  }
  def equals(that: Dollar) = {
    toInt == that.toInt
  }
  def equals(that: Money) = {
    false
  }
}

object Dollar {
  def fromInt(amount: Int) = Dollar(amount)
}
