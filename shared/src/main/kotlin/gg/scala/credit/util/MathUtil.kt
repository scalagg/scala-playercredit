package gg.scala.credit.util

import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.ln

object MathUtil {
    @JvmStatic
    fun calculateChange(currentCredit: Double, creditChange: Double):Double {
        val decayRate = 0.5 //Default = 0.5
        val maxCredit = 2000.0 //Default = 2000.0
        val maxChange = 100.0 //Default = 100.0
        val format = DecimalFormat("#.##")

        format.roundingMode = RoundingMode.CEILING

        var multiplier = (ln(currentCredit/maxCredit))/(ln(1-decayRate))

        if (multiplier > 2.0) {
            multiplier = 2.0
        }

        if (multiplier < 0.001) {
            multiplier = 0.0
        }

        var actual = creditChange*multiplier

        if (actual > maxChange) {
            actual = maxChange
        }

        if (actual < 0.001 || actual+currentCredit > maxCredit) {
            actual = 0.0
        }

        return format.format(actual).toDouble()
    }
    @JvmStatic
    fun calculateNew(current: Double, change: Double):Double {
        return current + calculateChange(current, change)
    }
}