package com.eyal;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * This file was created by Eyal B. alreaedy known as Keido on Intelli-J IDEA.
 * Any violation, attempt or try to leak, use or give this file without Eyal's
 * permission may result in a penalty of up to $1,000 USD.
 * <p>
 * File was created on 16/01/2017.
 * Copyright (c) 2017. Eyal B.
 */
public class ChatManager extends JavaPlugin {

    @Override
    public void onEnable() {
        super.onEnable();


    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("echatcmanager")) {
            if(args.length == 0 || args[0].equalsIgnoreCase("help")) {
                sender.sendMessage("§e§lECHATMANAGER COMMANDS:");
                sender.sendMessage("§6/ecm clearchat <player>");
                sender.sendMessage("§6/ecm watchchat [player]");
                sender.sendMessage("§6/ecm help");
                sender.sendMessage("§6More to come soon!");
                return true;
            }

            if(args.length == 1) {
                if(args[0].equalsIgnoreCase("clearchat")) {
                    if(args[1] != null) {
                        Player target = Bukkit.getPlayer(args[1]);
                        if(target == null) {
                            sender.sendMessage("§cIs he online?");
                            return true;
                        }
                        for(int x = 0; x < 360; x++) {
                            target.sendMessage("");
                        }
                        sender.sendMessage("§aSuccessfully cleared player's chat!");
                    } else {
                        for(Player online : Bukkit.getOnlinePlayers()) {
                            for(int x = 0; x < 360; x++) {
                                online.sendMessage("");
                            }
                            sender.sendMessage("§aSuccessfully cleared global chat!");
                        }
                    }
                }
            }
        }

        return false;
    }
}
