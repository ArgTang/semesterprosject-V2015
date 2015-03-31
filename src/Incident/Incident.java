package Incident;

import java.nio.file.Files;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Deque;
import Person.Person;

/**
 * Created by steinar on 27.03.2015.
 */
public abstract class Incident {

    final LocalDateTime timeOfReport;
    final LocalDate dayOfIncident; //todo: if string maybe just one string?
    final String timeOfIncident; //todo: string or Localtime? customer might give a timeframe
    private final long incidentID;
    private static long incidentIDCounter = 234567;
    //private type incidentType; // todo: move into the different incidents. make ENUM ?
    private String incidentDescription;
    private Deque<Files> pictures;
    private Deque<Person> witness;

    private int damageEstimate;
    private LocalDateTime timeOfPayout; //todo: make these an object? to get them final.
    private int payout;


    public Incident(String incidentDescription, LocalDate dayOfIncident, String timeOfIncident) {
        this.timeOfReport = LocalDateTime.now();
        this.incidentID = ++incidentIDCounter;
        this.incidentDescription = incidentDescription;
        this.dayOfIncident = dayOfIncident;
        this.timeOfIncident = timeOfIncident;
    }

    public Incident(String incidentDescription, LocalDate dayOfIncident, String timeOfIncident, ArrayDeque<Files> pictures, ArrayDeque<Person> witness) {
        this(incidentDescription, dayOfIncident, timeOfIncident);
        this.pictures = pictures;
        this.witness = witness;
    }

    public Incident(String incidentDescription, LocalDate dayOfIncident, String timeOfIncident, ArrayDeque<Files> pictures) {
        this(incidentDescription, dayOfIncident, timeOfIncident);
        this.pictures = pictures;
    }
}
