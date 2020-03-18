package ex_002_json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Asus on 11.01.2018.
 */
public class Main {

    public static void main(String[] args) {
        Person person = new Person("Vasya", 20, Arrays.asList("Moscow", "Kiev", "Dubai") );

        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(person);

        System.out.println(json);

        Person person1 = gson.fromJson(json, Person.class);

        System.out.println(person1.getName() + " " + person1.getAge());

        List<String> geos = person1.getGeoHistory();

        for (String geo : geos) {
            System.out.println(geo);
        }

    }

}
