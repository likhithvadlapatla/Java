import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class LaunchApplication {
    public static void main(String[] args) throws JsonProcessingException {
        Alien alien1 = new Alien();
        alien1.setId(1);
        alien1.setName("Likhith");
        alien1.setCity("Eluru");

        Alien alien2 = new Alien();
        alien2.setId(2);
        alien2.setName("Triveni");
        alien2.setCity("Eluru");

        Alien alien3 = new Alien();
        alien3.setId(3);
        alien3.setName("Chandra Kiran");
        alien3.setCity("Eluru");

        List<Alien> list = new ArrayList<>();
        list.add(alien1);
        list.add(alien2);
        list.add(alien3);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
        System.out.println(json);



    }
}
