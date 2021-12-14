package gg.scala.credit

import gg.scala.credit.module.PlayerCreditModule
import java.util.logging.Logger

/**
 * @author GrowlyX
 * @since 12/13/2021
 */
interface PlayerCreditPlatform
{
    fun loadModules(): List<PlayerCreditModule>
    fun getLogger(): Logger

    fun initialLoad()
    {
        PlayerCredit.PLATFORM = this
    }
}
