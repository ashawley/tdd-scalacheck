/** Franc.scala */

case class Franc(toInt: Int) extends Money {
  val currency = "CHF"
  def times(multiplier: Int) = {
    Franc(toInt * multiplier)
  }
  def equals(that: Dollar) = {
    toInt == that.toInt
  }
  def equals(that: Money) = {
    false
  }
}

object Franc {
  def fromInt(amount: Int) = Franc(amount)
}
