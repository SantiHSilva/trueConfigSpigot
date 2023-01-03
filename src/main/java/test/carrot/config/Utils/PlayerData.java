package test.carrot.config.Utils;

import org.bukkit.entity.Player;
import test.carrot.config.Config;
import test.carrot.config.Files.ConfigFile;

public class PlayerData {

    private static ConfigFile config(){
        return new ConfigFile(Config.getInstance());
    }

    public static void setPlayerData(Player target, String id, String value){
        config().setConfig(target, id, value);
    }

    public static String getPlayerData(Player target, String id, String defaultValue){
        if(config().getConfig().getString(target.getName() + "." + id) == null){
            config().setConfig(target, id, defaultValue);
        }
        return config().getConfig().getString(target.getName() + "." + id);
    }

    public static int getDiamonds(Player target){
        return Integer.parseInt(getPlayerData(target, "diamonds", "0"));
    }

}
