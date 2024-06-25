package com.tu_nombre.plugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.entity.Player;

public class PlayerListener implements Listener {

    private MissionManager missionManager;

    public PlayerListener(MissionManager missionManager) {
        this.missionManager = missionManager;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String mission = missionManager.getMission(player.getUniqueId());
        player.sendMessage("Tu misión: " + mission);
    }
}
