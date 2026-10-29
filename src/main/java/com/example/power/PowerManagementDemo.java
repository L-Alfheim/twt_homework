package com.example.power;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 作业程序入口提示：组装设备，注册、启用并输出供需报告。 */
public final class PowerManagementDemo {
    private static final Logger logger = LoggerFactory.getLogger(PowerManagementDemo.class);

    private PowerManagementDemo() {
    }

    public static void main(String[] args) {
        try {
            ElectricBus bus = new ElectricBus();
            Generator turbine = new Generator("燃气轮机", 1000);
            Generator solar = new Generator("太阳能板", 300);
            PowerLoad lifeSupport = new PowerLoad("生命支持", 500);
            PowerLoad radar = new PowerLoad("雷达", 250);

            // TODO 注册并启用设备，输出报告；停用 turbine 后再次输出。
            bus.register(turbine);
            bus.register(solar);
            bus.register(lifeSupport);
            bus.register(radar);
        } catch (IllegalArgumentException exception) {
            // TODO 在入口处理并记录异常，不要在底层吞掉异常。
            logger.error("电力系统启动失败：{}", exception.getMessage(), exception);
        }
    }
}
