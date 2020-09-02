package doyaker.stopillegals.checks;

import doyaker.stopillegals.Stopillegals;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CheckIllegalStacks {

    public static void checkIllegalStacks(Player p){
        Stopillegals plugin = Stopillegals.getPlugin(Stopillegals.class);
        boolean disableIllegallyStackedItems = plugin.getConfig().getBoolean("IllegalItems.stacks.disableIllegallyStackedItems");
        boolean vanishIllegallyStackedItems = plugin.getConfig().getBoolean("IllegalItems.stacks.vanishIllegallyStackedItems");

        if(p.hasPermission("stopillegals.bypass")){
            return;
        }

        if(disableIllegallyStackedItems){
            for(ItemStack item : p.getInventory().getContents()){
                if(item != null){
                    if(item.getAmount()>item.getMaxStackSize()){
                        if(vanishIllegallyStackedItems){
                            item.setAmount(0);
                        }else{
                            item.setAmount(item.getMaxStackSize());
                        }
                        Bukkit.getLogger().info("[!] "+p.getName()+" has tried to use illegaly stacked items!");
                    }
                }
            }
        }
    }

    public static void checkIllegalStacksInventory(Inventory i){
        Stopillegals plugin = Stopillegals.getPlugin(Stopillegals.class);
        boolean disableIllegallyStackedItems = plugin.getConfig().getBoolean("IllegalItems.stacks.disableIllegallyStackedItems");
        boolean vanishIllegallyStackedItems = plugin.getConfig().getBoolean("IllegalItems.stacks.vanishIllegallyStackedItems");

        if(disableIllegallyStackedItems){
            for(ItemStack item : i.getContents()){
                if(item != null){
                    if(item.getAmount()>item.getMaxStackSize()){
                        if(vanishIllegallyStackedItems){
                            item.setAmount(0);
                        }else{
                            item.setAmount(item.getMaxStackSize());
                        }
                    }
                }
            }
        }
    }

    public static void checkIllegalStacksItem(ItemStack item){
        Stopillegals plugin = Stopillegals.getPlugin(Stopillegals.class);
        boolean disableIllegallyStackedItems = plugin.getConfig().getBoolean("IllegalItems.stacks.disableIllegallyStackedItems");
        boolean vanishIllegallyStackedItems = plugin.getConfig().getBoolean("IllegalItems.stacks.vanishIllegallyStackedItems");

        if(disableIllegallyStackedItems){
            if(item.getAmount()>item.getMaxStackSize()){
                if(vanishIllegallyStackedItems){
                    item.setAmount(0);
                }else{
                    item.setAmount(item.getMaxStackSize());
                }
            }
        }
    }
}
