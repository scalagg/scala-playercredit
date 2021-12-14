package gg.scala.credit.module

import com.cryptomorin.xseries.XMaterial

/**
 * @author GrowlyX
 * @since 12/13/2021
 */
interface PlayerCreditModule
{
    fun getId(): String
    fun getDescription(): List<String>
    fun getMaterial(): XMaterial

    fun initialLoad()
}
