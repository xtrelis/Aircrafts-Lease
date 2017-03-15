package aircraftslease;

public class Helicopter extends Aircraft {
    // Constructors ------------------------------------------------------------
    public Helicopter() {};
    
    public Helicopter(String category, String model, String manufacturer, String engineType, int seatsCapacity, String base, boolean available) {
        super(category, model, manufacturer, engineType, seatsCapacity, base, available);
        super.setPrice(300);
    }
}
