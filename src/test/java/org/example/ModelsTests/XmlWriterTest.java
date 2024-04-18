package org.example.ModelsTests;

import org.example.Service.XmlWriter;
import org.junit.jupiter.api.Test;
import org.example.Models.Player;
import org.example.Service.StatCounter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Map;

public class XmlWriterTest{
    Map<String,Integer> map = new HashMap<String,Integer>(){{
        put("Golden State Warriors",2);
        put("Milwaukee Bucks",1);
        put("Los Angeles Clippers",1);
    }};

    @Test
    public void writeTest(){
        XmlWriter writer = new XmlWriter();
        writer.write(map,"D:\\Java\\ParsStats\\ParsStats\\src\\test\\java\\org\\example\\Result\\file.xml");
        File file = new File("D:\\Java\\ParsStats\\ParsStats\\src\\test\\java\\org\\example\\Result\\file.xml");
        assertTrue(file.exists());
    }
}
