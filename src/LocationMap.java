import java.io.*;
import java.util.*;

public class LocationMap implements Map<Integer, Location> {

    private static final String LOCATIONS_FILE_NAME = "locations.txt";
    private static final String DIRECTIONS_FILE_NAME = "directions.txt";

    static Map<Integer, Location> locations = new HashMap<>();

    static {

        FileLogger fileLogger = new FileLogger();

        ConsoleLogger consoleLogger = new ConsoleLogger();

        consoleLogger.log("Available locations:");
        fileLogger.log("Available locations:");

        try {

            BufferedReader br = new BufferedReader(new FileReader(LOCATIONS_FILE_NAME));
            String eachLine;
            int locationIndex = 0;

            while ((eachLine = br.readLine()) != null) {
                Map<String, Integer> eachExit = new LinkedHashMap<>();
                String[] location = eachLine.split(",", 2);
                Location eachLocation = new Location(locationIndex, location[1], eachExit);
                locations.put(locationIndex, eachLocation);
                locationIndex++;
                consoleLogger.log(location[0] + ": " + location[1]);
                fileLogger.log(location[0] + ": " + location[1]);
            }
            br.close();

        } catch (IOException e) {
            System.out.printf("%n");
        }

        consoleLogger.log("Available directions:");
        fileLogger.log("Available directions:");

        try {
            BufferedReader br2 = new BufferedReader(new FileReader(DIRECTIONS_FILE_NAME));
            String eachLine2;

            while ((eachLine2 = br2.readLine()) != null) {
                String[] direction = eachLine2.split(",");
                consoleLogger.log(direction[0] + ": " + direction[1] + ": " + direction[2]);
                fileLogger.log(direction[0] + ": " + direction[1] + ": " + direction[2]);
            }
            br2.close();

        } catch (IOException e) {
            System.out.printf("%n");
        }

        try {
            BufferedReader br3 = new BufferedReader(new FileReader(DIRECTIONS_FILE_NAME));
            String eachLine3;

            while ((eachLine3 = br3.readLine()) != null) {
                String[] direction = eachLine3.split(",");
                locations.get(Integer.parseInt(direction[0])).addExit(direction[1], Integer.parseInt(direction[2]));
            }

        } catch (IOException e) {
            System.out.printf("%n");
        }
    }

    @Override
    public int size() {

        return locations.size();
    }

    @Override
    public boolean isEmpty() {

        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {

        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {

        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {

        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {

        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {

        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

        locations.putAll(m);
    }

    @Override
    public void clear() {

        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {

        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {

        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {

        return locations.entrySet();
    }
}
