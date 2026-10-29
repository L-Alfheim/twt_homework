package com.example.power;

/** 一次供需汇总结果。 */
public record PowerReport(int totalGeneration, int totalConsumption, PowerState state) {
}
