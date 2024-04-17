package org.example.Service;

import org.example.Models.Player;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class for generating statistics
 */
public class StatCounter {
    private final Map<String,Integer> stat= new HashMap<>();

    public Map<String, Integer> getStat() {
        return stat;
    }

    /**
     *
     * @param players List of players
     * @param category Category for which to generate statistics
     * @return Which has a key is the value of the category and the value is the number of repetitions in the directory
     */
    public  Map<String,Integer> countStat(List<Player> players,String category){
        for (Player player:players) {
            stat.put(player.category_chose(category),stat.getOrDefault(player.category_chose(category),0)+1);
        }
        return stat;
    }
}
