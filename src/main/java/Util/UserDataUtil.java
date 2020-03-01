package Util;

import SimpleStat.StatType;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class UserDataUtil {
    private final File configFile;
    private static YamlConfiguration yml;
    private static Plugin plugin;
    private final Player player;
    public UserDataUtil(Plugin plugin, Player player){
        configFile = new File(plugin.getDataFolder()+"/database", "userdata.yml");
        this.player = player;
        this.plugin = plugin;
    }
    public Boolean setUserStats(Map<StatType, Double> map){
        String playerUUID = player.getUniqueId().toString();

        return true; //will be changed
    }
    public Boolean setUserStat(StatType type, int level){
        String playerUUID = player.getUniqueId().toString();

        return true; //will be changed
    }
    public Boolean setUserStat(StatType type, int level, float progress){
        String playerUUID = player.getUniqueId().toString();

        return true; //will be changed
    }
    public static void reloadConfig() {
        File configFile = new File(plugin.getDataFolder()+"/database", "userdata.yml");
        yml = YamlConfiguration.loadConfiguration(configFile);

        final InputStream defConfigStream = plugin.getResource(configFile.getName());
        if (defConfigStream == null) {
            return;
        }

        yml.setDefaults(
                YamlConfiguration.loadConfiguration(new InputStreamReader(defConfigStream, StandardCharsets.UTF_8)));
    }
}
