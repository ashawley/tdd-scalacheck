/** FrancSpec.scala */

import org.scalacheck.Properties
import org.scalacheck.Prop
import org.scalacheck.Prop.BooleanOperators
import org.scalacheck.Arbitrary
import org.scalacheck.Gen

object FrancSpec extends Properties("Franc") {

  val genFranc = for {
    amount <- Arbitrary.arbitrary[Int]
  } yield {
    Franc.fromInt(amount)
  }

  implicit val arbitraryFranc = Arbitrary {
    genFranc
  }

  property("multiplication") = {
    Prop.forAll { (d: Franc, e: Int) =>
      d.toInt * e == d.times(e).toInt
    }
  }

  property("equality") = {
    Prop.forAll { (d: Franc, e: Franc) =>
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
