package com.example.power;

/** 描述需要消耗电能的设备能力。 */
public interface IElectricConsumer {

    /**
     * 返回设备当前的耗电量。
     * 停用设备应返回 0。
     *
     * @return 当前耗电量
     */
    int getElectricConsumption();

    /**
     * 判断设备是否启用。
     *
     * @return 启用时为 {@code true}
     */
    boolean isActive();
}
