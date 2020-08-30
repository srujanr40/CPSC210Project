package ui;

import model.InventoryItem;
import model.Player;
import rooms.Room;
import rooms.Room1;
import ui.Menu;

import rooms.Room1;
import rooms.Room2;
import rooms.Room3;



public class Main {

    public static Room1 room1 = new Room1();
    public static Room2 room2 = new Room2();
    public static Room3 room3 = new Room3();


    public static void intro() {
        System.out.println("You wake up\nYour eyes are still adjusting to the darkness\nYou try remember the events "
                + "leading up to this situation but your memory is fuzzy.\nYou realize the room is pitch black but you"
                + " can make out the faint outline of a lamp on a desk in front of you");
    }

    public static void main(String[] args) {
        System.out.println("-------------------------------------------------------");
        intro();
    }

    // EFFECTS: returns a specific item from a specific room for save/load
    public static InventoryItem getSpecificItem(String invenName) {
        switch (invenName) {
            case "Kerosene Lamp": return Room1.KEROSENE_LAMP;
            case "Ancient Key": return Room2.ANCIENT_KEY;
            case "Laptop": return Room2.LAPTOP;
            case "Monogrammed Journal": return Room3.MONOGRAMMED_JOURNAL;
        }
        return null;
    }

    // EFFECTS: returns a specific room for save/load
    public static Room getSpecificRoom(int roomNum) {
        switch (roomNum) {
            case 1: return room1;
            case 2: return room2;
            case 3: return room3;
        }
        return null;
    }


}
