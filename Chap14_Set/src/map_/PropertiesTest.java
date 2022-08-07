package map_;

import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) {
        Properties properties = new Properties();

        try{
            properties.put(null, 18);
        } catch (NullPointerException exception) {
            System.out.println("key != null");
        }
        try{
            properties.put("joker", null);
        } catch (NullPointerException exception) {
            System.out.println("value != null");
        }
        properties.put("skull", 20);
        properties.put("panther", 17);
        System.out.println(properties);

        properties.put("panther", 19);
        System.out.println(properties);

        properties.put("mona", 0);
        properties.put("crow", 19);
        System.out.println(properties);
        properties.remove("crow");
        System.out.println(properties);
    }
}
