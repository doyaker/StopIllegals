package doyaker.stopillegals.checks;

import doyaker.stopillegals.Stopillegals;
import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class CheckIllegalEnchants {


    public static void checkIllegalEnchants(Player p){
        Stopillegals plugin = Stopillegals.getPlugin(Stopillegals.class);

        boolean disableIllegalEnchants = plugin.getConfig().getBoolean("IllegalItems.enchants.disableIllegallyEnchantedItems");
        boolean vanishIllegalEnchants = plugin.getConfig().getBoolean("IllegalItems.enchants.vanishIllegallyEnchantedItems");

        if(p.hasPermission("stopillegals.bypass")){
            return;
        }

        if(disableIllegalEnchants) {
            for (ItemStack item : p.getInventory()) {
                if(item != null){
                    Map<Enchantment, Integer> enchants = item.getEnchantments();
                    for (Enchantment e : enchants.keySet()) {
                        if (e.getMaxLevel() < enchants.get(e)) {
                            if(vanishIllegalEnchants){
                                item.setAmount(0);
                            }else{
                                item.removeEnchantment(e);
                                if(e.canEnchantItem(item)){
                                    item.addEnchantment(e, e.getMaxLevel());
                                }
                            }
                            Bukkit.getLogger().info("[!] "+p.getName()+" has tried to use illegaly enchanted items!");
                        }
                    }
                }
            }
        }
    }

    public static void checkIllegalEnchantsInventory(Inventory i){
        Stopillegals plugin = Stopillegals.getPlugin(Stopillegals.class);

        boolean disableIllegalEnchants = plugin.getConfig().getBoolean("IllegalItems.enchants.disableIllegallyEnchantedItems");
        boolean vanishIllegalEnchants = plugin.getConfig().getBoolean("IllegalItems.enchants.vanishIllegallyEnchantedItems");

        if(disableIllegalEnchants) {
            for (ItemStack item : i) {
                if(item != null){
                    Map<Enchantment, Integer> enchants = item.getEnchantments();
                    for (Enchantment e : enchants.keySet()) {
                        if (e.getMaxLevel() < enchants.get(e)) {
                            if(vanishIllegalEnchants){
                                item.setAmount(0);
                            }else{
                                item.removeEnchantment(e);
                                if(e.canEnchantItem(item)){
                                    item.addEnchantment(e, e.getMaxLevel());
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void checkIllegalEnchantsItem(ItemStack item){
        Stopillegals plugin = Stopillegals.getPlugin(Stopillegals.class);

        boolean disableIllegalEnchants = plugin.getConfig().getBoolean("IllegalItems.enchants.disableIllegallyEnchantedItems");
        boolean vanishIllegalEnchants = plugin.getConfig().getBoolean("IllegalItems.enchants.vanishIllegallyEnchantedItems");

        if(disableIllegalEnchants){
            Map<Enchantment, Integer> enchants = item.getEnchantments();
            for (Enchantment e : enchants.keySet()) {
                if (e.getMaxLevel() < enchants.get(e)) {
                    if(vanishIllegalEnchants){
                        item.setAmount(0);
                    }else{
                        item.removeEnchantment(e);
                        if(e.canEnchantItem(item)){
                            item.addEnchantment(e, e.getMaxLevel());
                        }
                    }
                }
            }
        }
    }

}
