package rooms;

import model.Interaction;
import model.InventoryItem;
import java.util.Scanner;

public class Room3 extends Room {

    public static final InventoryItem MONOGRAMMED_JOURNAL = new InventoryItem("Monogrammed Journal",
            "A giant 'M' has been engraved onto the front of the book. Perhaps with in a future "
                    + "CPSC210 Phase you might be able to read though it\n");

    public Room3() {
        this.canEnter = true;
    }

    @Override
    // EFFECTS: prints the items in this room
    public String printItemsInRoom() {
        System.out.println("The items in this room are:\n");
        System.out.println("1. Monogrammed Journal\n");
        return "1. Monogrammed Journal\n";
    }

    @Override
    // EFFECTS: returns a specific item from this room based on user input
    public InventoryItem returnSpecificItem(String itemName) {
        switch (itemName) {
            case "Monogrammed Journal":
                return MONOGRAMMED_JOURNAL;
            default: System.out.println("You have entered the name of an item that doesn't exist in this room\n");
        }
        return null;
    }

    @Override
    // EFFECTS: returns the number of the room
    public int getRoomNumber() {
        return 3;
    }

    @Override
    // EFFECTS: prints the interactions in the room
    public String printInteractionsInRoom() {
        return "This room is relatively empty. Sort of underwhelming after all the weird things "
                + "you've come across so far. Maybe try moving to a different one to find more clues.\n";
    }

    @Override
    // EFFECTS: returns the interaction of a chosen object
    public String interact(String interaction) {
        System.out.println("Nothing in this room can be interacted with\n");
        return "Nothing in this room can be interacted with\n";
    }
}
