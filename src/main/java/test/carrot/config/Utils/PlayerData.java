package test.carrot.config.Utils;

import org.bukkit.entity.Player;
import test.carrot.config.Config;
import test.carrot.config.Files.CreateFile;

public class PlayerData {

    private static final CreateFile config = new CreateFile(Config.getInstance(), "data.yml");

    public static void setPlayerData(Player target, String id, String value){
        config.setConfig(target.getName() + "." + id, value);
    }

    public static String getPlayerData(Player target, String id, String defaultValue){
        if(config.getConfig().getString(target.getName() + "." + id) == null){
            setPlayerData(target, id, defaultValue);
        }
        return config.getConfig().getString(target.getName() + "." + id);
    }

    public static int getDiamonds(Player target){
        return Integer.parseInt(getPlayerData(target, "diamonds", "0"));
    }

}
