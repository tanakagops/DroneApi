/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.musalaSoft.gopozat.drones.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

/**
 *
 * @author gopozat
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoadedMedicationItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long loadMedItemId;
    String serialNumber;
    String code;

}
