package com.example.power;

/**
 * 可选的共同父类提示：名称和启停状态可由发电、用电设备共享。
 * 不想使用继承时，可以把这些字段和方法分别放进设备类。
 */
public abstract class PowerDevice {
    private final String name;
    private boolean active;

    protected PowerDevice(String name) {
        // TODO 校验名称非 null 且非空；非法时抛 IllegalArgumentException。
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public void activate() {
        // TODO 将设备设为启用。
    }

    public void deactivate() {
        // TODO 将设备设为停用。
    }
}
