package com.example.power;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 电力总线框架：保存能力接口、汇总数据并生成报告。
 * 不要在总线中针对 Generator 或 PowerLoad 写具体类型分支。
 */
public final class ElectricBus {
    private static final Logger logger = LoggerFactory.getLogger(ElectricBus.class);

    private final List<IElectricGenerator> generators = new ArrayList<>();
    private final List<IElectricConsumer> consumers = new ArrayList<>();

    public void register(IElectricGenerator generator) {
        // TODO 拒绝 null，避免重复注册；成功注册时记录 info。
    }

    public void register(IElectricConsumer consumer) {
        // TODO 拒绝 null，避免重复注册；成功注册时记录 info。
    }

    public int getTotalGeneration() {
        // TODO 汇总启用发电设备的发电量。
        return 0;
    }

    public int getTotalConsumption() {
        // TODO 汇总启用用电设备的耗电量。
        return 0;
    }

    public PowerReport getReport() {
        // TODO 比较发电量和耗电量，构造并返回报告。
        return new PowerReport(0, 0, PowerState.NORMAL);
    }

    public void printReport() {
        // TODO 短缺使用 warn，其余状态使用 info。
        logger.info("TODO: print the power report");
    }
}
