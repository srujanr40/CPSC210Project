package persistence;

import model.Player;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import persistence.Reader;
import rooms.Room1;
import rooms.Room2;
import rooms.Room3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ReaderTest {

    @Test
    void testParsePlayerFile1() {
        try {
            Player testPlayer1 = Reader.readPlayer(new File("./data/testPlayerFile1.txt"));
            assertEquals(100, testPlayer1.getHealth());
            assertEquals(1, testPlayer1.getInventory().size());
            assertEquals(2, testPlayer1.getLocation().getRoomNumber());
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test
    void testIOException() {
        try {
            Reader.readPlayer(new File("./path/does/not/exist/testPlayer.txt"));
            fail("The code should not have reached this line");
        } catch (IOException e) {
            // expected
        }
    }

    @Test
    void testGetSpecificItem() {
        assertEquals(Room1.KEROSENE_LAMP, Reader.main.getSpecificItem("Kerosene Lamp"));
        assertEquals(Room2.LAPTOP, Reader.main.getSpecificItem("Laptop"));
        assertEquals(Room2.ANCIENT_KEY, Reader.main.getSpecificItem("Ancient Key"));
        assertEquals(Room3.MONOGRAMMED_JOURNAL, Reader.main.getSpecificItem("Monogrammed Journal"));
        assertEquals(null, Reader.main.getSpecificItem("Random String"));
    }

    @Test
    void testGetSpecificRoom() {
        assertEquals(Reader.main.room1, Reader.main.getSpecificRoom(1));
        assertEquals(Reader.main.room2, Reader.main.getSpecificRoom(2));
        assertEquals(Reader.main.room3, Reader.main.getSpecificRoom(3));
        assertEquals(null, Reader.main.getSpecificRoom(69));
    }

}
