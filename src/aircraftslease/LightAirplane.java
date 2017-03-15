package aircraftslease;

public class LightAirplane extends Aircraft {
    // Constructors ------------------------------------------------------------
    public LightAirplane() {};
    
    public LightAirplane(String category, String model, String manufacturer, String engineType, int seatsCapacity, String base, boolean available) {
        super(category, model, manufacturer, engineType, seatsCapacity, base, available);
        super.setPrice(200);
    }
}
