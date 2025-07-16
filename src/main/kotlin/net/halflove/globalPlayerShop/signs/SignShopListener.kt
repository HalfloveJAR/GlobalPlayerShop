package net.halflove.globalPlayerShop.signs

import org.bukkit.block.Sign
import org.bukkit.block.sign.Side
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent

class SignShopListener: Listener {

    @EventHandler
    fun onPlayerSignClick(event: PlayerInteractEvent) {
        val player = event.player
        if (event.clickedBlock == null) return
        if (event.action != Action.RIGHT_CLICK_BLOCK) return
        if (event.clickedBlock!!.type.name.contains("Sign", true)) {
            val sign = event.clickedBlock!!.state as Sign
            val frontLines = sign.getSide(Side.FRONT).lines()
            val backLines = sign.getSide(Side.BACK).lines()
            player.sendMessage("Front lines: $frontLines")
            player.sendMessage("Back lines: $backLines")
        }
    }

}