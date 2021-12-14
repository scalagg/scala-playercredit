package gg.scala.credit.player.status

/**
 * @project scala-playercredit
 * @author Orf1 on 12/14/2021
 */
enum class PlayerStatus(

    // TODO: 12/14/2021 Convert this to a Component using kyori adventure's global platform
    val minimum: Double,
    val formatted: String
)
{
    IMMUNE(2000.0, "Immune"),
    NORMAL(1000.0, "Normal")
}
