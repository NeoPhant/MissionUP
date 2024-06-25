package com.tu_nombre.plugin;

import java.util.HashMap;
import java.util.UUID;

public class MissionManager {

    private HashMap<UUID, String> playerMissions;

    public MissionManager() {
        playerMissions = new HashMap<>();
    }

    public void assignMission(UUID playerId, String mission) {
        playerMissions.put(playerId, mission);
    }

    public String getMission(UUID playerId) {
        return playerMissions.getOrDefault(playerId, "No tienes misiones asignadas.");
    }
}
