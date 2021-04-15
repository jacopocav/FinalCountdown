package com.jacopocav.countdown
package model

import java.time.LocalTime

case class TimeInterval(begin: LocalTime, end: LocalTime)

object TimeInterval {
    val wholeDay: TimeInterval = TimeInterval(LocalTime.MIN, LocalTime.MAX)
}

case class RemainingTime(days: Long = 0, hours: Int = 0, minutes: Int = 0, seconds: Int = 0)
    extends Ordered[RemainingTime] {

    override def toString: String = f"$daysString:$hoursString:$minutesString:$secondsString"

    def daysString: String = days.toString

    def hoursString: String = f"$hours%02d"

    def minutesString: String = f"$minutes%02d"

    def secondsString: String = f"$seconds%02d"

    override def compare(that: RemainingTime): Int =
        if (days != that.days) {
            days compare that.days
        } else if (hours != that.hours) {
            hours compare that.hours
        } else if (minutes != that.minutes) {
            minutes compare that.minutes
        } else if (seconds != that.seconds) {
            seconds compare that.seconds
        } else {
            0
        }
}

object RemainingTime {
    def apply(totalSeconds: Long): RemainingTime = {
        val seconds = totalSeconds % 60
        val minutes = (totalSeconds / 60) % 60
        val hours = (totalSeconds / 3600) % 24
        val days = totalSeconds / (3600 * 24)

        RemainingTime(days, hours.toInt, minutes.toInt, seconds.toInt)
    }
}