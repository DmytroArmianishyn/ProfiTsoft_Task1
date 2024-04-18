package org.example.JsonParser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Models.Player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for parsing a JSON file
 */
public class PlayerParser {
    /**
     * A method that reads a file
     * @param file The file to be read
     * @return jason's thong
     */
    public  String reade(File file){
        if (file == null) {
            throw new IllegalArgumentException("File cannot be null");
        }
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new FileReader(file)))
        {
            String line;
            while ((line= reader.readLine())!=null)
                builder.append(line);
        }
        catch (IOException e){
            e.getMessage();
        }
        return builder.toString();
    }
    /**
     * Parses json format and creates players, then adds them to the player array
     * @param mapper Class object ObjectMapper
     * @param json Accepts a json string
     * @return The List of players
     */
    public List<Player> playerCreated(ObjectMapper mapper,String json){
        List<Player> players = new ArrayList<>();
        try {
            players=mapper.readValue(json, new TypeReference<List<Player>>(){});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return players;
    }
}
