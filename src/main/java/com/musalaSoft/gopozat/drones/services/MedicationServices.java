/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.musalaSoft.gopozat.drones.services;

import com.musalaSoft.gopozat.drones.entity.Drone;
import com.musalaSoft.gopozat.drones.entity.Medication;
import com.musalaSoft.gopozat.drones.repository.MedicationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gopozat
 */
@Service
public class MedicationServices {

    @Autowired
    MedicationRepository medicationRepository;
    
   // @Autowired
   // DroneServices droneServices;

      
    //Saving  medication 
    public Medication saveMedication(Medication medication) {
        return medicationRepository.save(medication);
    }
    
    //getting all medication 
    public List<Medication> getMedicationAll() {
        return medicationRepository.findAll();
    }
    
    
      //getting all medication by code
    public Optional<Medication> getMedicationByCode(String code) {
        return medicationRepository.findById(code);
    }
    
 
    Medication getByCode(String code) {
     return  medicationRepository.getByCode(code);
    }
}
