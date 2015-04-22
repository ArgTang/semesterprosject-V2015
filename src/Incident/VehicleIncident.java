package Incident;


import Objects.Vehicle;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by steinar on 27.03.2015.
 */
public class VehicleIncident extends Incident {

    List<Vehicle> vehicles;
    boolean carRent;
    int carRentcost;
    int daysofRentingCar; //todo: decide if List is better


    //temp constructor (for compile)
    public VehicleIncident(String incidentDescription, LocalDate dayOfIncident, String timeOfIncident) {
        super(incidentDescription, dayOfIncident, timeOfIncident);
    }
}
