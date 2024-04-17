package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.JsonParser.PlayerParser;
import org.example.Models.Player;
import org.example.Service.DirectoryReader;
import org.example.Service.StatCounter;
import org.example.Service.XmlWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Armianishyn Dmytro
 * args[0]-Path to the directory to read Json files
 * args[1]-Category for which statistics will be generated
 * args[2]-Directory for writing to a file in Xml format
 */
public class App 
{
    public static void main( String[] args )
    {
        if (args.length<2){
            throw new RuntimeException("Bad size arguments");
        }
        ObjectMapper mapper = new ObjectMapper();
        List<Player> players= new ArrayList<>();
        DirectoryReader reader = new DirectoryReader();
        reader.read(new File(args[0]),players,mapper);
        StatCounter counter = new StatCounter();
        counter.countStat(players,args[1]);
        XmlWriter writer = new XmlWriter();
        writer.write(counter.getStat(),args[2]);

    }
}
