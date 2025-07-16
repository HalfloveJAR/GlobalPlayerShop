package net.halflove.globalPlayerShop.commands

import com.mojang.brigadier.tree.LiteralCommandNode
import io.papermc.paper.command.brigadier.CommandSourceStack
import io.papermc.paper.command.brigadier.Commands
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class MarketCommand {

    fun build(): LiteralCommandNode<CommandSourceStack> {
        return Commands.literal("market")

            .requires { ctx -> ctx.sender.hasPermission("gps.command.market") }
            .executes { ctx ->
                val executor = ctx.getSource().getExecutor()

                if (executor !is Player) return@executes 0
                if (!executor.hasPermission("gps.command.market")) {
                    noPerm(executor)
                    return@executes 1
                }

                executor.sendMessage("Market")
                1 // return a status code (usually 1 for success)
            }
            .build()
    }

    fun noPerm(sender: CommandSender) {
        sender.sendMessage("No permission.")
    }
}