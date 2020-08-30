package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventoryItemTest {
    InventoryItem item1 = new InventoryItem("name1", "description1");

    @Test
    void testGetters() {
        assertEquals("name1", item1.getName());
        assertEquals("description1", item1.getDescription());
    }

}
