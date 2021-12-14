package gg.scala.credit.player

import gg.scala.credit.player.audit.CreditPlayerAuditEntry
import gg.scala.credit.player.audit.CreditPlayerAuditLog
import java.util.*

/**
 * @author GrowlyX
 * @since 12/13/2021
 */
class CreditPlayer(
    val username: String,
    @Transient
    val uniqueId: UUID
)
{
    val auditLog = CreditPlayerAuditLog()
}
