package cz.wake.manager.commads;

import cz.wake.manager.utils.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public class Profil_command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender Sender, Command Command, String String, String[] ArrayOfString) {
        if (Sender instanceof Player) {
            Player p = (Player) Sender;
            if ((Command.getName().equalsIgnoreCase("profil"))) {
                openMenu(p);
            }
        }
        return false;
    }

    public void openMenu(Player p) {

        Inventory menu = Bukkit.createInventory(null, 45, "Profil");

        SkullMeta headItemMeta = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
        headItemMeta.setOwner(p.getName());
        headItemMeta.setDisplayName("§cInformace o tobe");
        ItemStack headItem = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        ArrayList<String> headLore = new ArrayList<String>();
        headLore.add("§8Planovano...");
        headItemMeta.setLore(headLore);
        headItem.setItemMeta(headItemMeta);

        ItemStack statistics = ItemFactory.create(Material.BARRIER, (byte) 0, "§cStatistiky", "§8Planovano...");

        ItemStack achievements = ItemFactory.create(Material.BARRIER, (byte) 0, "§cAchievementy", "§8Planovano...");

        ItemStack nastaveni = ItemFactory.create(Material.REDSTONE_COMPARATOR, (byte) 0, "§aNastaveni uctu", "§7Diky nastaveni si muzes", "§7prispusobit lobby/hry podle sebe.", "", "§eKlikni pro zobrazeni/nastaveni");

        ItemStack multiplier = ItemFactory.create(Material.BARRIER, (byte) 0, "§cMultipliers", "§8Planovano...");

        ItemStack jazyk = ItemFactory.createHead("§aNastaveni jazyka", "0ceac85e-159d-4f9d-a1c2-c8acde792f23", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjFkZDRmZTRhNDI5YWJkNjY1ZGZkYjNlMjEzMjFkNmVmYTZhNmI1ZTdiOTU2ZGI5YzVkNTljOWVmYWIyNSJ9fX0=");
        ItemMeta bhMeta = jazyk.getItemMeta();
        ArrayList<String> bhLore = new ArrayList();
        bhLore.add("§7Zmen si jazyk serveru.");
        bhLore.add("");
        bhLore.add("§7Podporovane jazyky:");
        bhLore.add(" §7• §fCestina");
        bhLore.add(" §7• §fSlovencina");
        bhLore.add(" §7• §fEnglish");
        bhLore.add("");
        bhLore.add("§eKliknutim si zmenis jazyk!");
        bhMeta.setLore(bhLore);
        jazyk.setItemMeta(bhMeta);

        menu.setItem(13, headItem);
        menu.setItem(10, statistics);
        menu.setItem(16, achievements);
        menu.setItem(29, multiplier);
        menu.setItem(31, nastaveni);
        menu.setItem(33, jazyk);

        p.openInventory(menu);
    }

    public void openLanguageMenu(Player p) {

        Inventory inv = Bukkit.createInventory(null, 45, "Nastaveni jazyka");

        ItemStack jazyk = ItemFactory.createHead("§aCestina", "9db55454-6114-4bf8-aa27-55419d4890c4", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDgxNTJiNzMzNGQ3ZWNmMzM1ZTQ3YTRmMzVkZWZiZDJlYjY5NTdmYzdiZmU5NDIxMjY0MmQ2MmY0NmU2MWUifX19");
        ItemMeta bhMeta = jazyk.getItemMeta();
        ArrayList<String> bhLore = new ArrayList();
        bhLore.add("§7Zmen si jazyk serveru na Cestinu.");
        bhLore.add("");
        bhLore.add("§7Podpora prekladu:");
        bhLore.add(" §7• §fZatim nic");
        bhLore.add("");
        bhLore.add("§cNedostupne!");
        bhMeta.setLore(bhLore);
        jazyk.setItemMeta(bhMeta);

        ItemStack jazyk2 = ItemFactory.createHead("§aSlovencina", "", "");
        ItemMeta bhMeta2 = jazyk2.getItemMeta();
        ArrayList<String> bhLore2 = new ArrayList();
        bhLore2.add("§7Zmen si jazyk serveru na Slovencinu.");
        bhLore2.add("");
        bhLore2.add("§7Podpora prekladu:");
        bhLore2.add(" §7• §fZatim nic");
        bhLore2.add("");
        bhLore2.add("§cNedostupne!");
        bhMeta2.setLore(bhLore2);
        jazyk2.setItemMeta(bhMeta2);

        ItemStack jazyk3 = ItemFactory.createHead("§aEnglish", "3c30484a-76d3-4cfe-88e5-e7599bc9ac4d", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGNhYzk3NzRkYTEyMTcyNDg1MzJjZTE0N2Y3ODMxZjY3YTEyZmRjY2ExY2YwY2I0YjM4NDhkZTZiYzk0YjQifX19");
        ItemMeta bhMeta3 = jazyk3.getItemMeta();
        ArrayList<String> bhLore3 = new ArrayList();
        bhLore3.add("§7Change your language to English.");
        bhLore3.add("");
        bhLore3.add("§7Currently available:");
        bhLore3.add(" §7• §fNothing");
        bhLore3.add("");
        bhLore3.add("§cNot available!");
        bhMeta3.setLore(bhLore3);
        jazyk3.setItemMeta(bhMeta3);

        ItemStack zpet = ItemFactory.create(Material.ARROW, (byte) 0, "§eZpet");
        ItemStack help = ItemFactory.create(Material.BOOK, (byte) 0, "§aPomoc s prekladem", "§7Chces nam pomoct s prekladem?", "§7Neni nic jednodussiho nez si", "§7pozadat o pristup v nasem", "§7projektu na Crowdinu!", "", "§eKliknutim zobrazis odkaz na projekt");

        inv.setItem(11, jazyk);
        inv.setItem(13, jazyk2);
        inv.setItem(15, jazyk3);
        inv.setItem(40, zpet);
        inv.setItem(36, help);

        p.openInventory(inv);
    }

}
