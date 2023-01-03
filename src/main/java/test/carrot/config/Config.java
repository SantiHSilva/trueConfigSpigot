package test.carrot.config;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import test.carrot.config.Events.BreakDiamonds;
import test.carrot.config.Files.ConfigFile;

public final class Config extends JavaPlugin implements Listener {

    public ConfigFile config;

    private static Config plugin;

    public static Config getInstance(){
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        this.getServer().getPluginManager().registerEvents(new BreakDiamonds(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
