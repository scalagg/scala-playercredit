package gg.scala.credit.player

import com.solexgames.datastore.commons.connection.impl.MongoConnection
import com.solexgames.datastore.commons.layer.impl.MongoStorageLayer
import gg.scala.credit.PlayerCredit
import org.bukkit.entity.Player
import java.util.*
import kotlin.properties.Delegates

/**
 * @author GrowlyX
 * @since 12/13/2021
 */
object CreditPlayerHandler
{
    var handle by Delegates.notNull<MongoStorageLayer<CreditPlayer>>()

    val players = mutableMapOf<UUID, CreditPlayer>()

    fun find(uniqueId: UUID) = players[uniqueId]
    fun find(player: Player) = players[player.uniqueId]

    fun find(username: String) = players
        .values.firstOrNull {
            it.username.equals(username, true)
        }

    fun initialLoad(
        connection: MongoConnection
    )
    {
        handle = MongoStorageLayer(
            connection, "Scala",
            "credit_players", CreditPlayer::class.java
        )

        PlayerCredit.PLATFORM.getLogger()
            .info("Setup data storage through MongoDB!")
    }
}
