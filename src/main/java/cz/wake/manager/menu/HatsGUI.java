package cz.wake.manager.menu;

import cz.craftmania.craftcore.spigot.builders.items.ItemBuilder;
import cz.craftmania.craftcore.spigot.inventory.builder.ClickableItem;
import cz.craftmania.craftcore.spigot.inventory.builder.SmartInventory;
import cz.craftmania.craftcore.spigot.inventory.builder.content.InventoryContents;
import cz.craftmania.craftcore.spigot.inventory.builder.content.InventoryProvider;
import cz.craftmania.craftcore.spigot.inventory.builder.content.Pagination;
import cz.craftmania.craftcore.spigot.inventory.builder.content.SlotIterator;
import cz.craftmania.craftpack.api.Hats;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class HatsGUI implements InventoryProvider {

    public List<CosmeticItem> prepareList() {
        List<CosmeticItem> list = new ArrayList<>();

        // Admin team Hats
        list.add(new CosmeticItem().setName("§eOwner Crown")
                .setItemStack(Hats.AT_OWNER.getPureItemStack())
                .setLore("§7Speciální Admin Team čepice.", "", "§aZískáno: §fČlen AT - Owner", "", "§eKlikni pro nasazení")
                .setRequiredPermission("craftmanager.hats.at_owner"));

        list.add(new CosmeticItem().setName("§eStaff Crown")
                .setItemStack(Hats.AT_STAFF.getPureItemStack())
                .setLore("§7Speciální Admin Team čepice.", "", "§aZískáno: §fČlen AT - Staff", "", "§eKlikni pro nasazení")
                .setRequiredPermission("craftmanager.hats.at_staff"));

        list.add(new CosmeticItem().setName("§eEventer Crown")
                .setItemStack(Hats.AT_EVENTER.getPureItemStack())
                .setLore("§7Speciální Admin Team čepice.", "", "§aZískáno: §fČlen AT - Eventer", "", "§eKlikni pro nasazení")
                .setRequiredPermission("craftmanager.hats.at_eventer"));

        list.add(new CosmeticItem().setName("§eDeveloper Crown")
                .setItemStack(Hats.AT_DEVELOPER.getPureItemStack())
                .setLore("§7Speciální Admin Team čepice.", "", "§aZískáno: §fČlen AT - Developer", "", "§eKlikni pro nasazení")
                .setRequiredPermission("craftmanager.hats.at_developer"));

        list.add(new CosmeticItem().setName("§eBuilder Crown")
                .setItemStack(Hats.AT_BUILDER.getPureItemStack())
                .setLore("§7Speciální Admin Team čepice.", "", "§aZískáno: §fČlen AT - Builder", "", "§eKlikni pro nasazení")
                .setRequiredPermission("craftmanager.hats.at_builder"));

        list.add(new CosmeticItem().setName("§eArtist Crown")
                .setItemStack(Hats.AT_ARTIST.getPureItemStack())
                .setLore("§7Speciální Admin Team čepice.", "", "§aZískáno: §fČlen AT - Artist", "", "§eKlikni pro nasazení")
                .setRequiredPermission("craftmanager.hats.at_artist"));

        list.add(new CosmeticItem().setName("§eAdmin Crown")
                .setItemStack(Hats.AT_ADMIN.getPureItemStack())
                .setLore("§7Speciální Admin Team čepice.", "", "§aZískáno: §fČlen AT - Admin", "", "§eKlikni pro nasazení")
                .setRequiredPermission("craftmanager.hats.at_admin"));

        list.add(new CosmeticItem().setName("§eHelper Crown")
                .setItemStack(Hats.AT_HELPER.getPureItemStack())
                .setLore("§7Speciální Admin Team čepice.", "", "§aZískáno: §fČlen AT - Helper", "", "§eKlikni pro nasazení")
                .setRequiredPermission("craftmanager.hats.at_helper"));

        list.add(new CosmeticItem().setName("§cBanHammer")
                .setItemStack(Hats.AT_BANHAMMER.getPureItemStack())
                .setLore("§7Speciální Admin Team čepice.", "", "§aZískáno: §fČlen AT", "", "§eKlikni pro nasazení")
                .setRequiredPermission("craftmanager.hats.at_banhammer"));

        // Coinshop Hats
        list.add(new CosmeticItem().setName("§fKoala")
                .setItemStack(Hats.KOALA.getPureItemStack())
                .setLore("§7Čepice v designu Koaly z babusových lesů!", "", "§aZískáno: §f/cshop", "", "§eKlikni pro nasazení")
                .setRequiredPermission("craftmanager.hats.koala"));

        list.add(new CosmeticItem().setName("§fPanda")
                .setItemStack(Hats.PANDA.getPureItemStack())
                .setLore("§7Čepice v designu Pandy", "§7už chybí jen ten bambus?!", "", "§aZískáno: §f/cshop", "", "§eKlikni pro nasazení")
                .setRequiredPermission("craftmanager.hats.panda"));

        list.add(new CosmeticItem().setName("§6Koňská hlava")
                .setItemStack(Hats.HORSE.getPureItemStack())
                .setLore("§7Čepice ve velikosti pravé koňské hlavy", "§7počkej až někoho třískneš kopítkem!", "", "§aZískáno: §fExtra připojení v Leden 2021", "", "§eKlikni pro nasazení")
                .setRequiredPermission("craftmanager.hats.horse"));

        list.add(new CosmeticItem().setName("§dKlaun")
                .setItemStack(Hats.CLOWN.getPureItemStack())
                .setLore("§7Čepice ve stylu vrchního", "§7šaška serveru přímo pro tebe!", "", "§aZískáno: §f/cshop", "", "§eKlikni pro nasazení")
                .setRequiredPermission("craftmanager.hats.clown"));

        list.add(new CosmeticItem().setName("§bLast Breath")
                .setItemStack(Hats.LAST_BREATH.getPureItemStack())
                .setLore("§7Speciální čepice, která ti připomene", "§7jak křehký je čas a sklo...", "", "§aZískáno: §fDokončení mapy od Command Builders (Limited)", "", "§eKlikni pro nasazení")
                .setRequiredPermission("craftmanager.hats.last_breath"));

        list.add(new CosmeticItem().setName("§fUnicorn")
                .setItemStack(Hats.UNICORN.getPureItemStack())
                .setLore("§7Čepice ve tvaru rohu jednorožce!", "", "§aZískáno: §f/cshop", "", "§eKlikni pro nasazení")
                .setRequiredPermission("craftmanager.hats.unicorn"));

        list.add(new CosmeticItem().setName("§bBeer Hat")
                .setItemStack(Hats.BEER_HAT.getPureItemStack())
                .setLore("§7Žízeň? Tak s touto čepicí nikdy!", "", "§aZískáno: §f/cshop", "", "§eKlikni pro nasazení")
                .setRequiredPermission("craftmanager.hats.beer_hat"));

        list.add(new CosmeticItem().setName("§6Trex")
                .setItemStack(Hats.TREX.getPureItemStack())
                .setLore("§7Velká tlama, velký zuby a všichni utekli!", "", "§aZískáno: §f/cshop", "", "§eKlikni pro nasazení")
                .setRequiredPermission("craftmanager.hats.trex"));

        list.add(new CosmeticItem().setName("§eXXXTentacion")
                .setItemStack(Hats.XXXTENCATION.getPureItemStack())
                .setLore("§7Pořádný vlasy, a rap co ti zvedne tep.", "", "§aZískáno: §f/cshop", "", "§eKlikni pro nasazení")
                .setRequiredPermission("craftmanager.hats.xxxtencation")); // Old název, bug wake je boomer a posral název no

        list.add(new CosmeticItem().setName("§6Bunny Ears")
                .setItemStack(Hats.BUNNY_EARS.getPureItemStack())
                .setLore("§7Velké uši, velký čumák..", "", "§aZískáno: §f/cshop", "", "§eKlikni pro nasazení")
                .setRequiredPermission("craftmanager.hats.bunny_ears"));
        
        list.add(new CosmeticItem().setName("§aŽabička")
                .setItemStack(Hats.ZABICKA.getPureItemStack())
                .setLore("§7Žabičky ze všech bažin jsou zde!", "", "§aZískáno: §f/cshop", "", "§eKlikni pro nasazení")
                .setRequiredPermission("craftmanager.hats.zabicka"));

        list.add(new CosmeticItem().setName("§eKachnička")
                .setItemStack(Hats.KACHNICKA.getPureItemStack())
                .setLore("§7Kachničky od řeky přímo na hlavu.", "", "§aZískáno: §f/cshop", "", "§eKlikni pro nasazení")
                .setRequiredPermission("craftmanager.hats.kachnicka"));

        return list;
    }

    @Override
    public void init(Player player, InventoryContents contents) {
        List<CosmeticItem> disguises = prepareList();

        contents.fillRow(0, ClickableItem.of(new ItemBuilder(Material.LIGHT_BLUE_STAINED_GLASS_PANE).setName("§c").build(), item -> {}));
        contents.fillRow(5, ClickableItem.of(new ItemBuilder(Material.LIGHT_BLUE_STAINED_GLASS_PANE).setName("§c").build(), item -> {}));

        final Pagination pagination = contents.pagination();
        final ArrayList<ClickableItem> items = new ArrayList<>();

        disguises.forEach((cosmeticItem -> {

            if (!player.hasPermission(cosmeticItem.getRequiredPermission())) {
                return;
            }

            items.add(ClickableItem.of(new ItemBuilder(cosmeticItem.getItemStack()).setName(cosmeticItem.getName()).setLore(cosmeticItem.getLore()).hideAllFlags().build(), item -> {
                if (player.getInventory().getHelmet() != null && !player.getInventory().getHelmet().getItemMeta().hasCustomModelData()) {
                    player.sendMessage("§c§l[!] §cNelze si nasadit čepici, když máš již něco na hlavě!");
                    return;
                }
                ItemBuilder finalItem = new ItemBuilder(cosmeticItem.getItemStack());
                finalItem.hideAllFlags();
                finalItem.setLore("§7Nasazeno: §f" + player.getName());
                player.getInventory().setHelmet(finalItem.build());
                player.sendMessage("§e§l[*] §eNasadil jsi si na hlavu: §r" + cosmeticItem.getName());
                player.closeInventory();
            }));

        }));

        ClickableItem[] c = new ClickableItem[items.size()];
        c = items.toArray(c);
        pagination.setItems(c);
        pagination.setItemsPerPage(36);

        if (items.size() > 0 && !pagination.isLast()) {
            contents.set(5, 7, ClickableItem.of(new ItemBuilder(Material.PAPER).setName("§f§lDalší stránka").build(), e -> {
                contents.inventory().open(player, pagination.next().getPage());
            }));
        }
        if (!pagination.isFirst()) {
            contents.set(5, 2, ClickableItem.of(new ItemBuilder(Material.PAPER).setName("§f§lPředchozí stránka").build(), e -> {
                contents.inventory().open(player, pagination.previous().getPage());
            }));
        }

        contents.set(5, 1,ClickableItem.of(new ItemBuilder(Material.SPECTRAL_ARROW).setName("§eZpět do menu").hideAllFlags().build(), item -> {
            SmartInventory.builder().size(6, 9).title("Cosmetics Menu").provider(new CosmeticMainGUI()).build().open(player);
        }));

        contents.set(5, 4, ClickableItem.of(new ItemBuilder(Material.BARRIER).setName("§cDeaktivovat").build(), e -> {
            if (player.getInventory().getHelmet() != null && !player.getInventory().getHelmet().getItemMeta().hasCustomModelData()) {
                player.sendMessage("§c§l[!] §cSundat si lze čepice pouze z Cosmetic menu.");
                return;
            }
            player.getInventory().setHelmet(null);
            player.getOpenInventory().close();
            player.sendMessage("§e§l[*] §eSundal jsi si čepici z hlavy.");
        }));

        SlotIterator slotIterator = contents.newIterator("hats-gui", SlotIterator.Type.HORIZONTAL, 1, 0);
        slotIterator = slotIterator.allowOverride(false);
        pagination.addToIterator(slotIterator);

    }

    @Override
    public void update(Player player, InventoryContents contents) {

    }
}
