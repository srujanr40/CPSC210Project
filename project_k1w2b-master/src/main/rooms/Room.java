package rooms;

import model.Interaction;
import model.InventoryItem;

public abstract class Room {
    public boolean canEnter;

    public Room() {
        canEnter = false;
    }

    // EFFECTS: prints the items in the room
    public abstract String printItemsInRoom();

    // EFFECTS: prints the items in the room that can be interacted with
    public abstract String printInteractionsInRoom();

    // EFFECTS: returns a specific from the room
    public abstract InventoryItem returnSpecificItem(String itemName);

    public abstract int getRoomNumber();

    // EFFECTS: interacts with an item in the room
    public abstract String interact(String interaction);
}
