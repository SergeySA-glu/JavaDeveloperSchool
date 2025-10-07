public sealed abstract class GroundTransport extends Transport
    permits Car, Bicycle {
    
    protected final int wheelCount;
    
    public GroundTransport(String name, double maxSpeed, TransportType type, int wheelCount) {
        super(name, maxSpeed, type);
        this.wheelCount = wheelCount;
    }
    
    @Override
    public String move() {
        String engineStatus = (engine != null) ? ", " + engine.start() : "";
        return name + " начинает движение по дороге" + engineStatus;
    }
    
    @Override
    public String stop() {
        String engineStatus = (engine != null) ? ", " + engine.stop() : "";
        return name + " останавливается" + engineStatus;
    }
    
    @Override
    public String getInfo() {
        String baseInfo = super.getInfo();
        return baseInfo + ", колес: " + wheelCount;
    }
    
    public int getWheelCount() { return wheelCount; }
}
