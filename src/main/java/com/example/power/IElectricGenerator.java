package com.example.power;

/** 描述可以向系统提供电能的设备能力。 */
public interface IElectricGenerator {

    /**
     * 返回设备当前可提供的发电量。
     * 停用设备应返回 0。
     *
     * @return 当前发电量
     */
    int getElectricReleaseGeneration();

    /**
     * 判断设备是否启用。
     *
     * @return 启用时为 {@code true}
     */
    boolean isActive();
}
