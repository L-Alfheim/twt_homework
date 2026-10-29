package com.example.power;

/** 发电设备起步框架；请完成参数校验和发电量计算。 */
public final class Generator extends PowerDevice implements IElectricGenerator {
    private final int capacity;

    public Generator(String name, int capacity) {
        super(name);
        // TODO capacity 不得为负数。
        this.capacity = capacity;
    }

    @Override
    public int getElectricReleaseGeneration() {
        // TODO 启用时返回 capacity，停用时返回 0。
        return 0;
    }
}
