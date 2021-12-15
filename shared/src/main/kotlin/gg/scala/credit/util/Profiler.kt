package gg.scala.credit.util

/**
 * @project scala-playercredit
 * @author Orf1 on 12/15/2021
 */
class Profiler {
    private var start = 0L
    private var stop = 0L

    fun start() {
        start = System.currentTimeMillis()
    }

    fun stop() {
        stop = System.currentTimeMillis()
    }

    fun getTime(): Long {
        return stop-start
    }
}