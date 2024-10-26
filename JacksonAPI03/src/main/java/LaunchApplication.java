import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class LaunchApplication {
    public static void main(String[] args) throws IOException {

        /*Create Object Mapper*/
        ObjectMapper mapper = new ObjectMapper();

        /*JSON to Java.*/
        Alien alien = mapper.readValue(new File("json/sample.json"), Alien.class);
        System.out.println(alien);

        Integer id = alien.getId();
        String name = alien.getName();
        String city = alien.getCity();
        Course course = alien.getCourse();

        System.out.println(id + " : "+ name +" :"+ city);
        System.out.println(course);
        String[] hobbies = alien.getHobbies();
        for(String hobby:hobbies){
            System.out.println(hobby);
        }

    }
}
