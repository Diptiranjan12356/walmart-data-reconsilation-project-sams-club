import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object DropReasonTest {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder()
      .appName("DropReasonTest")
      .master("local[*]")
      .getOrCreate()

    val data = Seq(
      "1",
      "2",
      "3",
      "999",
      null
    ).toDF("dropReasonCode")

    val result = data.withColumn(
      "dropReason",
      DropReasonUtil.getReason(col("dropReasonCode"))
    )

    result.show(false)

    spark.stop()
  }
}
