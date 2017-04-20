/** DollarSpec.scala */

import org.scalacheck.Properties
import org.scalacheck.Prop
import org.scalacheck.Prop.BooleanOperators
import org.scalacheck.Arbitrary
import org.scalacheck.Gen

object DollarSpec extends Properties("Dollar") {

  val genDollar = for {
    amount <- Arbitrary.arbitrary[Int]
  } yield {
    Dollar.fromInt(amount)
  }

  implicit val arbitraryDollar = Arbitrary {
    genDollar
  }

  property("multiplication") = {
    Prop.forAll { (d: Dollar, e: Int) =>
      d.toInt * e == d.times(e).toInt
    }
  }

  property("equality") = {
    Prop.forAll { (d: Dollar, e: Dollar) =>
      Prop.all(
        d == d,
        e == e,
        Prop.atLeastOne(
          (e.toInt == d.toInt) ==> (e == d),
          (e.toInt != d.toInt) ==> (e != d)
        )
      )
    }
  }
}
