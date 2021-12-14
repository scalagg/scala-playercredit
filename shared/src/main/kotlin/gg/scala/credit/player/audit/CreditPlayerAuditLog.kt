package gg.scala.credit.player.audit

/**
 * @author GrowlyX
 * @since 12/13/2021
 */
class CreditPlayerAuditLog
{
    val auditEntries = mutableListOf<CreditPlayerAuditEntry>()

    fun commitEntry(
        entry: CreditPlayerAuditEntry
    )
    {
        auditEntries.add(entry)
    }

    fun sortByTimestamp() = auditEntries
        .sortByDescending { it.timestamp }
}
