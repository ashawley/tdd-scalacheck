/** Money.scala */

abstract class Money {
  def toInt: Int
  def currency: String
  override def toString = {
    s"$currency: $toInt" 
  }
  def times(multiplier: Int): Money
  def equals(that: Money): Boolean
}

