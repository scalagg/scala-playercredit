package gg.scala.credit

import kotlin.properties.Delegates

/**
 * @author GrowlyX
 * @since 12/13/2021
 */
object PlayerCredit
{
    var PLATFORM by Delegates.notNull<PlayerCreditPlatform>()
}
