/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.musalaSoft.gopozat.drones.repository;

import com.musalaSoft.gopozat.drones.entity.Drone;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gopozat
 */
@Repository
public interface DroneRepository extends JpaRepository<Drone,String> {
    
    public List<Drone> getByState(String state);

    public Drone getBySerialNumber(String serialNumber);

    
}
