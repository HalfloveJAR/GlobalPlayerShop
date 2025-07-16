package net.halflove.globalPlayerShop

import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents
import net.halflove.globalPlayerShop.commands.MarketCommand
import net.halflove.globalPlayerShop.signs.SignShopListener
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {

    override fun onEnable() {
        registerCommands()
        registerEvents()
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    private fun registerCommands() {
        lifecycleManager.registerEventHandler(LifecycleEvents.COMMANDS) { commands ->
            commands.registrar().register(
                MarketCommand().build(),
                "Open the global player shop market menu.",
                listOf("playershops")
            );
        }
    }

    private fun registerEvents() {
        Bukkit.getPluginManager().registerEvents(SignShopListener(), this)
    }
}
