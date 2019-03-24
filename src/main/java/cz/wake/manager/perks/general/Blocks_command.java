package cz.wake.manager.perks.general;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Dye;

public class Blocks_command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender Sender, Command Command, String String, String[] ArrayOfString) {
        if (Sender instanceof Player) {
            Player player = (Player) Sender;
            if ((Command.getName().equalsIgnoreCase("blocks"))) {
                if (player.hasPermission("craftmanager.vip.blocks")) {
                    craftBlocks(player);
                } else {
                    player.sendMessage("§cK ziskani pristupu potrebujes mit aktivni VIP.");
                }

            }
        }
        return true;
    }

    public void craftBlocks(Player player) {
        try {
            int amountOfDiamonds = 0;
            int amountOfEmeralds = 0;
            int amountOfIron = 0;
            int amountOfGold = 0;
            int amountOfGlowstone = 0;
            int coal = 0;
            int redstone = 0;
            int lapis = 0;
            int itemsChanged = 0;
            for (ItemStack is : player.getInventory().getContents()) {
                if (is == null) continue;
                if (is.getType() == Material.DIAMOND) {
                    player.getInventory().remove(is);
                    amountOfDiamonds += is.getAmount();
                }
                if (is.getType() == Material.EMERALD) {
                    amountOfEmeralds += is.getAmount();
                    player.getInventory().remove(is);
                }
                if (is.getType() == Material.IRON_INGOT) {
                    player.getInventory().remove(is);
                    amountOfIron += is.getAmount();
                }
                if (is.getType() == Material.GLOWSTONE_DUST) {
                    amountOfGlowstone += is.getAmount();
                    player.getInventory().remove(is);
                }
                if (is.getType() == Material.GOLD_INGOT) {
                    player.getInventory().remove(is);
                    amountOfGold += is.getAmount();
                }
                if (is.getType() == Material.COAL) {
                    player.getInventory().remove(is);
                    coal += is.getAmount();
                }
                if (is.getType() == Material.REDSTONE) {
                    redstone += is.getAmount();
                    player.getInventory().remove(is);
                }
                if (is.getType() != Material.LEGACY_INK_SACK || ((Dye) is.getData()).getColor() != DyeColor.BLUE) continue;
                player.getInventory().remove(is);
                lapis += is.getAmount();
            }
            player.updateInventory();
            itemsChanged = amountOfDiamonds + amountOfEmeralds + amountOfGlowstone + amountOfGold + amountOfIron + coal + redstone + lapis;
            int diamondsToTransform = amountOfDiamonds / 9;
            int diamondOverflow = amountOfDiamonds % 9;
            int emeraldsToTransform = amountOfEmeralds / 9;
            int emeraldsOverflow = amountOfEmeralds % 9;
            int ironToTransform = amountOfIron / 9;
            int ironOverflow = amountOfIron % 9;
            int goldToTransform = amountOfGold / 9;
            int goldOverflow = amountOfGold % 9;
            int glowstoneToTransform = amountOfGlowstone / 9;
            int glowstoneOverflow = amountOfGlowstone % 9;
            int rT = redstone / 9;
            int rO = redstone % 9;
            int lT = lapis / 9;
            int lO = lapis % 9;
            int cT = coal / 9;
            int cO = coal % 9;
            player.getInventory().addItem(new ItemStack[]{new ItemStack(diamondsToTransform > 0 ? Material.DIAMOND_BLOCK : Material.AIR, diamondsToTransform), new ItemStack(emeraldsToTransform > 0 ? Material.EMERALD_BLOCK : Material.AIR, emeraldsToTransform), new ItemStack(diamondOverflow > 0 ? Material.DIAMOND : Material.AIR, diamondOverflow), new ItemStack(emeraldsOverflow > 0 ? Material.EMERALD : Material.AIR, emeraldsOverflow), new ItemStack(ironToTransform > 0 ? Material.IRON_BLOCK : Material.AIR, ironToTransform), new ItemStack(goldToTransform > 0 ? Material.GOLD_BLOCK : Material.AIR, goldToTransform), new ItemStack(glowstoneToTransform > 0 ? Material.GLOWSTONE : Material.AIR, glowstoneToTransform), new ItemStack(ironOverflow > 0 ? Material.IRON_INGOT : Material.AIR, ironOverflow), new ItemStack(goldOverflow > 0 ? Material.GOLD_INGOT : Material.AIR, goldOverflow), new ItemStack(glowstoneOverflow > 0 ? Material.GLOWSTONE_DUST : Material.AIR, glowstoneOverflow)});
            player.getInventory().addItem(new ItemStack[]{new ItemStack(rT > 0 ? Material.REDSTONE_BLOCK : Material.AIR, rT)});
            player.getInventory().addItem(new ItemStack[]{new ItemStack(lT > 0 ? Material.LAPIS_BLOCK : Material.AIR, lT)});
            player.getInventory().addItem(new ItemStack[]{new ItemStack(cT > 0 ? Material.COAL_BLOCK : Material.AIR, cT)});
            player.getInventory().addItem(new ItemStack[]{new ItemStack(rO > 0 ? Material.REDSTONE : Material.AIR, rO)});
            player.getInventory().addItem(new ItemStack[]{new ItemStack(lO > 0 ? Material.LEGACY_INK_SACK : Material.AIR, lO, (byte) 4)});
            player.getInventory().addItem(new ItemStack[]{new ItemStack(cO > 0 ? Material.COAL : Material.AIR, cO)});
            player.sendMessage("§ePremenil si §f" + String.valueOf(itemsChanged) + " itemu na §e" + (itemsChanged -= diamondOverflow + emeraldsOverflow + ironOverflow + goldOverflow + glowstoneOverflow + rO + cO + lO) / 9 + " blocku.");
            player.updateInventory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
