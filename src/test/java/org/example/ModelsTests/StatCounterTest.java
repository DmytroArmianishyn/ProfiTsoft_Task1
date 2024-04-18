package org.example.ModelsTests;
import org.example.Models.Player;
import org.example.Service.StatCounter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StatCounterTest {


    List<Player> players = new ArrayList<Player>(){{
        add(new Player("LeBron James", "Small forward", "Los Angeles Lakers", 6));
        add(new Player("Kevin Durant", "Power forward", "Golden State Warriors", 2));
        add(new Player("Stephen Curry", "Point guard", "Golden State Warriors", 3));
        add(new Player("Giannis Antetokounmpo", "Power forward", "Milwaukee Bucks", 1));
        add(new Player("Kawhi Leonard", "Small forward", "Los Angeles Clippers", 2));
    }};
    @Test
    public void countStatTestNotNull(){
        StatCounter counter = new StatCounter();
        Map<String,Integer> map;
        map=counter.countStat(players,"team");
        assertNotNull(map);
    }
    @Test
    public void countStatTest(){
        StatCounter counter = new StatCounter();
        Map<String,Integer> map;
        map=counter.countStat(players,"team");
        assertEquals(2,map.get("Golden State Warriors"));
    }
}
