package au.com.training.sparkKata

import org.apache.spark.sql.functions.{col, desc, lit, sum}
import org.apache.spark.sql.{Dataset, Row, SparkSession}

object SparkKata {

  def loadDataset(sparkSession: SparkSession, csvPath: String): Dataset[Row] = {
    sparkSession
      .read
      .option("header", "true")
      .option("escape", "\"")
      .csv(csvPath)
  }

  def keepOnlyCategoryEducation(dataset: Dataset[Row]): Dataset[Row] = ???

  def getMostReviewedApp(dataset: Dataset[Row]): Row = ???
}
