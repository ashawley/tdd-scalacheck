/** MoneySpec.scala */

import org.scalacheck.Properties
import org.scalacheck.Prop
import org.scalacheck.Prop.BooleanOperators
import org.scalacheck.Arbitrary
import org.scalacheck.Gen

object MoneySpec extends Properties("Money") {

  import DollarSpec.arbitraryDollar
  import FrancSpec.arbitraryFranc

  val genMoney = Gen.oneOf(
    Arbitrary.arbitrary[Dollar],
    Arbitrary.arbitrary[Franc]
  )

  implicit val arbitraryMoney: Arbitrary[Money] = Arbitrary {
    genMoney
  }

  property("toInt") = {
    Prop.forAll { (d: Money) =>
      d.toInt >= 0 || d.toInt < 0
    }
  }

  property("currency") = {
    Prop.forAll { (d: Money) =>
      Prop.iff[Money](d, {
        case Dollar(_) => d.currency == "USD"
        case Franc(_) => d.currency == "CHF"
      })
    }
  }

  property("multiplication") = {
    Prop.forAll { (m: Money, i: Int) =>
      m.toInt * i == m.times(i).toInt
    }
  }

  property("equals") = {
    Prop.forAll { (d: Money, e: Money) =>
      Prop.atLeastOne(
        (d.toInt == e.toInt && d.currency == e.currency) ==> (d == e),
        (d.toInt != e.toInt || d.currency != e.currency) ==> (d != e)
      )
    }
  }

}
