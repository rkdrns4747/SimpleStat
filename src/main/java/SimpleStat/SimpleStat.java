package SimpleStat;

import Util.ConfigFileUtil;
import Util.UserDataUtil;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class SimpleStat extends JavaPlugin {
    public YamlConfiguration userDataYml;
    public File userDataYmlFile;
    public YamlConfiguration configYml;
    public File configYmlFile;
    private static JavaPlugin plugin;

    public void onEnable(){
        plugin = this;
        userDataYmlFile = new File(this.getDataFolder()+"/database", "userdata.yml");
        configYmlFile = new File(this.getDataFolder(), "config.yml");
        Boolean ymlFileAvailability = checkFileAvailability(userDataYmlFile, configYmlFile);
        if(ymlFileAvailability) {
            //nothing
        }else {
            Bukkit.getLogger().info("userdata.yml 또는 config.yml 파일을 찾을 수 없었습니다. 새롭게 생성하였습니다.");
        }
        userDataYml = YamlConfiguration.loadConfiguration(userDataYmlFile);
        configYml = YamlConfiguration.loadConfiguration(userDataYmlFile);
        saveResource("config.yml", false);
    }
    public static JavaPlugin getInstance(){
        return plugin;
    }
    private static Boolean checkFileAvailability(File userDataYml, File configYml){
        Boolean validation;
        if(!(userDataYml.exists()) || !(configYml.exists())) {
            validation = false;
            try {
                if (!userDataYml.exists())
                    userDataYml.createNewFile();

                if (!configYml.exists())
                    plugin.saveDefaultConfig();

            } catch (IOException e) {
                Bukkit.getLogger().warning(e.getMessage());
            }
        } else{
            validation = true;
        }
        return validation;
    }
    public static Boolean checkFileAvailability(File yamlFile){
        Boolean validation;
        if(!(yamlFile.exists())) {
            validation = false;
            try {

                if (!yamlFile.exists())
                    yamlFile.getParentFile().mkdirs();
                    yamlFile.createNewFile();

            } catch (IOException e) {
                Bukkit.getLogger().warning(e.getMessage());
            }
        } else{
            validation = true;
        }
        return validation;
    }


}
