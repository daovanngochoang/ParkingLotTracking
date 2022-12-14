package Utils

import java.time.{Duration, LocalDateTime}
import java.util.concurrent.TimeUnit

object TimeHandler {

  private var diff = 0


  def TimeDistanceInMillis (old_time: String, current_time: String): Long= {

    // remove the Z from the input format to get the right format
    val old_processed = old_time.replace("Z", "")
    val Old = LocalDateTime.parse(old_processed)
    val current_processed = current_time.replace("Z", "")
    val Now = LocalDateTime.parse(current_processed)

    // calculate time duration in milliseconds
    val timeDiff = Duration.between(Old, Now).toMillis


   timeDiff

  }


  def TimeDistanceString (old_time: String, current_time: String): String = {

    // calculate time duration in milliseconds
    val timeDiff = TimeDistanceInMillis(old_time, current_time)
    val diff_in_seconds = TimeUnit.MILLISECONDS.toSeconds(timeDiff)
    var result = ""

    // print out the time in seconds | minutes | hours | days
    if (diff_in_seconds <= 60) {
      result = s"${diff_in_seconds} seconds"

    } else if (diff_in_seconds < 60 * 60 && diff_in_seconds > 60) {
      result = s"${TimeUnit.MILLISECONDS.toMinutes(timeDiff)} minutes"

    } else if (diff_in_seconds > 60 * 60) {
      result = s"${TimeUnit.MILLISECONDS.toHours(timeDiff)} hours"
    } else {
      result = s"${TimeUnit.MILLISECONDS.toDays(timeDiff)} days"
    }
    result
  }
}
