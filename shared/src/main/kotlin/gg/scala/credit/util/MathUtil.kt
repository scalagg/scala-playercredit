package gg.scala.credit.util

import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.ln

/**
 * @author Orf1
 * @since 12/13/2021
 */
object MathUtil {
    
    @JvmStatic
    val FORMAT = DecimalFormat("#.##").also {
        it.roundingMode = RoundingMode.CEILING
    }
    
    @JvmStatic
    private fun calculateDecay(n: Double, max: Double, rate: Double): Double {
        return ln(n / max) / ln(1 - rate)
    }

    @JvmStatic
    fun calculateChange(currentCredit: Double, creditChange: Double): Double {
        val decayRate = 0.5
        val maxCredit = 2000.0
        val maxChange = 100.0

        var multiplier = calculateDecay(
            currentCredit, maxCredit, decayRate
        )

        if (multiplier > 2.0) {
            multiplier = 2.0
        }

        if (multiplier < 0.001) {
            multiplier = 0.0
        }

        var actual = creditChange * multiplier

        if (actual > maxChange) {
            actual = maxChange
        }

        if (actual < 0.001 || actual + currentCredit > maxCredit) {
            actual = 0.0
        }

        return FORMAT.format(actual).toDouble()
    }

    @JvmStatic
    fun calculateNew(current: Double, change: Double): Double {
        return current + calculateChange(current, change)
    }
}
