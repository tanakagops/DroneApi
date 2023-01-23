/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.musalaSoft.gopozat.utilities;

import com.musalaSoft.gopozat.drones.entity.Drone;
import com.musalaSoft.gopozat.drones.entity.Medication;

/**
 *
 * @author gopozat
 */
public class WeightCheck {
    
     public static Boolean isOverLoaded(Drone drone,Medication medication){
        if (drone.getWeightLimit() < medication.getWeight()){
        return true;
        }
        return false;
     }
}
