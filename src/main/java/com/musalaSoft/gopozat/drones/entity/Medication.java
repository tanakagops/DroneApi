/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.musalaSoft.gopozat.drones.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
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
public class Medication {
       
   
   //    @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
  //  Long medId;
    @Column(nullable = false)
    @Pattern(regexp = "([A-Za-z0-9\\-\\_]+)",message="Allowed only letters,number,'-,''_")
    private String name;
    
     @Column(nullable = false)
    private int weight;
    
    @Id
    @Column(nullable = false)
    @Pattern(regexp = "([A-Z0-9\\_]+),message=\"Allowed only upper case letters,underscore and numbers")            
    private String code;
    
    @Column(nullable = false)
    private String image;
    
    
}
