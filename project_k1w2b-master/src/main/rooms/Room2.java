package rooms;

import model.Interaction;
import model.InventoryItem;
import java.util.Scanner;

public class Room2 extends Room {

    public Room2() {
        this.canEnter = true;
    }

    public static final InventoryItem ANCIENT_KEY = new InventoryItem("Ancient Key",
            "It looks way too old to be able to unlock anything built century\n");

    public static final InventoryItem LAPTOP = new InventoryItem("Laptop", "It has a lot of dust "
            + "on it but somehow still has some juice left in it. You're missing the password though\n");

    public static final InventoryItem FLOPPY_DISK = new InventoryItem("Floppy Disk", "The floppy disk"
            + " you found in the second room with the numbers 31824 etched onto it");

    public static Interaction diningTable = new Interaction("Dining Table", "There's a perfectly"
            + " laid out dining table at the center of this room, although the without any food on it. The candles"
            + " are lit too. Someone's been here recently.\n", true, "");

    public static Interaction cloche = new Interaction("Cloche", "You notice the silver plate at "
            + "the center has a cloche covering it. You lean ahead and lift it to notice a floppy disk"
            + " with the numbers 31824 written on it\n", true, "");

    @Override
    // EFFECTS: prints the items in this room
    public String printItemsInRoom() {
        System.out.println("The items in this room are: ");
        System.out.println("1. Ancient Key\n2. Laptop\n3. Floppy Disk");
        return "1. Ancient Key\n2. Laptop\n3. Floppy Disk\n";
    }

    @Override
    // EFFECTS: returns a specific item from this room based on user input
    public InventoryItem returnSpecificItem(String itemName) {
        switch (itemName) {
            case "Ancient Key":
                return ANCIENT_KEY;
            case "Laptop":
                return LAPTOP;
            case "Floppy Disk":
                return FLOPPY_DISK;
            default:
                System.out.println("You have entered the name of an item that doesn't exist in this room\n");
        }
        return null;
    }

    @Override
    // EFFECTS: returns the number of the room
    public int getRoomNumber() {
        return 2;
    }

    @Override
    // EFFECTS: prints the interactions in the room
    public String printInteractionsInRoom() {
        return "There's a meticulously arranged /Dining Table/ takes the stage-light in the center of the "
                + "room. Although it seems freshly laid out, everything seems empty except for the /Cloche/ covering "
                + "the silver plate at the forefront\n";
    }

    @Override
    // EFFECTS: returns the interaction of a chosen object
    public String interact(String interaction) {
        switch (interaction) {
            case "Dining Table": diningTable.changeInteracted(true);
                return diningTable.getInteraction();
            case "Cloche": cloche.changeInteracted(true);
                return cloche.getInteraction();
            default: System.out.println("You can't interact with that \n");
                return "You can't interact with that\n";
        }
    }
}
