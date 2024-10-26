import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LaunchApplication {
    public static void main(String[] args) throws IOException {

        /*Create Object Mapper*/
        ObjectMapper mapper = new ObjectMapper();

        /*JSON to Java.*/
        Alien alien = mapper.readValue(new File("json/sample.json"), Alien.class);
        System.out.println(alien);
    }
}
