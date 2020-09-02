package doyaker.stopillegals.events;

import doyaker.stopillegals.Stopillegals;
import doyaker.stopillegals.checks.CheckIllegalEnchants;
import doyaker.stopillegals.checks.CheckIllegalNBT;
import doyaker.stopillegals.checks.CheckIllegalStacks;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinEventSI implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        CheckIllegalStacks.checkIllegalStacks(e.getPlayer());
        CheckIllegalEnchants.checkIllegalEnchants(e.getPlayer());
        CheckIllegalNBT.checkIllegalNBTPlayer(e.getPlayer());
    }
}
