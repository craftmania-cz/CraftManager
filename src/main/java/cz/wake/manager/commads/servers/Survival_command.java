package cz.wake.manager.commads.servers;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.CommandHelp;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.annotation.HelpCommand;
import cz.wake.manager.Main;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("survival")
@Description("Připojí tě na Survival")
public class Survival_command extends BaseCommand {

    @HelpCommand
    public void helpCommand(CommandSender sender, CommandHelp help) {
        sender.sendMessage("§e§lSurvival commands:");
        help.showHelp();
    }

    @Default
    public void connectToSurvival(CommandSender Sender) {
        if (Sender instanceof Player) {
            Player player = (Player) Sender;
            try {
                player.sendMessage("§eTeleportuji na server §fSurvival");
                Main.getInstance().sendToServer(player, "survival");
            } catch (Exception e) {
                e.printStackTrace();
                player.sendMessage("§cTeleport na server §fSurvival §cse nezdařil!");
                Main.getInstance().sendSentryException(e);
            }
        }
    }
}
