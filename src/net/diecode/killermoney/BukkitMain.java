package net.diecode.killermoney;

import com.garbagemule.MobArena.MobArenaHandler;
import net.diecode.killermoney.commands.KMAdminCommand;
import net.diecode.killermoney.commands.KMCommand;
import net.diecode.killermoney.configs.DefaultConfig;
import net.diecode.killermoney.functions.*;
import net.diecode.killermoney.managers.ConfigManager;
import net.diecode.killermoney.managers.EntityManager;
import net.diecode.killermoney.managers.KMPlayerManager;
import net.diecode.killermoney.objects.KMPlayer;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public class BukkitMain extends JavaPlugin {

    private static BukkitMain instance;
    private static Metrics metrics;

    private static Economy economy;
    private static MobArenaHandler mobArenaHandler;
    private static Updater updater;

    private void initMetrics() {
        metrics = new Metrics(this);
        metrics.addCustomChart(new Metrics.SimplePie("used_message_method", () ->
                DefaultConfig.getMessageMethod().name().toUpperCase()));

        metrics.addCustomChart(new Metrics.SimplePie("used_money_item_drop", () ->
                DefaultConfig.isMoneyItemDropEnabled() ? "Enabled" : "Disabled"));
    }

    private boolean initEconomy() {
        RegisteredServiceProvider<Economy> economyProvider =
                Bukkit.getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);

        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }

    private void hookMobArena() {
        if (Bukkit.getPluginManager().getPlugin("MobArena") != null) {
            mobArenaHandler = new MobArenaHandler();
            Logger.info("MobArena hooked");
        } else {
            Logger.info("MobArena not found");
        }
    }

    @Override
    public void onEnable() {
        instance = this;

        ConfigManager.init();

        updater = new Updater();

        initMetrics();

        if (!initEconomy()) {
            Logger.warning("Vault or economy plugin not found! Money reward disabled.");
        }

        if (DefaultConfig.isHookMobArena()) {
            hookMobArena();
        }

        getCommand("km").setExecutor(new KMCommand());
        getCommand("kmadmin").setExecutor(new KMAdminCommand());

        org.bukkit.plugin.PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new EntityManager(), this);
        pm.registerEvents(new MoneyHandler(), this);
        pm.registerEvents(new CItemHandler(), this);
        pm.registerEvents(new CCommandHandler(), this);
        pm.registerEvents(new CExpHandler(), this);
        pm.registerEvents(new MessageHandler(), this);
        pm.registerEvents(new CashTransferHandler(), this);
        pm.registerEvents(new AntiFarmingHandler(), this);
        pm.registerEvents(new LimitHandler(), this);
        pm.registerEvents(new MultiplierHandler(), this);
        pm.registerEvents(new KMPlayerManager(), this);
        pm.registerEvents(updater, this);

        if (DefaultConfig.isCheckUpdate()) {
            getServer().getScheduler().runTaskTimerAsynchronously(this, new Runnable() {
                @Override
                public void run() {
                    if (!Updater.isUpdateAvailable()) {
                        updater.query();
                    }
                }
            }, 20L, 20L * 60 * 60 * 24);
        }

        for (Player p : Bukkit.getOnlinePlayers()) {
            UUID pUUID = p.getUniqueId();

            if (!KMPlayerManager.getKMPlayers().containsKey(pUUID)) {
                KMPlayerManager.getKMPlayers().put(pUUID, new KMPlayer(p));
            }
        }
    }

    @Override
    public void onDisable() {
        // unregister all registered listeners in this plugin
        org.bukkit.event.HandlerList.unregisterAll(this);
        instance = null;
        updater = null;
    }

    public static BukkitMain getInstance() {
        return instance;
    }

    public static Economy getEconomy() {
        return economy;
    }

    public static MobArenaHandler getMobArenaHandler() {
        return mobArenaHandler;
    }
}
