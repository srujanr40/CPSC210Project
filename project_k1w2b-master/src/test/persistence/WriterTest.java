package persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Player;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import persistence.Reader;
import rooms.Room;
import rooms.Room1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class WriterTest {
    private static final String TEST_FILE = "./data/testPlayer.txt";
    private Writer testWriter;
    private Player testPlayer;
    private Room room1;

    @BeforeEach
    void runBefore() throws FileNotFoundException, UnsupportedEncodingException {
        testWriter = new Writer(new File(TEST_FILE));
        testPlayer = new Player();
        room1 = new Room1();
        testPlayer.changeLoc(room1);
    }


    @Test
    void testWriteProgress() {
        //save progress to file
        testWriter.write(testPlayer);
        testWriter.close();

        // now read them back in and verify that the player has the expected values
        try {
            Player loadPlayer = Reader.readPlayer(new File(TEST_FILE));
            assertEquals(100, loadPlayer.getHealth());
            assertEquals(1, loadPlayer.getInventory().size());
            assertEquals(1, loadPlayer.getLocation().getRoomNumber());
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }

    }

}
