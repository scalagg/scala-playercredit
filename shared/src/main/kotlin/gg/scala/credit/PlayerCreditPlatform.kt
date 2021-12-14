package gg.scala.credit

import com.solexgames.datastore.commons.connection.impl.mongo.UriMongoConnection
import gg.scala.credit.module.PlayerCreditModule
import gg.scala.credit.player.CreditPlayerHandler
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

        CreditPlayerHandler.initialLoad(
            UriMongoConnection("mongodb://127.0.0.1:27017")
        )
    }
}
