package org.example.ModelsTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Models.Player;
import org.example.Service.DirectoryReader;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.util.List;

public class DirectoryReaderTests {
DirectoryReader reader = new DirectoryReader();
    @Test
    public void testRead(){
    long start = System.currentTimeMillis();
    reader.read(new File("D:\\Java\\ParsStats\\ParsStats\\src\\test\\java\\org\\example\\files"),new ObjectMapper());
    long end = System.currentTimeMillis();
    System.out.println(end-start);
    }

    @Test
    public void testReadNotNull(){
    List<Player> players =  reader.read(new File("D:\\Java\\ParsStats\\ParsStats\\src\\test\\java\\org\\example\\files"),new ObjectMapper());
    assertNotNull(players);
    }
}
