/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.musalaSoft.gopozat.drones.repository;

import com.musalaSoft.gopozat.drones.entity.LoadedMedicationItem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author gopozat
 */
@Repository
public interface LoadedMedicationItemRepository extends JpaRepository<LoadedMedicationItem,Long> {


@Transactional    
@Modifying
@Query(value= "INSERT INTO loaded_medication_item( code,  serial_number) VALUES (?1,?2)",nativeQuery=true)
public void loadMedication(   String code, String serialNumber);   
 

public List<LoadedMedicationItem> findBySerialNumber(String serialNumber);




}