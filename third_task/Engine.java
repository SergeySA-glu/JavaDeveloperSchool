public class Engine {
    private final double power; // мощность в л.с.
    private final FuelType fuelType;
    private EngineState state;
    
    public Engine(double power, FuelType fuelType) {
        this.power = power;
        this.fuelType = fuelType;
        this.state = EngineState.STOPPED;
    }
    
    public String start() {
        this.state = EngineState.STARTED;
        return String.format("Двигатель запущен (%.1f л.с., %s)", power, fuelType);
    }
    
    public String stop() {
        this.state = EngineState.STOPPED;
        return "Двигатель остановлен";
    }
    
    // Геттеры
    public double getPower() { return power; }
    public FuelType getFuelType() { return fuelType; }
    public EngineState getState() { return state; }
    
    @Override
    public String toString() {
        return String.format("Двигатель %.1f л.с., %s, %s", power, fuelType, state);
    }
}

