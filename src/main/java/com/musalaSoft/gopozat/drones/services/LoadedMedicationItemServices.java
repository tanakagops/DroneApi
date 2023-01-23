/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.musalaSoft.gopozat.drones.services;

import com.musalaSoft.gopozat.drones.entity.Drone;
import com.musalaSoft.gopozat.drones.entity.LoadedMedicationItem;
import com.musalaSoft.gopozat.drones.entity.Medication;
import com.musalaSoft.gopozat.drones.repository.LoadedMedicationItemRepository;
import com.musalaSoft.gopozat.utilities.BatteryCheck;
import com.musalaSoft.gopozat.utilities.Messages;
import com.musalaSoft.gopozat.utilities.WeightCheck;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gopozat
 */
@Service
public class LoadedMedicationItemServices {

    @Autowired
    LoadedMedicationItemRepository lmirRepository;

    @Autowired
    DroneServices droneServices;

    @Autowired
    MedicationServices medicationServices;

    //Loading drone with medication
    public void loadDrone(String serialNumber, String code) {
        Drone drone=droneServices.getDrone(serialNumber);
        Medication medication=medicationServices.getMedicationByCode(code).get();
        if (Objects.isNull(drone)| Objects.isNull(medication)){
        throw new RuntimeException("Drone or Medication not found");
        }
          if (BatteryCheck.isEmpty(drone)){
             Messages.append("Battery level below 15%  ,Please charge \n");
          }       
          if (WeightCheck.isOverLoaded(drone,medication)){
             Messages.append("medication weight is more than drone can carry ,Please offload \n");
          } 
          if (!Messages.message.equalsIgnoreCase("")){
          throw new RuntimeException(Messages.message);
          }
        lmirRepository.loadMedication(serialNumber, code);
    }
    
    //Loading  medication for given drone
     public List<Medication> getloadedMedication(String serialNumber){
        List<LoadedMedicationItem> list=lmirRepository.findBySerialNumber(serialNumber);
        List<Medication> medList= new ArrayList<>();
        for (LoadedMedicationItem i: list){

              medList.add(medicationServices.getByCode(i.getCode()));

        } 
        return  medList;
     }

}
