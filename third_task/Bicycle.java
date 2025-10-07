public final class Bicycle extends GroundTransport {
    
    public Bicycle(String name, double maxSpeed) {
        super(name, maxSpeed, TransportType.BICYCLE, 2);
    }
    
    @Override
    public String move() {
        return name + " начинает движение с помощью педалей";
    }
    
    @Override
    public String stop() {
        return name + " останавливается";
    }
    
    @Override
    public String getInfo() {
        return "Велосипед - " + super.getInfo();
    }
}
