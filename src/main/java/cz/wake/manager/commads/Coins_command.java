package cz.wake.manager.commads;

import cz.wake.manager.Main;
import org.apache.commons.lang.ObjectUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Coins_command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender Sender, Command Command, String String, String[] ArrayOfString){
        if(Sender instanceof Player){
            Player player = (Player)Sender;
            if((Command.getName().equalsIgnoreCase("coins"))){
                try {
                    if(ArrayOfString.length == 0){
                        player.sendMessage("§eAktualne mas §7" + Main.getInstance().getFetchData().getPlayerCoins(player.getUniqueId()) + " §ecoinu!");
                        return true;
                    }
                    return true;
                } catch(NullPointerException e){
                    Main.getInstance().getBugsnag().notify(e);
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}