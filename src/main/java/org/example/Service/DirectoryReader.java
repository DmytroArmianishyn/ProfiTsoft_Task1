package org.example.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.JsonParser.PlayerParser;
import org.example.Models.Player;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Class for reading a directory and creating List with all players from files using streams
 */
public class DirectoryReader {
    /**
     A method that uses streams to read files from a directory and create players and add them to the List
     * @param directory Directory with files
     * @param mapper Class object ObjectMapper
     * @return
     */
    public List<Player> read(File directory, ObjectMapper mapper) {
        List<Player> players = new ArrayList<>();
        if ((directory.isDirectory() && directory.exists())) {
            File[] files = directory.listFiles();
            if (files == null || files.length == 0) {
                System.out.println("There are no JSON files to process in the specified folder.");
                throw new RuntimeException("There are no JSON files to process in the specified folder.");
            }
            PlayerParser parser = new PlayerParser();
            ExecutorService service = Executors.newFixedThreadPool(2);
            for (File file : files) {
                Thread thread = new Thread(() -> {
                    String json = parser.reade(file);
                    List<Player> players_tmp = parser.playerCreated(mapper, json);
                        players.addAll(players_tmp);
                });
                service.submit(thread);
            }
            service.shutdown();
            try {
                service.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return players;
    }
}
