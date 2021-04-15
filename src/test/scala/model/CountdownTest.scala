package com.jacopocav.countdown
package model

import org.scalatest.flatspec.AnyFlatSpec

import java.time.LocalDateTime

class CountdownTest extends AnyFlatSpec {
    behavior of "A Countdown"

    it should "return 0 when now > target time" in {
        val time = LocalDateTime.now.minusDays(3)
        val cfg = Config(time)
        val cd = Countdown(cfg)

        assert(cd.remainingTime === RemainingTime(), "")
    }

    it should "return 0 when now = target time" in {
        val time = LocalDateTime.now
        val cfg = Config(time)
        val cd = Countdown(cfg)
        assert(cd.remainingTime === RemainingTime(), "")
    }

    it should "return >=59m59s when target = now + 1 hour" in {
        val time = LocalDateTime.now.plusHours(1)
        val cfg = Config(time)
        val cd = Countdown(cfg)

        assert(cd.remainingTime >= RemainingTime(minutes = 59, seconds = 59))
    }
}