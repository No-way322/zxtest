package com.zx.zxtest.abc;


import lombok.Data;

/**
 * 保存航点绑定的运行线路以及运行杆塔信息
 */
@Data
public class Dog {
    private int id;
    private String runTowerGuid;
    private String runLineGuid;
    private String routeGuid;
    private int pointIndex;
}
