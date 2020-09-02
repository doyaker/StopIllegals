package doyaker.stopillegals.checks;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class CheckIllegalNBT {
    public static void checkIllegalNBT(ItemStack item){
        if(item.getType() == Material.CHEST){
                if(item.getItemMeta().getLore() != null){
                    item.setAmount(0);
                }
            }
    }

    public static void checkIllegalNBTPlayer(Player p){
        for(ItemStack item : p.getInventory().getContents()){
            if(item != null){
                if(item.getType() == Material.CHEST){
                    if(item.getItemMeta().getLore() != null){
                        item.setAmount(0);
                    }
                }
            }
        }
    }
}
