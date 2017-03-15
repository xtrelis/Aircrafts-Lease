package aircraftslease;

public abstract class Aircraft {    
    // Properties --------------------------------------------------------------
    private String category, model, manufacturer, engine, base;
    private int capacity, price;
    private boolean available;
    
    // Constructors ------------------------------------------------------------
    protected Aircraft() {};
    
    protected Aircraft(String category, String model, String manufacturer, String engine, int capacity, String base, boolean available) {
        this.category = category;
        this.model = model;
        this.manufacturer = manufacturer;
        this.engine = engine;
        this.capacity = capacity;
        this.base = base;
        this.available = available;
    }
    
    protected Aircraft(String category, String model, String manufacturer, String engine, int capacity,String base, boolean available, int price) {
        this.category = category;
        this.model = model;
        this.manufacturer = manufacturer;
        this.engine = engine;
        this.capacity = capacity;
        this.base = base;
        this.available = available;
        this.price = price;
    }
    
    // Setters -----------------------------------------------------------------    
    protected void setCategory(String category) {
        this.category = category;
    }
    
    protected void setModel(String model) {
        this.model = model;
    }
    
    protected void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    protected void setEngine(String engine) {
        this.engine = engine;
    }
    
    protected void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    protected void setBase(String base) {
        this.base = base;
    }
    
    protected void setAvailable(boolean available) {
        this.available = available;
    }
    
    protected void setPrice(int price) {
        this.price = price;
    }
    
    // Getters -----------------------------------------------------------------    
    protected String getCategory() {
        return category;
    }
    
    protected String getModel() {
        return model;
    }
    
    protected String getManufacturer() {
        return manufacturer;
    }
    
    protected String getEngine() {
        return engine;
    }
    
    protected int getCapacity() {
        return capacity;
    }
    
    protected String getBase() {
        return base;
    }
    
    protected boolean getAvailable() {
        return available;
    }
    
    protected int getPrice() {
        return price;
    }
}
