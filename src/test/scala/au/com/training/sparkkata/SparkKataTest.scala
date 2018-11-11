package au.com.training.sparkkata

import au.com.training.sparkKata.SparkKata
import au.com.training.sparkKata.SparkKata._
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.scalatest.{FlatSpec, Matchers}

class SparkKataTest extends FlatSpec with Matchers {

  val androidAppDatasetPath = "src/test/resources/googleplaystore.csv"
  val androidAppReviewsDatasetPath = "src/test/resources/googleplaystore_user_reviews.csv"

  def createSparkSession: SparkSession = SparkSession.builder()
    .appName(getClass.getName)
    .master("local[*]")
    .getOrCreate()

  // Exercise 1:
  "Get all movies from the EDUCATION Category" should
    "count number of rows in the filtered dataset" in {
    // GIVEN
    val sparkSession = createSparkSession
    val ds = loadDataset(sparkSession, androidAppDatasetPath)

    // WHEN
    val result = keepOnlyCategoryEducation(ds)

    // THEN
    result.count shouldEqual 156
  }

  //Exercise 2:
  /**
    * Here is your specification:
    * PERSONS with column AGE (int), FIRST_NAME (String), LAST_NAME (String), ID (Long)
    * ADDRESSES with columns ID (Long), ADDRESS (String)
    *
    * We want to recover only the persons who have one or more address(es) and who are strictly more than 32 years old
    *
    * This must be done using TDD
    */

  "exercise2" should "recover only the persons who have ONE address and who are strictly more than 32 years old" in {
    // GIVEN
    val sparkSession: SparkSession = createSparkSession
    import sparkSession.implicits._
    val persons = Seq((16, "Nick", "", 0L),
      (32, "Nicolas", "P", 1L),
      (34, "Miranda", "Test", 2L),
      (40, "FX", "Grump", 3L)
    ).toDF("AGE", "FIRST_NAME", "LAST_NAME", "ID")
    val addresses = Seq(
      (2L, "address 1"),
      (2L, "address 2"),
      (3L, "FX address")
    ).toDF("ID", "ADDRESS")

    // WHEN
    val result = SparkKata.exercise2(persons, addresses)

    // THEN
    result
      .filter(col("ID") === 3L && col("FIRST_NAME") === "FX")
      .count() shouldEqual 1
    result
      .filter(col("ID") === 2L && col("FIRST_NAME") === "Miranda")
      .count() shouldEqual 2
  }


  // Exercise 3:
  "Find the most Reviewed App" should
    "get 1 row with the number with a App name and the number of Review which should be [Facebook,78158306" in {
    // GIVEN
    val sparkSession = createSparkSession
    val ds = loadDataset(sparkSession, androidAppDatasetPath)

    // WHEN
    val result = getMostReviewedApp(ds)

    // THEN
    result.toString() shouldEqual "[Facebook,78158306]"
  }
}
