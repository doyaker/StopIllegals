package doyaker.stopillegals.commands;

import doyaker.stopillegals.Stopillegals;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

public class MainCommand implements Listener, CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Stopillegals plugin = Stopillegals.getPlugin(Stopillegals.class);
        if(label.equalsIgnoreCase("stopillegals")){
            if(args.length == 0){
                sender.sendMessage(ChatColor.RED+"Invalid argument. Use /stopillegals help to see a list of arguments.");
            }else{
                if(args[0].equalsIgnoreCase("reload")){
                    if(sender.hasPermission("stopillegals.reload")){
                        plugin.reloadConfig();
                        sender.sendMessage(ChatColor.GREEN+"Configuration has been reloaded.");
                    }else{
                        sender.sendMessage(ChatColor.RED+"You don't have permission.");
                    }

                }else if(args[0].equalsIgnoreCase("help")){
                    sender.sendMessage(ChatColor.GREEN+"/stopillegals - Main command for the plugin");
                    sender.sendMessage(ChatColor.GREEN+"/stopillegals reload - Reload the configuration");
                    sender.sendMessage(ChatColor.GREEN+"/stopillegals help - Show the help");
                    sender.sendMessage(ChatColor.GREEN+"/stopillegals version - Show the help");
                }else if(args[0].equalsIgnoreCase("version")){
                    sender.sendMessage(ChatColor.GREEN+"StopIllegals v1.0-SNAPSHOT by doyaker");
                } else{
                    sender.sendMessage("Invalid argument. Use /stopillegals help to see a list of arguments.");
                }
            }
            return true;
        }
        return false;
    }
}
