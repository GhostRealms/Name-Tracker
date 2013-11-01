package com.rmarmorstein;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class UUIDexe implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length != 1) {
			return false;
		} else {
			Converter convert = new Converter(args[0]);
			convert.run();
			sender.sendMessage(ChatColor.GRAY + "[UUID] " + ChatColor.GREEN + args[0] + "'s" + ChatColor.WHITE + " UUID is " + ChatColor.GREEN + convert.getUUID());
		}
		return true;
	}

}
