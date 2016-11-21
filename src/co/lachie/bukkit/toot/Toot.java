package co.lachie.bukkit.toot;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Toot extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("lachie toot is enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("lachie toot is disabled");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("toot") && sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length < 1 ) {

                player.sendMessage("you must have text after the command");

                return false;

            } else {

                StringBuilder output = new StringBuilder();

                for (String arg : args) {
                    for (char c : arg.toCharArray()) {
                        output.append(c);
                        output.append(' ');
                    }
                    output.append(' ');
                }

                player.chat(output.toString().trim());

                return true;

            }

        } else if (cmd.getName().equalsIgnoreCase("shrug") && sender instanceof Player) {
            Player player = (Player) sender;
            String shruger = "¯\\_(ツ)_/¯";
            player.chat(shruger);
            return true;
        }

        return false;
    }

}