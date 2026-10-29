package com.example.power;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PowerLoadTest {

    @Test
    void startsInactiveAndConsumesNothing() {
        PowerLoad load = new PowerLoad("生命支持", 80);

        assertFalse(load.isActive());
        assertEquals(0, load.getElectricConsumption());
    }

    @Test
    void consumesDemandOnlyWhileActive() {
        PowerLoad load = new PowerLoad("生命支持", 80);

        load.activate();
        assertTrue(load.isActive());
        assertEquals(80, load.getElectricConsumption());

        load.deactivate();
        assertFalse(load.isActive());
        assertEquals(0, load.getElectricConsumption());
    }

    @Test
    void rejectsNullOrBlankName() {
        assertThrows(IllegalArgumentException.class, () -> new PowerLoad(null, 10));
        assertThrows(IllegalArgumentException.class, () -> new PowerLoad("  ", 10));
    }

    @Test
    void rejectsNegativeDemand() {
        assertThrows(IllegalArgumentException.class, () -> new PowerLoad("生命支持", -1));
    }
}
