package Insurance.Vehicle;

import Insurance.Helper.PaymentOption;
import java.time.LocalDate;
import java.time.Year;

/**
 * Created by steinar on 27.03.2015.
 */
public final class Boat extends Vehicle
{
    private int knots, feet;
    String boattype;//seilbåt, innenbors eller utenborsmotor
    private String registrationnumber;

    public Boat(LocalDate validfrom, int itemValue, String insurancePolicy, PaymentOption paymentOption, String type, String model, Year productionYear, int kilometer, int horsePower, int knots, int feet, String boattype)
    {
        super(validfrom, itemValue, insurancePolicy, paymentOption, type, model, productionYear);

        //todo: if value > 50 000 registrationnumber required. here or in gui?
        this.knots = knots;
        this.feet = feet;
        this.boattype = boattype;
    }

    public int getKnots() { return knots; }
    public int getFeet() { return feet; }
    public void setRegistrationNumber(String registrationnumber) { this.registrationnumber = registrationnumber; }
}