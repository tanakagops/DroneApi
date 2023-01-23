/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.musalaSoft.gopozat.utilities;

import com.musalaSoft.gopozat.drones.entity.Drone;

/**
 *
 * @author gopozat
 */
public class BatteryCheck {
    
    public static boolean isEmpty(Drone drone){
        if (drone.getBatteryCapacity()<25){
        return true;
        }
        return false;
    }
}
