package gg.scala.credit.player

import gg.scala.credit.player.audit.CreditPlayerAuditLog
import gg.scala.credit.player.status.PlayerStatus
import java.util.*
import java.util.concurrent.CompletableFuture

/**
 * @author GrowlyX
 * @since 12/13/2021
 */

//TEMP METHOD FOR TESTING
fun main(args: Array<String>) {
    val player = CreditPlayer("", UUID.randomUUID())
    player.credits = 2000
    player.calculateStatusFromCredits()
    println(player.credits)
}

class CreditPlayer(
    var username: String,
    @Transient
    val uniqueId: UUID
)
{
    // TODO: 12/14/2021 make a default within the configuration
    var credits = 0
    var status = PlayerStatus.NORMAL

    val auditLog = CreditPlayerAuditLog()

    fun calculateStatusFromCredits()
    {
        var statusList = PlayerStatus.values();
        statusList = statusList.sortedArray()
        for (s in statusList) {
            if (credits >= s.minimum) {
                status = s
            }
        }
    }

    fun save(): CompletableFuture<Void>
    {
        return CreditPlayerHandler.handle
            .saveEntry(uniqueId.toString(), this)
    }
}
