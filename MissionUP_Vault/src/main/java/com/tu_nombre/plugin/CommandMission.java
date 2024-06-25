package com.tu_nombre.plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandMission implements CommandExecutor {

    private MissionManager missionManager;

    public CommandMission(MissionManager missionManager) {
        this.missionManager = missionManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length > 0) {
                String mission = String.join(" ", args);
                missionManager.assignMission(player.getUniqueId(), mission);
                double reward = 10.0; // Recompensa fija de ejemplo
                Main.getEconomy().depositPlayer(player, reward);
                player.sendMessage("Misión asignada: " + mission + ". Has ganado " + reward + " monedas.");
                return true;
            } else {
                player.sendMessage("Uso correcto: /mission <tarea>");
                return false;
            }
        }
        return false;
    }
}
