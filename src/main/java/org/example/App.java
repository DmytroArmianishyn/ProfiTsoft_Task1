package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.JsonParser.PlayerParser;
import org.example.Models.Player;
import org.example.Service.StatCounter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ObjectMapper mapper = new ObjectMapper();

        String json = PlayerParser.parse("D:\\Java\\ParsStats\\ParsStats\\src\\main\\java\\org\\example\\Files\\Players.json");
        List<Player> players = PlayerParser.playerCreated(mapper,json);
        System.out.println(players);
        StatCounter counter = new StatCounter();
        counter.countStat(players);
        System.out.println(counter.getStat());
        counter.countStat(players);
        System.out.println(counter.getStat());
    }
}
