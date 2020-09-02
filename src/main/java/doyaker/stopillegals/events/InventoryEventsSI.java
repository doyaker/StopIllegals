package doyaker.stopillegals.events;

import doyaker.stopillegals.checks.CheckIllegalEnchants;
import doyaker.stopillegals.checks.CheckIllegalItems;
import doyaker.stopillegals.checks.CheckIllegalStacks;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.Inventory;

public class InventoryEventsSI implements Listener {

    @EventHandler
    public void onItemHopper(InventoryMoveItemEvent e){
        if(e.getSource().getType() == InventoryType.SHULKER_BOX && e.getDestination().getType() == InventoryType.HOPPER){
            CheckIllegalStacks.checkIllegalStacksItem(e.getItem());
            CheckIllegalEnchants.checkIllegalEnchantsItem(e.getItem());
            CheckIllegalItems.checkIllegalItemStack(e.getItem());
        }
    }

    @EventHandler
    public void onInventoryEvent(InventoryEvent e){
        CheckIllegalStacks.checkIllegalStacksInventory(e.getInventory());
        CheckIllegalEnchants.checkIllegalEnchantsInventory(e.getInventory());
        CheckIllegalItems.checkIllegalItemsInventory(e.getInventory());
    }

    @EventHandler
    public void onInventoryOpenEvent(InventoryOpenEvent e){
        CheckIllegalStacks.checkIllegalStacksInventory(e.getInventory());
        CheckIllegalEnchants.checkIllegalEnchantsInventory(e.getInventory());
        CheckIllegalItems.checkIllegalItemsInventory(e.getInventory());
        CheckIllegalStacks.checkIllegalStacks((Player) e.getPlayer());
        CheckIllegalEnchants.checkIllegalEnchants((Player) e.getPlayer());
        CheckIllegalItems.checkIllegalItems((Player) e.getPlayer());
    }

    @EventHandler
    public void onInventoryCloseEvent(InventoryCloseEvent e) {
        CheckIllegalStacks.checkIllegalStacksInventory(e.getInventory());
        CheckIllegalEnchants.checkIllegalEnchantsInventory(e.getInventory());
        CheckIllegalItems.checkIllegalItemsInventory(e.getInventory());
        CheckIllegalStacks.checkIllegalStacks((Player) e.getPlayer());
        CheckIllegalEnchants.checkIllegalEnchants((Player) e.getPlayer());
        CheckIllegalItems.checkIllegalItems((Player) e.getPlayer());
    }
}
