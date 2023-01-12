package test.carrot.config.Utils;

import test.carrot.config.Config;
import test.carrot.config.Files.CreateFile;

public class ConfigData {

    private static final CreateFile config = new CreateFile(Config.getInstance(), "config.yml");

    public static void setConfig(String id, String value){
        config.setConfig(id, value);
    }

    public static String getConfig(String id, String defaultValue){
        if(config.getConfig().getString( id) == null){
            setConfig(id, defaultValue);
        }
        return config.getConfig().getString(id);
    }

}
