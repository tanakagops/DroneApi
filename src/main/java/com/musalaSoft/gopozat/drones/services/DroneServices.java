/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.musalaSoft.gopozat.drones.services;

import com.musalaSoft.gopozat.drones.entity.Drone;
import com.musalaSoft.gopozat.drones.entity.Medication;
import com.musalaSoft.gopozat.drones.repository.DroneRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gopozat
 */
@Service
public class DroneServices {
    
    @Autowired
    DroneRepository droneRepository;
    
    //Create/Register Drone 
     public Drone RegisterDrone(Drone drone) {
        return droneRepository.save(drone);
    }
    
   
       
    //checking drone by serial number
    public Drone getDrone(String serialNumber){
    return droneRepository.getById(serialNumber);
        }



    public List<Drone> getAvailableDrones(String state) {
        return droneRepository.getByState(state);
    }

   
    
    //Check all Drones
    public List<Drone> CheckAllDrones(){
        return droneRepository.findAll();
     }

   

    public Drone getBySerialNumber(String serialNumber) {
          return droneRepository.getBySerialNumber(serialNumber);
    }
      
}
