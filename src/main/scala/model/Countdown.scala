package com.jacopocav.countdown
package model

import util.DaysOfWeek

import java.time.{LocalDate, LocalDateTime}
import java.time.temporal.ChronoUnit
import scala.math.Ordering.Implicits._

case class Countdown(config: Config) {
    def remainingTime: RemainingTime = RemainingTime {
        val now = LocalDateTime.now

        if (config.timeInterval == TimeInterval.wholeDay && config.includedWeekDays == DaysOfWeek.all) {
            // Faster computation in case of default parameters
            now.until(config.targetDateTime, ChronoUnit.SECONDS) max 0
        } else {
            LazyList.from(0)
                // Converts numbers to ascending LocalDates starting from today
                .map { now.plusDays(_).toLocalDate }
                // Makes the list finite by stopping at the target day
                .takeWhile { _ <= config.targetDateTime.toLocalDate }
                // Keeps only days of week included in the configuration
                .filter { config.includedWeekDays contains _.getDayOfWeek }
                // Transforms the LocalDate to the number of seconds that should be summed
                // to obtain the updated countdown
                .map { d: LocalDate =>
                    val beginDateTime = d.atTime(config.timeInterval.begin) max now
                    val endDateTime = d.atTime(config.timeInterval.end) min config.targetDateTime

                    // Returns zero if remaining time is negative
                    beginDateTime.until(endDateTime, ChronoUnit.SECONDS) max 0
                }
                .sum
        }
    }
}
