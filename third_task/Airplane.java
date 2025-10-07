public final class Airplane extends AirTransport {
    private final double wingspan;
    private final int passengerCapacity;
    
    public Airplane(String name, double maxSpeed, double maxAltitude, 
                   double wingspan, int passengerCapacity) {
        super(name, maxSpeed, TransportType.AIRPLANE, maxAltitude);
        this.wingspan = wingspan;
        this.passengerCapacity = passengerCapacity;
    }
    
    @Override
    public String getInfo() {
        return String.format("Самолет - %s, размах крыльев: %.1f м, пассажиров: %d",
                           super.getInfo(), wingspan, passengerCapacity);
    }
    
    public double getWingspan() { return wingspan; }
    public int getPassengerCapacity() { return passengerCapacity; }
}
