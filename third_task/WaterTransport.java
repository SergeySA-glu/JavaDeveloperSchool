public sealed abstract class WaterTransport extends Transport
    permits Ship {
    
    protected final double displacement;
    
    public WaterTransport(String name, double maxSpeed, TransportType type, double displacement) {
        super(name, maxSpeed, type);
        this.displacement = displacement;
    }
    
    @Override
    public String move() {
        return name + " отплывает, " + engine.start();
    }
    
    @Override
    public String stop() {
        return name + " пришвартовывается, " + engine.stop();
    }
    
    @Override
    public String getInfo() {
        String baseInfo = super.getInfo();
        return baseInfo + ", водоизмещение: " + displacement + " т";
    }
    
    public double getDisplacement() { return displacement; }
}
