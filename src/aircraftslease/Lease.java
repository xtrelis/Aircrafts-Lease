package aircraftslease;
import java.text.ParseException;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import static java.util.Calendar.DAY_OF_MONTH;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lease {
    // Properties --------------------------------------------------------------
    private String aircraftName, customerName, location;
    Calendar rentDate;
    Calendar returnDate;
    int id, days, cost, totalCost;
    
    // Constructors ------------------------------------------------------------
    public Lease() {};
    
    public Lease(int id, String aircraftName, String customerName, String location, Calendar rentDate, Calendar returnDate, int days, int cost) {
        this.id = id;
        this.aircraftName = aircraftName;
        this.customerName = customerName;
        this.location = location;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.days = days;
        this.cost = cost;
        totalCost = cost * days;
    }
    
    // Getters -----------------------------------------------------------------
    
    public int getId() {
        return id;
    }
    public String getAircraftName() {
        return aircraftName;
    }
    
    public String getCustomerName() {
        return customerName;
    }
    
    public String getLocation() {
        return location;
    }
    
    public Calendar getRentDate() {
        return rentDate;
    }
    
    public Calendar getReturnDate() {
        return returnDate;
    }
    
    public int getDays() {
        return days;
    }
    
    public int getCost() {
        return cost;
    }
    
    public int getTotalCost() {
        return totalCost;
    }
}
