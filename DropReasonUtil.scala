import org.apache.spark.sql.Column
import org.apache.spark.sql.functions._

object DropReasonUtil {

  private def getDropReason(dropReasonCode: Column): Column = {
    when(dropReasonCode === "1", "Lane with Missing Constraint")
      .when(dropReasonCode === "2", "Duplicate Lanes")
      .otherwise("Unknown drop reason")
  }

  def getReason(dropReasonCode: Column): Column = {
    getDropReason(dropReasonCode)
  }
}
