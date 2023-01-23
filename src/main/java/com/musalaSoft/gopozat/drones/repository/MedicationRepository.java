/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.musalaSoft.gopozat.drones.repository;

import com.musalaSoft.gopozat.drones.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gopozat
 */
@Repository
public interface MedicationRepository extends JpaRepository <Medication,String> {

    public Medication getByCode(String code);
    
}
