package gg.scala.credit.module

import gg.scala.credit.PlayerCredit

/**
 * @author GrowlyX
 * @since 12/13/2021
 */
object PlayerCreditModuleHandler
{
    val modules = mutableListOf<PlayerCreditModule>()

    /**
     * [modules] will be loaded through the specific
     * platform's configuration solution.
     */
    fun initialLoad(
        modules: List<PlayerCreditModule>
    )
    {
        this.modules.addAll(modules)
        this.modules.forEach { it.initialLoad() }

        PlayerCredit.PLATFORM.getLogger()
            .info("Modules have been loaded!")
    }
}
