public abstract sealed class Transport implements HasEngine
    permits GroundTransport, AirTransport, WaterTransport {
    
    protected final String name;
    protected final double maxSpeed;
    protected final TransportType transportType;
    protected Engine engine;
    
    public Transport(String name, double maxSpeed, TransportType transportType) {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.transportType = transportType;
    }
    
    // Абстрактные методы
    public abstract String move();
    public abstract String stop();
    
    // Общие методы
    public String getInfo() {
        String engineInfo = (engine != null) ? ", " + engine.toString() : ", без двигателя";
        return String.format("%s: %s, макс. скорость: %.1f км/ч%s", 
                           transportType, name, maxSpeed, engineInfo);
    }
    
    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    
    // Геттеры
    public String getName() { return name; }
    public double getMaxSpeed() { return maxSpeed; }
    public TransportType getTransportType() { return transportType; }
    public Engine getEngine() { return engine; }
}
