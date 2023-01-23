package com.musalaSoft.gopozat.drones.controller;

import com.musalaSoft.gopozat.drones.entity.Drone;
import com.musalaSoft.gopozat.drones.entity.LoadedMedicationItem;
import com.musalaSoft.gopozat.drones.entity.Medication;
//import com.musalaSoft.gopozat.drones.repository.MedicationRepository;
import com.musalaSoft.gopozat.drones.services.DroneServices;
//import com.musalaSoft.gopozat.drones.services.MedicationServices;//giving problems
import com.musalaSoft.gopozat.drones.services.LoadedMedicationItemServices;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gopozat
 */
@RestController
/*@RequestMapping( value="/drone",
                consumes= MediaType.APPLICATION_JSON_VALUE,
                produces=MediaType.APPLICATION_JSON_VALUE)*/
//@RequestMapping("/drone")
@Slf4j
public class DroneController {

    @Autowired
    DroneServices droneServices;

    @Autowired
    LoadedMedicationItemServices loadedMedicationItemServices;

        
    //Registering Drone
    @PostMapping("/addDrone")
    public ResponseEntity addDrone(@RequestBody Drone drone) {
        droneServices.RegisterDrone(drone);
        return new ResponseEntity<String>("Drone Created successful", HttpStatus.CREATED);
    }

    //Loading a drone with medication items    
    @PostMapping("/loadDrone/{droneId}/{medId}")
    public ResponseEntity loadDrone(@PathVariable("droneId") String serialNumber,
                                    @PathVariable("medId") String code) {
        loadedMedicationItemServices.loadDrone(serialNumber,code);
        return new ResponseEntity<String>("Medication Loaded", HttpStatus.CREATED);
     }
    
    
      //Checking loaded medication items for given drone
     @GetMapping("/drone/{serialNumber}/medication")
     public List<Medication> getMedicationForDrone(@PathVariable("serialNumber") String serialNumber ){
     return loadedMedicationItemServices.getloadedMedication(serialNumber);
        
     }

   
        //Checking available drone for loading
     @GetMapping("/drone/checkDrone/{state}")
     public List<Drone> getAvailableDrone(@PathVariable("state") String state ){
      return droneServices.getAvailableDrones(state);
     }
    
       //Checking available drone for loading
     @GetMapping("/drone/batteryLevel/{serialNumber}")
     public String getBatterLevel(@PathVariable("serialNumber") String serialNumber ){
      Drone drone= droneServices.getBySerialNumber(serialNumber);
       return " Battery Capacity of drone "+ drone.getBatteryCapacity();
     }
     
     
     
    @GetMapping("/checkDrone")
    public List<Drone> listAll() {
        return droneServices.CheckAllDrones();
    }
    
    //every 5 seconds
    @Scheduled(cron = "*/5 * * * * *")
    public void batteryLevelAudit(){
    List<Drone> drones=droneServices.CheckAllDrones();
    for(Drone drone:drones ){
        log.info("@@@@@@@@@@Drone: " +drone.getSerialNumber()+ " battery level is %d"+drone.getBatteryCapacity());
    }
    }
      
}
