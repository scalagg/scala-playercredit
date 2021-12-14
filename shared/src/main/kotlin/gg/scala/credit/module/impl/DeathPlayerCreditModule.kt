package gg.scala.credit.module.impl

import com.cryptomorin.xseries.XMaterial
import gg.scala.credit.module.PlayerCreditModule

/**
 * @author GrowlyX
 * @since 12/14/2021
 */
object DeathPlayerCreditModule : PlayerCreditModule
{
    override fun getId() = "death"

    override fun getDescription() = listOf(
        "Tracks your deaths in-game!"
    )

    override fun getMaterial() = XMaterial.BLAZE_POWDER

    override fun initialLoad()
    {
        TODO("Not yet implemented")
    }
}
