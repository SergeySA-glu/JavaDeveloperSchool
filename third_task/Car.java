public final class Car extends GroundTransport {
    private final String brand;
    private final int passengerCapacity;
    
    public Car(String name, String brand, double maxSpeed, int passengerCapacity) {
        super(name, maxSpeed, TransportType.CAR, 4);
        this.brand = brand;
        this.passengerCapacity = passengerCapacity;
    }
    
    @Override
    public String getInfo() {
        return String.format("Автомобиль %s %s - %s, пассажиров: %d", 
                           brand, name, super.getInfo(), passengerCapacity);
    }
    
    public String getBrand() { return brand; }
    public int getPassengerCapacity() { return passengerCapacity; }
}
