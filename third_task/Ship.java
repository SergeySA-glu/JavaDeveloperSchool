public final class Ship extends WaterTransport {
    private final int passengerCapacity;
    private final int crewCount;
    
    public Ship(String name, double maxSpeed, double displacement, 
               int passengerCapacity, int crewCount) {
        super(name, maxSpeed, TransportType.SHIP, displacement);
        this.passengerCapacity = passengerCapacity;
        this.crewCount = crewCount;
    }
    
    @Override
    public String getInfo() {
        return String.format("Корабль - %s, пассажиров: %d, экипаж: %d",
                           super.getInfo(), passengerCapacity, crewCount);
    }
    
    public int getPassengerCapacity() { return passengerCapacity; }
    public int getCrewCount() { return crewCount; }
}
