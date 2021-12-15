package gg.scala.credit.player.status

/**
 * @project scala-playercredit
 * @author Orf1 on 12/14/2021
 */
enum class PlayerStatus(

    // TODO: 12/14/2021 Convert this to a Component using kyori adventure's global platform
    val range: IntRange,
    val formatted: String
)
{
    NORMAL(1000..1999, "Normal"),
    IMMUNE(2000..2999, "Immune");

    companion object
    {
        @JvmStatic
        val VALUES = values()

        @JvmStatic
        fun getStatusWithinRange(credits: Int): PlayerStatus
        {
            return VALUES.firstOrNull {
                it.range.contains(credits)
            } ?: NORMAL
        }
    }
}
