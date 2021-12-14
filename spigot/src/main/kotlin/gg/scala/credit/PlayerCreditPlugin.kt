package gg.scala.credit

import gg.scala.credit.module.PlayerCreditModule
import me.lucko.helper.plugin.ExtendedJavaPlugin

/**
 * @author GrowlyX
 * @since 12/13/2021
 */
class PlayerCreditPlugin : ExtendedJavaPlugin(), PlayerCreditPlatform
{
    override fun enable()
    {


    }

    override fun loadModules(): List<PlayerCreditModule>
    {
        TODO("Load modules from a configuration file on the spigot platform")
    }
}
