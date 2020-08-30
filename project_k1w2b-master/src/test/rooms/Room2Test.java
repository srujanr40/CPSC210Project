package rooms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class Room2Test {
    Room2 testRoom;

    @BeforeEach
    void runBefore() {
        testRoom = new Room2();
    }

    @Test
    void testPrintItemsInRoom() {
        assertEquals("1. Ancient Key\n2. Laptop\n3. Floppy Disk\n", testRoom.printItemsInRoom());
    }

    @Test
    void testReturnSpecificItem() {
        assertEquals(testRoom.ANCIENT_KEY, testRoom.returnSpecificItem("Ancient Key"));
        assertEquals(testRoom.LAPTOP, testRoom.returnSpecificItem("Laptop"));
        assertEquals(testRoom.FLOPPY_DISK, testRoom.returnSpecificItem("Floppy Disk"));
        assertEquals(null, testRoom.returnSpecificItem("random characters"));
        assertEquals(null, testRoom.returnSpecificItem("asdf"));
    }

    @Test
    void testGetRoomNumber() {
        assertEquals(2, testRoom.getRoomNumber());
    }

    @Test
    void testGetPrintInteractionsInRoom() {
        assertEquals("There's a meticulously arranged /Dining Table/ takes the stage-light in the center of the "
                + "room. Although it seems freshly laid out, everything seems empty except for the /Cloche/ covering "
                + "the silver plate at the forefront\n", testRoom.printInteractionsInRoom());
    }

    @Test
    void testInteract() {
        assertEquals("There's a perfectly laid out dining table at the center of this room, although the without any"
                + " food on it. The candles are lit too. Someone's been here recently.\n", testRoom.interact("Dining Table"));
        assertEquals("You notice the silver plate at the center has a cloche covering it. You lean ahead "
                + "and lift it to notice a floppy disk with the numbers 31824 written on it\n", testRoom.interact("Cloche"));
        assertEquals("You can't interact with that\n", testRoom.interact("Random String"));
    }
}