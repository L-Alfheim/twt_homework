package com.example.power;

/** 用电设备起步框架；请完成参数校验和耗电量计算。 */
public final class PowerLoad extends PowerDevice implements IElectricConsumer {
    private final int demand;

    public PowerLoad(String name, int demand) {
        super(name);
        // TODO demand 不得为负数。
        this.demand = demand;
    }

    @Override
    public int getElectricConsumption() {
        // TODO 启用时返回 demand，停用时返回 0。
        return 0;
    }
}
