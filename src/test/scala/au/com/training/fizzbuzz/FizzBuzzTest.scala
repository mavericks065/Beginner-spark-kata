package au.com.training.fizzbuzz

import org.scalatest._

class FizzBuzzTest extends FlatSpec with Matchers {

  it should "return fizz if the number is dividable by 3" in {
    // GIVEN
    val number = 6

    // WHEN
    val result = FizzBuzz.getResult(number)

    // THEN
    result shouldEqual "fizz"
  }

  it should "return buzz if the number is dividable by 5" in {
    // GIVEN
    val number = 10

    // WHEN
    val result = FizzBuzz.getResult(number)

    // THEN
    result shouldEqual "buzz"
  }

  it should "return fizzbuzz if the number is dividable by 15" in {
    // GIVEN
    val number = 15

    // WHEN
    val result = FizzBuzz.getResult(number)

    // THEN
    result shouldEqual "fizzbuzz"
  }

  it should "return the number if the number is not dividable by 3/5/15" in {
    // GIVEN
    val number = 257

    // WHEN
    val result = FizzBuzz.getResult(number)

    // THEN
    result shouldEqual "257"
  }

}
