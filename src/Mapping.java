import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Mapping {

    public static final int INITIAL_LOCATION = 95;
    static LocationMap locationMap = new LocationMap();
    Map<String, String> vocabulary = new HashMap<>();
    FileLogger fileLogger = new FileLogger();
    ConsoleLogger consoleLogger = new ConsoleLogger();

    public Mapping() {

        vocabulary.put("N", "N");
        vocabulary.put("NORTH", "N");
        vocabulary.put("E", "E");
        vocabulary.put("EAST", "E");
        vocabulary.put("S", "S");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("W", "W");
        vocabulary.put("WEST", "W");
        vocabulary.put("NE", "NE");
        vocabulary.put("NORTHEAST", "NE");
        vocabulary.put("NW", "NW");
        vocabulary.put("NORTHWEST", "NW");
        vocabulary.put("SE", "SE");
        vocabulary.put("SOUTHEAST", "SE");
        vocabulary.put("SW", "SW");
        vocabulary.put("SOUTHWEST", "SW");
        vocabulary.put("U", "U");
        vocabulary.put("UP", "U");
        vocabulary.put("D", "D");
        vocabulary.put("DOWN", "D");
        vocabulary.put("Q", "Q");
        vocabulary.put("QUIT", "Q");
    }

    public void mapping() {

        Scanner input = new Scanner(System.in);

        int currentLocation = INITIAL_LOCATION;

        while (true) {

            consoleLogger.log(locationMap.get(currentLocation).getDescription());
            fileLogger.log(locationMap.get(currentLocation).getDescription());

            if (locationMap.get(currentLocation).getLocationId() == 0) {
                break;
            }

            StringBuilder sb = new StringBuilder();

            for (Object x : locationMap.get(currentLocation).getExits().keySet()) {
                sb.append(x);
                sb.append(", ");
            }

            String[] exits = sb.toString().split(", ");

            consoleLogger.log("Available exits are " + sb);
            fileLogger.log("Available exits are " + sb);

            String direction = input.nextLine().toUpperCase();
            String[] userInput = direction.split(" ");

            StringBuilder sb2 = new StringBuilder();

            for (int a = 0; a < exits.length; a++) {
                for (Map.Entry<String, String> value : vocabulary.entrySet()) {
                    if (value.getValue().equals(exits[a])) {
                        sb2.append(value.getKey());
                        sb2.append(",");
                    }
                }
            }

            String[] correctExits = sb2.toString().split(",");

            boolean found = false;
            int count = 0;

            for (int x = userInput.length - 1; x >= 0; x--) {
                if (vocabulary.containsKey(userInput[x])) {
                    found = true;
                    break;
                } else {
                    count++;
                }
            }

            if (found) {

                boolean foundCorrectExit = false;

                for (int y = 0; y < correctExits.length; y++) {
                    if ((userInput[userInput.length - 1 - count]).equals(correctExits[y])) {
                        foundCorrectExit = true;
                        break;
                    }
                    if (((userInput[userInput.length - 1 - count].length() < 3 && userInput.length > 1)
                            && !userInput[userInput.length - 1 - count].equals("UP"))) {
                        break;
                    }
                }

                if (foundCorrectExit) {

                    currentLocation = locationMap.get(currentLocation).getExits()
                            .get(vocabulary.get(userInput[userInput.length - 1 - count]));

                } else {
                    consoleLogger.log("You cannot go in that direction");
                    fileLogger.log("You cannot go in that direction");
                }

            } else {
                consoleLogger.log("You cannot go in that direction");
                fileLogger.log("You cannot go in that direction");
            }

        }
    }

    public static void main(String[] args) {
        Mapping game = new Mapping();
        game.mapping();
    }
}
