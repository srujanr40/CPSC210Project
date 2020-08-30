package rooms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class Room1Test {
    Room1 testRoom;

    @BeforeEach
    void runBefore() {
        testRoom = new Room1();
    }

    @Test
    void testPrintItemsInRoom() {
        assertEquals("1. Kerosene Lamp\n", testRoom.printItemsInRoom());
    }

    @Test
    void testReturnSpecificItem() {
        assertEquals(testRoom.KEROSENE_LAMP, testRoom.returnSpecificItem("Kerosene Lamp"));
        assertEquals(null, testRoom.returnSpecificItem("asdf"));
        assertEquals(null, testRoom.returnSpecificItem("random characters"));
    }

    @Test
    void testGetRoomNumber() {
        assertEquals(1, testRoom.getRoomNumber());
    }

    @Test
    void testPrintInteractionInRoom() {
        assertEquals("You notice a large /Barricade/ set up at one of the doors leading out of this room. In "
                + "the right corner, you also notice a brightly lit /Fish Tank/ that perfectly juxtaposes the ambiance"
                + " of the rest of the room\n", testRoom.printInteractionsInRoom());
    }

    @Test
    void testInteract() {
        assertEquals("The fourth door in the room"
                + " seems to be barricade by a concerningly large amount of furniture. It seems like someone was trying"
                + " to keep people out...........or keep something in\n", testRoom.interact("Barricade"));
        assertEquals("At one point this tank would've been springing with life. Now, it's resolved to being "
                + "a grave for the dozen or so clownfish that had the misfortune of being bought by the wrong person\n",
                testRoom.interact("Fish Tank"));
        assertEquals("You can't interact with that\n", testRoom.interact("Random String"));
    }
}
