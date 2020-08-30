package rooms;

import model.Interaction;
import model.InventoryItem;
import java.util.Scanner;

public class Room1 extends Room {

    public Room1() {
        this.canEnter = true;
    }

    public static final InventoryItem KEROSENE_LAMP = new InventoryItem("Kerosene Lamp", "A regular looking "
            + "kerosene lamp that seems like its seen its fair share of wear and tear. It has a considerable amount "
            + "of kerosene in so it doesn't seem like it will run out anytime soon\n");

    public static Interaction barricade = new Interaction("Barricade", "The fourth door in the room"
            + " seems to be barricade by a concerningly large amount of furniture. It seems like someone was trying"
            + " to keep people out...........or keep something in\n",true,"");

    public static Interaction fishTank = new Interaction("Fish Tank", "At one point this tank"
            + " would've been springing with life. Now, it's resolved to being a grave for the dozen or so clownfish "
            + "that had the misfortune of being bought by the wrong person\n", true, "");

    @Override
    // EFFECTS: prints the items in this room
    public String printItemsInRoom() {
        System.out.println("The items in this room are:\n");
        System.out.println("1. Kerosene Lamp\n");
        return "1. Kerosene Lamp\n";
    }

    @Override
    // EFFECTS: returns a specific item from this room based on user input
    public InventoryItem returnSpecificItem(String itemName) {
        switch (itemName) {
            case "Kerosene Lamp":
                return KEROSENE_LAMP;
            default:
                System.out.println("You have entered the name of an item that doesn't exist in this room\n");
        }
        return null;
    }

    @Override
    // EFFECTS: returns the number of the room
    public int getRoomNumber() {
        return 1;
    }

    @Override
    // EFFECTS: prints the interactions in the room
    public String printInteractionsInRoom() {
        return "You notice a large /Barricade/ set up at one of the doors leading out of this room. In "
                + "the right corner, you also notice a brightly lit /Fish Tank/ that perfectly juxtaposes the ambiance"
                + " of the rest of the room\n";
    }


    @Override
    // EFFECTS: returns the interaction of a chosen object
    public String interact(String interaction) {
        switch (interaction) {
            case "Barricade": barricade.changeInteracted(true);
               return barricade.getInteraction();
            case "Fish Tank": fishTank.changeInteracted(true);
                return fishTank.getInteraction();
            default: System.out.println("You can't interact with that\n");
                return "You can't interact with that\n";
        }
    }
}