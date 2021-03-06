package doyaker.stopillegals.events;

import doyaker.stopillegals.Stopillegals;
import doyaker.stopillegals.checks.CheckIllegalEnchants;
import doyaker.stopillegals.checks.CheckIllegalItems;
import doyaker.stopillegals.checks.CheckIllegalNBT;
import doyaker.stopillegals.checks.CheckIllegalStacks;
import doyaker.stopillegals.logger.LoggerSI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlayerPlaceBlockEventSI implements Listener {

    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent e){
        Stopillegals plugin = Stopillegals.getPlugin(Stopillegals.class);
        boolean disableUnobtainableItems = plugin.getConfig().getBoolean("IllegalItems.items.disableUnobtainableItems");
        CheckIllegalStacks.checkIllegalStacks(e.getPlayer());
        CheckIllegalEnchants.checkIllegalEnchants(e.getPlayer());
        CheckIllegalItems.checkIllegalItems(e.getPlayer());
        CheckIllegalNBT.checkIllegalNBTPlayer(e.getPlayer());
        if(disableUnobtainableItems){
            if(e.getBlockPlaced().getType() == Material.BEDROCK || e.getBlockPlaced().getType() == Material.BARRIER){
                e.setCancelled(true);
                LoggerSI.logToConsole(e.getPlayer(), "X:"+e.getPlayer().getLocation().getX()+" Y:"+e.getPlayer().getLocation().getY()+" Z:"+e.getPlayer().getLocation().getZ());
            }
        }
    }
}
