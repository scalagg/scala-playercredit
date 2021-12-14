package gg.scala.credit.player

import gg.scala.credit.player.audit.CreditPlayerAuditLog
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
    
    val auditLog = CreditPlayerAuditLog()

    fun save(): CompletableFuture<Void>
    {
        return CreditPlayerHandler.handle
            .saveEntry(uniqueId.toString(), this)
    }
}
