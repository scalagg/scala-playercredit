package gg.scala.credit

import gg.scala.credit.module.PlayerCreditModule
import gg.scala.credit.player.CreditPlayer
import gg.scala.credit.player.CreditPlayerHandler
import me.lucko.helper.Events
import me.lucko.helper.plugin.ExtendedJavaPlugin
import org.bukkit.ChatColor
import org.bukkit.event.player.AsyncPlayerPreLoginEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

/**
 * @author GrowlyX
 * @since 12/13/2021
 */
class PlayerCreditPlugin : ExtendedJavaPlugin(), PlayerCreditPlatform
{
    override fun enable()
    {
        Events.subscribe(AsyncPlayerPreLoginEvent::class.java).handler {
            CreditPlayerHandler.handle.fetchEntryByKey(it.uniqueId.toString()).thenAccept { fetched ->
                var player = fetched

                if (player == null)
                {
                    player = CreditPlayer(
                        it.name, it.uniqueId
                    )
                } else
                {
                    player.username = it.name
                }

                CreditPlayerHandler.players[it.uniqueId] = player
            }
        }

        Events.subscribe(PlayerJoinEvent::class.java).handler {
            val player = CreditPlayerHandler.find(it.player)

            if (player == null)
            {
                it.player.kickPlayer(
                    """
                    ${ChatColor.RED}I'm sorry, but we were unable to load your profile!
                    ${ChatColor.RED}This is an issue with ${ChatColor.BOLD}Player Credits${ChatColor.RED}!
                    """.trimIndent()
                )
                return@handler
            }
        }

        Events.subscribe(PlayerQuitEvent::class.java).handler {
            CreditPlayerHandler.players.remove(it.player.uniqueId)?.save()
        }
    }

    override fun loadModules(): List<PlayerCreditModule>
    {
        TODO("Load modules from a configuration file on the spigot platform")
    }
}
