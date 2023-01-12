package test.carrot.config;

import org.bukkit.plugin.java.JavaPlugin;
import test.carrot.config.Events.BreakDiamonds;
import test.carrot.config.Utils.ConfigData;

public final class Config extends JavaPlugin {

    private static Config plugin;

    public static Config getInstance(){
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        this.getServer().getPluginManager().registerEvents(new BreakDiamonds(), this);
        ConfigData.setConfig("enable", "si");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
