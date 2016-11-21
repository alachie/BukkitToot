package co.lachie.bukkit.toot;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.regex.PatternSyntaxException;

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

        if(cmd.getName().equalsIgnoreCase("toot") && sender instanceof Player) {
            Player player = (Player) sender;

            if(args.length < 1 ) {

                player.sendMessage("you must have text after the command");

                return false;

            } else {

                String output = "";

                for(String s : args) output += s + " ";

                try {

                    String[] splitText = output.split("");
                    output = "";

                    for(String s : splitText) output += s + " ";

                    output = output.trim();
                    player.chat(output);

                    return true;

                } catch (PatternSyntaxException ex) {
                    player.sendMessage("PatternSyntaxException - input was not a string or would not split");
                    return false;
                }
            }

        } else if(cmd.getName().equalsIgnoreCase("shrug") && sender instanceof Player) {
            Player player = (Player) sender;
            String shruger = "¯\\_(ツ)_/¯";
            player.chat(shruger);
            return true;
        }

        return false;
    }
}