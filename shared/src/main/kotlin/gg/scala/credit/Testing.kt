package gg.scala.credit

import gg.scala.credit.player.CreditPlayer
import java.util.*

/**
 * @project scala-playercredit
 * @author Orf1 on 12/14/2021
 */

fun main()
{
    val player = CreditPlayer("CONSOLE", UUID.randomUUID())
    player.credits = 2000
    player.updateStatus()

    println("Player Credit: ${player.credits}")
    println("Player Status: ${player.status}")

    player.credits = 1200
    player.updateStatus()

    println("Player Credit: ${player.credits}")
    println("Player Status: ${player.status}")
}