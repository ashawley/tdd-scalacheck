/** Franc.scala */

case class Franc(toInt: Int) {
  val currency = "CHF"
  def times(multiplier: Int) = {
    Franc(toInt * multiplier)
  }
  def equals(that: Dollar) = {
    toInt == that.toInt
  }
}

object Franc {
  def fromInt(amount: Int) = Franc(amount)
}
