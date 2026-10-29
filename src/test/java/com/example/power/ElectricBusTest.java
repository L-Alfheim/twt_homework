package com.example.power;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ElectricBusTest {

    @Test
    void emptyBusReportsNormalWithZeroTotals() {
        PowerReport report = new ElectricBus().getReport();

        assertEquals(0, report.totalGeneration());
        assertEquals(0, report.totalConsumption());
        assertEquals(PowerState.NORMAL, report.state());
    }

    @Test
    void aggregatesActiveDevicesAndIgnoresInactiveDevices() {
        ElectricBus bus = new ElectricBus();
        Generator activeGenerator = new Generator("涡轮机", 100);
        Generator inactiveGenerator = new Generator("备用机", 900);
        PowerLoad activeLoad = new PowerLoad("照明", 40);
        PowerLoad inactiveLoad = new PowerLoad("备用设备", 700);
        activeGenerator.activate();
        activeLoad.activate();

        bus.register(activeGenerator);
        bus.register(inactiveGenerator);
        bus.register(activeLoad);
        bus.register(inactiveLoad);

        PowerReport report = bus.getReport();
        assertEquals(100, report.totalGeneration());
        assertEquals(40, report.totalConsumption());
        assertEquals(PowerState.SURPLUS, report.state());
    }

    @Test
    void reportsShortageWhenConsumptionExceedsGeneration() {
        ElectricBus bus = new ElectricBus();
        Generator generator = new Generator("涡轮机", 40);
        PowerLoad load = new PowerLoad("生命支持", 60);
        generator.activate();
        load.activate();
        bus.register(generator);
        bus.register(load);

        assertEquals(PowerState.SHORTAGE, bus.getReport().state());
    }

    @Test
    void reportsNormalWhenSupplyEqualsDemand() {
        ElectricBus bus = new ElectricBus();
        Generator generator = new Generator("涡轮机", 60);
        PowerLoad load = new PowerLoad("生命支持", 60);
        generator.activate();
        load.activate();
        bus.register(generator);
        bus.register(load);

        assertEquals(PowerState.NORMAL, bus.getReport().state());
    }

    @Test
    void doesNotCountDuplicateRegistrationTwice() {
        ElectricBus bus = new ElectricBus();
        Generator generator = new Generator("涡轮机", 60);
        generator.activate();
        bus.register(generator);
        bus.register(generator);

        assertEquals(60, bus.getTotalGeneration());
    }

    @Test
    void rejectsNullDevices() {
        ElectricBus bus = new ElectricBus();

        assertThrows(IllegalArgumentException.class, () -> bus.register((IElectricGenerator) null));
        assertThrows(IllegalArgumentException.class, () -> bus.register((IElectricConsumer) null));
    }
}
