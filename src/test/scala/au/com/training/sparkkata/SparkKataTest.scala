package au.com.training.sparkkata

import au.com.training.sparkKata.SparkKata._
import org.apache.spark.sql.SparkSession
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
    val sparkSession = createSparkSession
    val ds = loadDataset(sparkSession, androidAppDatasetPath)
    keepOnlyCategoryEducation(ds).count shouldEqual 156
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


  // Exercise 3:
  "Find the most Reviewed App" should
    "get 1 row with the number with a App name and the number of Review which should be [Facebook,78158306" ignore {
  }
}
