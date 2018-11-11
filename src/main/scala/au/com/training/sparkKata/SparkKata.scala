package au.com.training.sparkKata

import org.apache.spark.sql.functions.{col, desc, lit, sum}
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}

object SparkKata {


  def loadDataset(sparkSession: SparkSession, csvPath: String): Dataset[Row] = {
    sparkSession
      .read
      .option("header", "true")
      .option("escape", "\"")
      .csv(csvPath)
  }

  def keepOnlyCategoryEducation(dataset: Dataset[Row]): Dataset[Row] = dataset
    .filter(col("Category") === "EDUCATION")

  def getMostReviewedApp(dataset: Dataset[Row]): Row = dataset
    .select(col("App"), col("Reviews").cast("int"))
    .sort(desc("Reviews"))
    .head()

  def exercise2(persons: DataFrame, addresses: DataFrame): DataFrame = {
    persons
      .filter(col("AGE").gt(32))
      .join(addresses, "ID")
  }
}
