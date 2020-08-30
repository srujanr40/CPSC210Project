package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InteractionTest {
    public Interaction testInteraction;

    @BeforeEach
    void runBefore() {
        testInteraction = new Interaction("Name", "Touching the test Interaction", true, "");
    }

    @Test
    void testChangeInteracted() {
        assertFalse(testInteraction.getIsInteractedWith());
        testInteraction.changeInteracted(true);
        assertTrue(testInteraction.getIsInteractedWith());
    }

    @Test
    void testGetInteraction() {
        assertEquals("Touching the test Interaction", testInteraction.getInteraction());
    }

    @Test
    void testGetShortDesc() {
        assertEquals("Name", testInteraction.getShortDesc());
    }

    @Test
    void testGetCondition() {
        assertTrue(testInteraction.getCondition());
    }

    @Test
    void testGetConditionComment() {
        assertEquals("", testInteraction.getConditionComment());
    }
}
