package com.example.power;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GeneratorTest {

    @Test
    void startsInactiveAndGeneratesNothing() {
        Generator generator = new Generator("涡轮机", 100);

        assertFalse(generator.isActive());
        assertEquals(0, generator.getElectricReleaseGeneration());
    }

    @Test
    void generatesCapacityOnlyWhileActive() {
        Generator generator = new Generator("涡轮机", 100);

        generator.activate();
        assertTrue(generator.isActive());
        assertEquals(100, generator.getElectricReleaseGeneration());

        generator.deactivate();
        assertFalse(generator.isActive());
        assertEquals(0, generator.getElectricReleaseGeneration());
    }

    @Test
    void rejectsNullOrBlankName() {
        assertThrows(IllegalArgumentException.class, () -> new Generator(null, 10));
        assertThrows(IllegalArgumentException.class, () -> new Generator("  ", 10));
    }

    @Test
    void rejectsNegativeCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new Generator("涡轮机", -1));
    }
}
