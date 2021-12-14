package gg.scala.credit.player.audit

/**
 * @author GrowlyX
 * @since 12/13/2021
 */
class CreditPlayerAuditEntry(
    val timestamp: Long,
    val reason: String,
    val difference: Int
)
