package com.jacopocav.countdown
package model


import util.DaysOfWeek

import java.time.{DayOfWeek, LocalDateTime}

case class Config(targetDateTime: LocalDateTime,
                  includedWeekDays: Set[DayOfWeek] = DaysOfWeek.all,
                  timeInterval: TimeInterval = TimeInterval.wholeDay)
