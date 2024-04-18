package org.example.parser;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.JsonParser.PlayerParser;
import org.example.Models.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;



public class PlayerParserTest {

    PlayerParser parser = new PlayerParser();
    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void teastReade(){
        File file = new File("D:\\Java\\ParsStats\\ParsStats\\src\\test\\java\\org\\example\\files\\player7");
         parser = new PlayerParser();
        String result = parser.reade(file);
        assertTrue(result.isEmpty());
    }
    @Test
    public void testReadNullException(){
        assertThrows(IllegalArgumentException.class,()-> {
            parser.reade(null);
        });
    }
    @Test
    public void createplayersTestNotNull(){
        String json = "[  {    \"name\": \"LeBron James\",    \"position\": \"Small forward\",    \"team\": \"Los Angeles Lakers\",    \"number\": 6  }]";
        assertNotNull(parser.playerCreated(mapper, json));
    }
    @Test
    public void createplayersTestTrue(){
        String json = "[  {    \"name\": \"LeBron James\",    \"position\": \"Small forward\",    \"team\": \"Los Angeles Lakers\",    \"number\": 6  }]";
        assertEquals(new Player("LeBron James","Small forward","Los Angeles Lakers",6).toString()
                ,parser.playerCreated(mapper, json).get(0).toString());
    }
}
