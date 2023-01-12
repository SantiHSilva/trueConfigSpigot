package test.carrot.config.Files;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import test.carrot.config.Config;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;

public class CreateFile {

    private final Config plugin;
    private FileConfiguration dataConfig;
    private File configFile = null;
    private final String fileName;

    // Cuando se crea un archivo, se requiere que este mismo archivo se encuentre en el resource
    // del plugin

    public CreateFile(Config plugin, String file) {
        this.plugin = plugin;
        fileName = file;
        saveDefaultConfig();
    }

    public void reloadConfig(){
        if (this.configFile == null) this.configFile = new File(this.plugin.getDataFolder(), fileName);
        this.dataConfig = YamlConfiguration.loadConfiguration(this.configFile);
        InputStream defaultStream = this.plugin.getResource(fileName);
        if(defaultStream != null){
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            this.dataConfig.setDefaults(defaultConfig);
        }
    }

    public FileConfiguration getConfig(){
        if (this.dataConfig == null) reloadConfig();
        return this.dataConfig;
    }

    public void saveConfig(){
        if (this.dataConfig == null || this.configFile == null) return;
        try {
            this.getConfig().save(this.configFile);
        } catch (Exception e){
            plugin.getLogger().log(Level.SEVERE, "Could not save config to " + this.configFile, e);
            e.printStackTrace();
        }
    }

    public void saveDefaultConfig(){
        if (this.configFile == null) this.configFile = new File(this.plugin.getDataFolder(), fileName);
        if (!this.configFile.exists()) this.plugin.saveResource(fileName, false);
    }

    public void setConfig(String id, String value){
        if (this.dataConfig == null) reloadConfig();
        this.dataConfig.set(id, value);
        this.saveConfig();
    }
}
