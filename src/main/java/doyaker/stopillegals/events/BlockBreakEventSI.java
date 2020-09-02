package doyaker.stopillegals.events;

import doyaker.stopillegals.checks.CheckIllegalEnchants;
import doyaker.stopillegals.checks.CheckIllegalItems;
import doyaker.stopillegals.checks.CheckIllegalStacks;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakEventSI implements Listener {

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent e){
        CheckIllegalStacks.checkIllegalStacks(e.getPlayer());
        CheckIllegalEnchants.checkIllegalEnchants(e.getPlayer());
        CheckIllegalItems.checkIllegalItems(e.getPlayer());
    }

}
