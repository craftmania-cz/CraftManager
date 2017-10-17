package cz.wake.manager.shop;

import cz.wake.manager.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashSet;
import java.util.Random;

public class TagsEditor implements Listener {

    private static HashSet<Player> list = new HashSet<Player>();

    public static void createTagEditor(final Player p){

        //odeslani do chatu info
        //hrac napise pozadovany tag
        //server schvali
        //pokud je vse OK, odebere token a vytvori tag
        //odebere hrace z listu
        //zrusi se editor

        list.add(p);
        p.closeInventory();
        p.sendMessage("");
        p.sendMessage("§e§lEditor pro vytvareni vlastnich tagu");
        p.sendMessage("§7Nyni napis do chatu, jaky tag chces vytvorit.");
        p.sendMessage("");
        p.sendMessage("§fMaximalni delka tagu je 8 znaku. Cena za tag je 1 CraftToken!");
        p.sendMessage("");
        p.sendMessage("§cPokud chces kdykoliv opustit editor napis -> exit");
        p.sendMessage("");
        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BASS, 1.0f, 1.0f);

    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGH)
    public void onChat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        String m = e.getMessage();

        if(list.contains(p)){
            e.setCancelled(true);
            if(m.equalsIgnoreCase("exit")){
                list.remove(p);
                p.sendMessage("");
                p.sendMessage("§eVytvareni tagu bylo zruseno, nyni muzes normalne psat!");
                p.sendMessage("");
            } else {
                if(m.length() > 8){
                    p.sendMessage("");
                    p.sendMessage("§cTag nemuze byt delsi nez 10 znaku!");
                    p.sendMessage("");
                }
                if(m.contains(" ")){
                    p.sendMessage("");
                    p.sendMessage("§cNelze vytvorit tag, ktery obsahuje mezeru!");
                    p.sendMessage("");
                }
                if(Main.getInstance().blockedTags.toString().matches(m)){
                    p.sendMessage("");
                    p.sendMessage("§cNelze vytvorit tag s sprostym nazvem!");
                    p.sendMessage("");
                }
                Main.getInstance().getMySQL().takeTokens(p, 1);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tags create " + m + " " + m + " &8▏");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getPlayer() + " permission set deluxetags.tag." + m + " true");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tags reload");
                p.sendMessage("");
                p.sendMessage("§aTvuj tag §f" + m + " §abyl uspesne vytvoren! Nyni si ho aktivuj v §e/tags");
                p.sendMessage("");
                list.remove(p);
            }
        }
    }
}
