package gg.scala.credit

import gg.scala.credit.player.CreditPlayer
import gg.scala.credit.util.Profiler
import java.util.*

/**
 * @project scala-playercredit
 * @author Orf1 on 12/14/2021
 */

fun main()
{
    Thread {
        val profiler = Profiler()
        val player = CreditPlayer("CONSOLE", UUID.fromString(""))

        profiler.start()
        player.credits = 2000
        player.updateStatus()
        profiler.stop()

        println("Player Credit: ${player.credits}")
        println("Player Status: ${player.status}")
        println("Took: ${profiler.getTime()} ms.")

        profiler.start()
        player.credits = 1200
        player.updateStatus()
        profiler.stop()

        println("Player Credit: ${player.credits}")
        println("Player Status: ${player.status}")
        println("Took: ${profiler.getTime()} ms.")
    }.start()
}