package doyaker.stopillegals;

import doyaker.stopillegals.commands.MainCommand;
import doyaker.stopillegals.events.BlockBreakEventSI;
import doyaker.stopillegals.events.InventoryEventsSI;
import doyaker.stopillegals.events.PlayerJoinEventSI;
import doyaker.stopillegals.events.PlayerPlaceBlockEventSI;
import org.bukkit.plugin.java.JavaPlugin;

public final class Stopillegals extends JavaPlugin {

    @Override
    public void onEnable() {

        //Setup configuration
        getConfig().options().copyDefaults();
        saveDefaultConfig();


        //Register onJoinEvent
        getServer().getPluginManager().registerEvents(new PlayerJoinEventSI(), this);

        //Register onPlaceBlockEvent
        getServer().getPluginManager().registerEvents(new PlayerPlaceBlockEventSI(), this);

        //Register onBreakBlockEvent
        getServer().getPluginManager().registerEvents(new BlockBreakEventSI(), this);

        //Register InventoryEvents
        getServer().getPluginManager().registerEvents(new InventoryEventsSI(), this);

        //Register main command (/stopillegals one)
        getCommand("stopillegals").setExecutor(new MainCommand());
    }

    @Override
    public void onDisable() {

    }

}
