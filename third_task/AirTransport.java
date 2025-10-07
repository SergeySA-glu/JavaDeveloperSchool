public sealed abstract class AirTransport extends Transport
    permits Airplane {
    
    protected final double maxAltitude;
    
    public AirTransport(String name, double maxSpeed, TransportType type, double maxAltitude) {
        super(name, maxSpeed, type);
        this.maxAltitude = maxAltitude;
    }
    
    @Override
    public String move() {
        return name + " взлетает, " + engine.start();
    }
    
    @Override
    public String stop() {
        return name + " приземляется, " + engine.stop();
    }
    
    @Override
    public String getInfo() {
        String baseInfo = super.getInfo();
        return baseInfo + ", макс. высота: " + maxAltitude + " м";
    }
    
    public double getMaxAltitude() { return maxAltitude; }
}
