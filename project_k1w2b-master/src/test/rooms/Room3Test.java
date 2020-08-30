package rooms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class Room3Test {
    Room3 testRoom;

    @BeforeEach
    void runBefore() {
        testRoom = new Room3();
    }

    @Test
    void testPrintItemsInRoom() {
        assertEquals("1. Monogrammed Journal\n", testRoom.printItemsInRoom());
    }

    @Test
    void testReturnSpecificItem() {
        assertEquals(testRoom.MONOGRAMMED_JOURNAL, testRoom.returnSpecificItem("Monogrammed Journal"));
        assertEquals(null, testRoom.returnSpecificItem("asdf"));
        assertEquals(null, testRoom.returnSpecificItem("random characters"));
    }

    @Test
    void testRoomNumber() {
        assertEquals(3, testRoom.getRoomNumber());
    }

    @Test
    void testPrintInteractionsInRoom() {
        assertEquals("This room is relatively empty. Sort of underwhelming after all the weird things "
                + "you've come across so far. Maybe try moving to a different one to find more clues.\n", testRoom.printInteractionsInRoom());
    }

    @Test
    void testInteract() {
        assertEquals("Nothing in this room can be interacted with\n", testRoom.interact("Random String"));
    }
}