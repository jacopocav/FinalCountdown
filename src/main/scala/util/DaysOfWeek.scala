package com.jacopocav.countdown
package util

import java.time.DayOfWeek
import java.time.DayOfWeek.{SATURDAY, SUNDAY}

object DaysOfWeek {
    /**
     * Every day (Mon-Sun)
     */
    val all: Set[DayOfWeek] = DayOfWeek.values.toSet
    /**
     * Working days (Mon-Fri)
     */
    val working: Set[DayOfWeek] = all - SATURDAY - SUNDAY
    /**
     * Working days (Mon-Sat)
     */
    val workingPlusSaturday: Set[DayOfWeek] = all - SUNDAY
}
