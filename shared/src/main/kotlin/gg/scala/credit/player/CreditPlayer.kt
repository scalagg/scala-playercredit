package gg.scala.credit.player

import gg.scala.credit.player.audit.CreditPlayerAuditLog
import gg.scala.credit.player.status.PlayerStatus
import gg.scala.credit.player.status.PlayerStatus.Companion.getStatusWithinRange
import java.util.*
import java.util.concurrent.CompletableFuture

/**
 * @author GrowlyX
 * @since 12/13/2021
 */
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

    fun updateStatus()
    {
        status = getStatusWithinRange(credits)
    }

    fun save(): CompletableFuture<Void>
    {
        return CreditPlayerHandler.handle
            .saveEntry(uniqueId.toString(), this)
    }
}
