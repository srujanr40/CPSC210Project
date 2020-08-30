package persistence;

import model.InventoryItem;
import model.Player;
import rooms.Room;
//import rooms.Room1;
//import rooms.Room2;
//import rooms.Room3;
import ui.Main;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reader {
    public static final String DELIMITER = "!!!";
    public static final String INVEN_DELIMITER = "&&&";
    public static final Main main = new Main();
//    public static Room1 room1 = new Room1();
//    public static Room2 room2 = new Room2();
//    public static Room3 room3 = new Room3();

    // EFFECTS: returns a player parsed from file; throws
    // IOException if an exception is raised when opening / reading from file
    public static Player readPlayer(File file) throws IOException {
        List<String> fileContent = readFile(file);
        ArrayList<String> lineComponents = splitString(fileContent.get(0));
        return parsePlayer(lineComponents);
    }

    // EFFECTS: returns content of file as a list of strings, each string
    // containing the content of one row of the file
    private static List<String> readFile(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    // EFFECTS: returns a list of strings obtained by splitting line on DELIMITER
    private static ArrayList<String> splitString(String line) {
        String[] splits = line.split(DELIMITER);
        return new ArrayList<>(Arrays.asList(splits));
    }

    // EFFECTS: returns a list of InventoryItem names
    private static ArrayList<String> parseInventory(String components) {
        String[] splits = components.split(INVEN_DELIMITER);
        return new ArrayList<>(Arrays.asList(splits));
    }

//    // EFFECTS: returns a specific item from a specific room for save/load
//    public static InventoryItem getSpecificItem(String invenName) {
//        switch (invenName) {
//            case "Kerosene Lamp": return Room1.KEROSENE_LAMP;
//            case "Ancient Key": return Room2.ANCIENT_KEY;
//            case "Laptop": return Room2.LAPTOP;
//            case "Monogrammed Journal": return Room3.MONOGRAMMED_JOURNAL;
//        }
//        return null;
//    }

//    // EFFECTS: returns a specific room for save/load
//    public static Room getSpecificRoom(int roomNum) {
//        switch (roomNum) {
//            case 1: return room1;
//            case 2: return room2;
//            case 3: return room3;
//        }
//        return null;
//    }


    // REQUIRES: components has size 3 where element 0 represents the
    // health of the player, element 1 represents
    // the player's inventory, element 2 represents the room
    // EFFECTS: returns a player constructed from components
    private static Player parsePlayer(List<String> components) {
        int loadHealth = Integer.parseInt(components.get(0));
        String itemNames = components.get(1);
        ArrayList<String> itemNameList = parseInventory(itemNames);
        ArrayList<InventoryItem> loadInventory = new ArrayList<>();
        for (String s : itemNameList) {
            InventoryItem x = main.getSpecificItem(s);
            loadInventory.add(x);
        }
        int roomNumber = Integer.parseInt(components.get(2));
        Room room = main.getSpecificRoom(roomNumber);
        Player loadPlayer = new Player();
        loadPlayer.changeHealth(loadHealth);
        loadPlayer.inventory = loadInventory;
        loadPlayer.changeLoc(room);

        return loadPlayer;
    }
}

