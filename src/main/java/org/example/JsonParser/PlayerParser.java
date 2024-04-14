package org.example.JsonParser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Models.Player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlayerParser {



    public static String parse(String file){
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new FileReader(file)))
        {
            String line;
            while ((line= reader.readLine())!=null)
                builder.append(line);

        }catch (IOException e){
            e.getMessage();
        }

        return builder.toString();


    }

    public static List<Player> playerCreated(ObjectMapper mapper,String json){
        List<Player> players = new ArrayList<>();
        try {
            players=mapper.readValue(json, new TypeReference<List<Player>>(){});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return players;
    }


}
