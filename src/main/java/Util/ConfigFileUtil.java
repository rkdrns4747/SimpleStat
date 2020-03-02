package Util;

import SimpleStat.StatType;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class ConfigFileUtil {
    private final Plugin plugin;
    private File configFile;
    private FileConfiguration config;
    public ConfigFileUtil(Plugin plugin){
        this.plugin = plugin;
        this.configFile = new File(plugin.getDataFolder(), "config.yml");
        if(!configFile.exists())
                plugin.saveDefaultConfig();

        this.config = plugin.getConfig();
    }
    public Object get(String path){

        return config.get(path);
    }
    public void set(String path, Object value){
        config.set(path, value);
    }
    public void statTypeSpecificSet(String settingType, StatType type, Object value){
        String typeName = type.name();
        String path = "typeSpecific."+typeName+"."+settingType;

    }
}
