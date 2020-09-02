package doyaker.stopillegals.checks;

import doyaker.stopillegals.Stopillegals;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CheckIllegalItems {

    public static void checkIllegalItems(Player p){
        Stopillegals plugin = Stopillegals.getPlugin(Stopillegals.class);
        boolean disableUnobtainableItems = plugin.getConfig().getBoolean("IllegalItems.items.disableUnobtainableItems");

        Set<Material> illegalItems = new HashSet<Material>();

        illegalItems.add(Material.BEDROCK);
        illegalItems.add(Material.BARRIER);
        illegalItems.add(Material.JIGSAW);
        illegalItems.add(Material.COMMAND_BLOCK);
        illegalItems.add(Material.COMMAND_BLOCK_MINECART);
        illegalItems.add(Material.STRUCTURE_BLOCK);
        illegalItems.add(Material.STRUCTURE_VOID);

        if(p.hasPermission("stopillegals.bypass")){
            return;
        }

        if(disableUnobtainableItems) {
            for(ItemStack item : p.getInventory().getContents()){
                if(item != null){
                    if(illegalItems.contains(item.getType())){
                        item.setAmount(0);
                    }
                }
            }
        }
    }

    public static void checkIllegalItemsInventory(Inventory i){
        Stopillegals plugin = Stopillegals.getPlugin(Stopillegals.class);
        boolean disableUnobtainableItems = plugin.getConfig().getBoolean("IllegalItems.items.disableUnobtainableItems");

        Set<Material> illegalItems = new HashSet<Material>();

        illegalItems.add(Material.BEDROCK);
        illegalItems.add(Material.BARRIER);
        illegalItems.add(Material.JIGSAW);
        illegalItems.add(Material.COMMAND_BLOCK);
        illegalItems.add(Material.COMMAND_BLOCK_MINECART);
        illegalItems.add(Material.STRUCTURE_BLOCK);
        illegalItems.add(Material.STRUCTURE_VOID);


        if(disableUnobtainableItems) {
            for(ItemStack item : i.getContents()){
                if(item != null){
                    if(illegalItems.contains(item.getType())){
                        item.setAmount(0);
                    }
                }
            }
        }
    }

    public static void checkIllegalItemStack(ItemStack item){
        Stopillegals plugin = Stopillegals.getPlugin(Stopillegals.class);
        boolean disableUnobtainableItems = plugin.getConfig().getBoolean("IllegalItems.items.disableUnobtainableItems");

        Set<Material> illegalItems = new HashSet<Material>();

        illegalItems.add(Material.BEDROCK);
        illegalItems.add(Material.BARRIER);
        illegalItems.add(Material.JIGSAW);
        illegalItems.add(Material.COMMAND_BLOCK);
        illegalItems.add(Material.COMMAND_BLOCK_MINECART);
        illegalItems.add(Material.STRUCTURE_BLOCK);
        illegalItems.add(Material.STRUCTURE_VOID);


        if(disableUnobtainableItems) {
                if(item != null){
                    if(illegalItems.contains(item.getType())){
                        item.setAmount(0);
                    }
                }
            }
    }

}
