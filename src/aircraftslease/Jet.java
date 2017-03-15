package aircraftslease;

public class Jet extends Aircraft {
    // Constructors ------------------------------------------------------------
    public Jet() {};
    
    public Jet(String category, String model, String manufacturer, String engineType, int seatsCapacity, String base, boolean available) {
        super(category, model, manufacturer, engineType, seatsCapacity, base, available);
        super.setPrice(500);
    }
}
