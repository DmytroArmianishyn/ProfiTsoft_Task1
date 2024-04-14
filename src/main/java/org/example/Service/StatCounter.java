package org.example.Service;

import org.example.Models.Player;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatCounter {


    private final Map<String,Integer> stat= new HashMap<>();

    public Map<String, Integer> getStat() {
        return stat;
    }

    public  Map<String,Integer> countStat(List<Player> players){


        for (Player player:players) {
            stat.put(player.getTeam(),stat.getOrDefault(player.getTeam(),0)+1);

        }



        return stat;

    }

}
