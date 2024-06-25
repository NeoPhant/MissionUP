package com.tu_nombre.plugin;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private MissionManager missionManager;
    private static Economy economy = null;

    @Override
    public void onEnable() {
        if (!setupEconomy()) {
            getLogger().severe("Vault no encontrado! Desactivando plugin...");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        missionManager = new MissionManager();
        getCommand("mission").setExecutor(new CommandMission(missionManager));
        getServer().getPluginManager().registerEvents(new PlayerListener(missionManager), this);
        getLogger().info("MissionUP habilitado!");
    }

    @Override
    public void onDisable() {
        getLogger().info("MissionUP deshabilitado!");
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        economy = rsp.getProvider();
        return economy != null;
    }

    public static Economy getEconomy() {
        return economy;
    }
}
