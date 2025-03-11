package com.sina.crm.enum_;

/**
 * @author caoshuai
 * @version 1.0
 */
public enum Planet {
    MERCURY(3.303e+23, 2.4397e6), // 水星
    VENUS(4.869e+24, 6.0518e6),  // 金星
    EARTH(5.976e+24, 6.37814e6); // 地球

    private final double mass;   // 质量
    private final double radius; // 半径

    // 枚举类的构造方法
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }

    // 计算行星表面的重力加速度
    public double surfaceGravity() {
        double G = 6.67300E-11; // 万有引力常数
        return G * mass / (radius * radius);
    }
}
