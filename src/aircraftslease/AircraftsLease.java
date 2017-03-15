package aircraftslease;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AircraftsLease {
    // Properties --------------------------------------------------------------
    public static final String NAME = "Greek AirTaxi Network";
    public static final String SUBJECT = "Aircraft Lease";
    public static final String ADDRESS = "Plaza Mall, 39th Aggelou Metaxa str., Glifada, 166 74, Athens";
    public static final String TELEPHONE = "2109967870";
    public static final String WEBSITE = "http://www.greekairtaxinetwork.gr/";
    public static final String WORKHOURS = "09:00 - 19:00";
    public static final String BASE1 = "Athens";
    public static final String BASE2 = "Rhodes";    
    
    // Methods
    public static void printCompanyData() {
        System.out.println("---- Company Contact Data ----");
        System.out.println(NAME + "\n" + SUBJECT + "\n" + ADDRESS + "\n" + TELEPHONE + "\n" + WEBSITE + "\n" + WORKHOURS);
        System.out.println("------------------------------" + "\n");
    }
    
    public static void printAircraft(Aircraft aircraft) {
        System.out.println("---- Aircraft Data ----");
        System.out.println(aircraft.getCategory() + "\n" + aircraft.getModel() + "\n" + aircraft.getManufacturer() + "\n" + aircraft.getEngine() + "\n" + aircraft.getCapacity() 
                + "\n" + aircraft.getBase() + "\n" + aircraft.getAvailable());
        System.out.println("-----------------------" + "\n");
    }
    
    public static void printLease(Lease lease) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("---- Lease " + lease.getId() + " Data ----");
        System.out.println(lease.getId() + "\n" + lease.getCustomerName() + "\n" + lease.getAircraftName() + "\n" + lease.getLocation() + "\n" + 
                sdf.format(lease.getRentDate().getTime()) + "\n" + sdf.format(lease.getReturnDate().getTime()) + "\n" + lease.getDays());
        System.out.println("-----------------------" + "\n");
    }
    
    // Converts Date to String
    public static Calendar stringToDate(String string) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar date = new GregorianCalendar();
        try {
            date.setTime(sdf.parse(string));
        } 
        catch (ParseException ex) {
            Logger.getLogger(Lease.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }
    
    // Checks Location and Days of lease
    public static boolean checkAvailability(String location, int days, ArrayList<Lease> leaseList, Aircraft aircraft, String date) {
        boolean bool = true;
        if (location == aircraft.getBase() && days <=10) {
            bool = checkDateAvailability(leaseList, aircraft, date);
        }
        else if (location != aircraft.getBase() && days <=10) {
            System.out.println("You can't lease a aircraft from a different location.\n");
            bool = false;
        }
        else if (location == aircraft.getBase() && days > 10) {
            System.out.println("You can't lease a aircraft more than ten days.\n");
            bool = false;
        }
        return bool;
    }
    
    // Checks Date availability
    public static boolean checkDateAvailability(ArrayList<Lease> leaseList, Aircraft aircraft, String date) {
        boolean bool = true;
        Calendar calendar = stringToDate(date);
        for (int i = 0; i < leaseList.size(); i++) {
            if (leaseList.get(i).getAircraftName() == aircraft.getModel()) {
                if ((calendar.compareTo(leaseList.get(i).getReturnDate())) == -1 && (calendar.compareTo(leaseList.get(i).getRentDate())) == 1) {
                    bool = false;
                    break;
                }
            }
        }        
        return bool;
    }
    
    // Overload
    // Checks Aircraft and Date availability 
    public static void checkAircraftAvailability(ArrayList<Aircraft> aircraftList, ArrayList<Lease> leaseList, String date) {
        for (int i = 0; i < aircraftList.size(); i++) {
            if (checkDateAvailability(leaseList, aircraftList.get(i), date) == true){ 
                printAircraft(aircraftList.get(i));
            }
        }
    }
    
    // Overload
    // Checks Aircraft and Date availability by Category
    public static void checkAircraftAvailability(ArrayList<Aircraft> aircraftList, ArrayList<Lease> leaseList, String date, String category) {
        for (int i = 0; i < aircraftList.size(); i++) {
            if (aircraftList.get(i).getCategory() == category) {
                if (checkDateAvailability(leaseList, aircraftList.get(i), date) == true){ 
                    printAircraft(aircraftList.get(i));
                }
            }    
        }
    }
    
    // Overload
    // Checks Aircraft and Date availability by Category and Location
    public static void checkAircraftAvailability(ArrayList<Aircraft> aircraftList, ArrayList<Lease> leaseList, String date, String category, String location) {
        for (int i = 0; i < aircraftList.size(); i++) {
            if (aircraftList.get(i).getCategory() == category && aircraftList.get(i).getBase() == location) {
                if (checkDateAvailability(leaseList, aircraftList.get(i), date) == true){ 
                    printAircraft(aircraftList.get(i));
                }
            }    
        }
    }
    
    // Checks Aircraft availability by seats Capacity
    public static void checkAvailabilityByCapacity(ArrayList<Aircraft> aircraftList, int seats) {
        for (int i = 0; i < aircraftList.size(); i++) {
            if (aircraftList.get(i).getCapacity() > 4) {
                System.out.println(aircraftList.get(i).getModel() + " - " + aircraftList.get(i).getCategory() + "\n");
            }
        }
    }
    
    // Checks the renters a specific date
    public static void checkRenters(ArrayList<Lease> leaseList, String date) {
        Calendar calendar = stringToDate(date);
        for (int i = 0; i < leaseList.size(); i++) {
            if (calendar.compareTo(leaseList.get(i).getReturnDate()) == -1 && (calendar.compareTo(leaseList.get(i).getRentDate())) == 1){ 
                System.out.println(leaseList.get(i).getCustomerName() + "\n");
            }
        }        
    }

    // Checks the renters a specific date
    public static void checkRenters(ArrayList<Lease> leaseList, String date, String location) {
        Calendar calendar = stringToDate(date);
        for (int i = 0; i < leaseList.size(); i++) {
            if (calendar.compareTo(leaseList.get(i).getReturnDate()) == -1 && (calendar.compareTo(leaseList.get(i).getRentDate())) == 1){ 
                if (leaseList.get(i).getLocation() == location) {
                System.out.println(leaseList.get(i).getCustomerName() + "\n");                    
                }
            }
        }        
    } 
    
    // Calculates the cost of Lease
    public static int calculateLease(int cost, int days) {
        return cost * days;
    }
    
    // Calculates the profit between two dates
    public static int calculateProfit(ArrayList<Lease> leaseList, String date1, String date2) {
        int sum = 0;
        Calendar calendar1 = stringToDate(date1);
        Calendar calendar2 = stringToDate(date2);
        for (int i = 0; i < leaseList.size(); i++) {
            if (calendar1.compareTo(leaseList.get(i).getRentDate()) == -1 && (calendar2.compareTo(leaseList.get(i).getReturnDate())) == 1){ 
            sum += leaseList.get(i).getTotalCost();
            }
        }
        return sum;
    }
        
    public static void main(String[] args) {
        // Objects -------------------------------------------------------------   
        ArrayList<Aircraft> AircraftsList = new ArrayList<>();
        ArrayList<Lease> LeasesList = new ArrayList<>();

        Jet jet1 = new Jet("Jet", "Lear Jet 35", "Bombardier", "Jet Aircraft", 7, BASE1, true);
        Jet jet2 = new Jet("Jet", "Challenger 604", "Bombardier", "Midsize Jet", 9, BASE2, true);

        Helicopter helicopter1 = new Helicopter("Helicopter", "407 GXP", "Bell", "C47B/8 turbine FADEC", 7, BASE1, true);
        Helicopter helicopter2 = new Helicopter("Helicopter", "206L4", "Bell", "C30P", 6, BASE2, true);

        LightAirplane lightAirplane1 = new LightAirplane("Light Airplane", "P.180 Avanti II", "Piaggio Aero", "Turboprop", 8, BASE1, true);
        LightAirplane lightAirplane2 = new LightAirplane("Light Airplane", "C 90", "Beechcraft King Air", "Twin Engine Turbo Prop", 6, BASE2, true);

        // Fill the ArrayList --------------------------------------------------
        AircraftsList.add(jet1);
        AircraftsList.add(jet2);
        AircraftsList.add(helicopter1);
        AircraftsList.add(helicopter2);
        AircraftsList.add(lightAirplane1);
        AircraftsList.add(lightAirplane2);
        
        System.out.println("Ο πελάτης John Pappas ενδιαφέρεται για τα στοιχεία της επιχείρησης.");
        printCompanyData();
        
        System.out.println("Ο πελάτης John Pappas ενοικιάζει αεροσκάφος Jet στην Αθήνα για δέκα ημέρες την 1/1/2017.");
        if (checkAvailability("Athens", 10, LeasesList, AircraftsList.get(0), "1/1/2017")) {
            Lease lease1 = new Lease(1, AircraftsList.get(0).getModel(), "John Pappas", "Athens", stringToDate("1/1/2017"), stringToDate("10/1/2017"), 10, 
                    AircraftsList.get(0).getPrice());
            LeasesList.add(lease1);
            printLease(lease1);
        }
        
        System.out.println("O πελάτης Γεωργίου Γεώργιος ενοικιάζει μικρό αεροσκάφος στην Ρόδο για δέκα ημέρες την 9/1/2017.");
        if (checkAvailability("Rhodes", 10, LeasesList, AircraftsList.get(5), "9/1/2017")) {
            Lease lease2 = new Lease(2, AircraftsList.get(5).getModel(), "Giorgos Georgiou", "Rhodes", stringToDate("9/1/2017"), stringToDate("18/1/2017"), 10, 
                    AircraftsList.get(5).getPrice());
            LeasesList.add(lease2);
            printLease(lease2);
        }
        
        System.out.println("O πελάτης Αθανασίου Αθανάσιος ενοικιάζει ελικόπτερο στην Αθήνα για πέντε ημέρες την 10/1/2017.");
        if (checkAvailability("Athens", 5, LeasesList, AircraftsList.get(2), "10/1/2017")) {
            Lease lease3 = new Lease(3, AircraftsList.get(2).getModel(), "Athanasios Athanasiou", "Athens", stringToDate("10/1/2017"), stringToDate("14/1/2017"), 5, 
                    AircraftsList.get(2).getPrice());
            LeasesList.add(lease3);
            printLease(lease3);
        }
        
        System.out.println("O πελάτης Αντωνίου Αντώνιος ενοικιάζει μικρό αεροσκάφος στην Αθήνα για δέκα ημέρες την 15/1/2017");
        if (checkAvailability("Athens", 10, LeasesList, AircraftsList.get(4), "15/1/2017")) {
            Lease lease4 = new Lease(4, AircraftsList.get(4).getModel(), "Athanasios Athanasiou", "Athens", stringToDate("15/1/2017"), stringToDate("25/1/2017"), 10, 
                    AircraftsList.get(4).getPrice());
            LeasesList.add(lease4);
            printLease(lease4);
        }
        
        System.out.println("Ο πελάτης Ιωάννης Ιωάννου ενδιαφέρεται να νοικιάσει οποιοδήποτε αεροσκάφος με τουλάχιστον 4 θέσεις σε οποιαδήποτε περιοχή.");
        checkAvailabilityByCapacity(AircraftsList, 4);
        
        System.out.println("Η επιχείρηση θέλει να δει τα διαθέσιμα προς ενοικίαση αεροσκάφη την 19/1/2017 (Μοντέλο και Κατηγορία).");
        checkAircraftAvailability(AircraftsList, LeasesList, "19/1/2017");
        
        System.out.println("Η επιχείρηση θέλει να δει τα διαθέσιμα προς ενοικίαση ελικόπτερα στην Αθήνα την 19/1/2017 (Μοντέλο και Κατηγορία).");
        checkAircraftAvailability(AircraftsList, LeasesList, "19/1/2017", "Helicopter", "Athens");
        
        System.out.println("Η επιχείρηση την 19/1/2017 θέλει να δει τα ονόματα των πελατών για αεροσκάφη που δεν είναι διαθέσιμα (δηλ. ενοικιάστηκαν) στην Ρόδο.");
        checkRenters(LeasesList, "19/1/2017", "Rhodes");
        
        System.out.println("Η επιχείρηση θέλει να δει τα έσοδα της για τον μήνα Ιανουάριο 2017.");
        System.out.println(calculateProfit(LeasesList, "12/12/2016", "1/2/2017") + "\n");
    }
    
}
