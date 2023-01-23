package com.musalaSoft.gopozat.drones.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import javax.validation.constraints.Max;
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
public class Drone {

    @Id
    @Column(nullable = false)
    @Size(max = 100, message="Serial Number is 100 characters max")
    private String serialNumber;

    @Column(nullable = false)
    @Size(max = 500, message="Weight limit is 500gr max")
    private int weightLimit;
    
    @Column(nullable = false)
    @Max(100)
    private int batteryCapacity;
        
    private State state;
    private Model model;
    
    
    
    private enum State {
        IDLE,
        LOADING,
        LOADED,
        DELIVERING,
        DELIVERED,
        RETURNED

    }
    private enum Model {
        Lightweight,
        Middleweight,
        Cruiseweight,
        Heavyweight
    }
    
}
