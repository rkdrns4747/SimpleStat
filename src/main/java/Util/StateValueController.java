package Util;

import SimpleStat.SimpleStat;
import SimpleStat.StatType;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.Map;

public class StateValueController {
    private final YamlConfiguration yml;
    private final Plugin plugin = SimpleStat.getInstance();
    private final ConfigFileUtil config = new ConfigFileUtil(plugin);


    public static int STRENGTH_STAT_MAXIMUM;
    public static int STAMINA_STAT_MAXIMUM;
    public static int AGILITY_STAT_MAXIMUM;
    public static int FORTUNE_STAT_MAXIMUM;
    public static int ACCURACY_STAT_MAXIMUM;
    public static int PROTECTION_STAT_MAXIMUM;

    StateValueController(YamlConfiguration yml) {
        this.yml = yml;

    }

    public Boolean check(Map<StatType, Integer> map){
        Boolean check = false;
        for(StatType st : map.keySet()){
            int value = map.get(st);
            String typeMaxSuffix = st.name()+"_STAT_MAXIMUM";

        }

        return true; //will be changed
    }
    /**
    public static StateValueController getByName(String name){
        for (final  StateValueController svc : values()) {
            if (svc.name().equals(name)) {
                return svc;
            }
        }
    }
     **/

}
