package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import rooms.Room1;
import rooms.Room2;
import rooms.Room3;


public class PlayerTest {
    Player player1;
    Player player2;
    Room1 room1 = new Room1();
    Room2 room2 = new Room2();
    Room3 room3 = new Room3();


    @BeforeEach
    void runBefore() {
        player1 = new Player();
        player2 = new Player();

        player1.changeLoc(room1);
        player2.changeLoc(room1);

        player2.addInventoryItem(room1.KEROSENE_LAMP);
        player2.addInventoryItem(room2.ANCIENT_KEY);
    }

    @Test
    void testChangeRoom() {
        assertEquals(room1, player2.getLocation());
        player2.changeLoc(room2);
        assertEquals(room2, player2.getLocation());
    }

    @Test
    void testPrintInventory() {
        assertEquals("Your inventory is empty", player1.printInventory());
        assertEquals("The items currently in your inventory are:\nKerosene Lamp\nAncient Key\n", player2.printInventory());
        player1.addInventoryItem(room3.MONOGRAMMED_JOURNAL);
        assertEquals("The items currently in your inventory are:\nMonogrammed Journal\n", player1.printInventory());
    }

    @Test
    void testChangeHealth() {
        assertEquals(100, player1.getHealth());
        player1.changeHealth(50);
        assertEquals(50, player1.getHealth());
        player1.changeHealth(2);
        assertEquals(2, player1.getHealth());
    }

    @Test
    void testInventory() {
        player1.addInventoryItem(room3.MONOGRAMMED_JOURNAL);
        assertEquals(1, player1.getInventory().size());
        assertEquals(room3.MONOGRAMMED_JOURNAL, player1.getInventory().get(0));
        player1.addInventoryItem(room2.ANCIENT_KEY);
        assertEquals(2, player1.getInventory().size());
        assertEquals(room2.ANCIENT_KEY, player1.getInventory().get(1));
    }
}
