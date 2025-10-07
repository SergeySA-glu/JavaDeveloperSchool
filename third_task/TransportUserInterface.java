import java.util.*;

public class TransportUserInterface {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Transport> transports = new ArrayList<>();
    
    public static void main(String[] args) {
        System.out.println("=== Система управления транспортом ===\n");
        
        // Создаем несколько видов транспорта
        createSampleTransports();
        
        boolean running = true;
        while (running) {
            printMenu();
            int choice = getIntInput("Выберите действие: ");
            
            switch (choice) {
                case 1 -> showAllTransports();
                case 2 -> createCustomTransport();
                case 3 -> operateTransport();
                case 4 -> running = false;
                default -> System.out.println("Неверный выбор!");
            }
        }
        
        System.out.println("Программа завершена.");
    }
    
    private static void createSampleTransports() {
        // Автомобиль
        Car car = new Car("Model S", "Tesla", 250, 5);
        car.setEngine(new Engine(670, FuelType.ELECTRIC));
        transports.add(car);
        
        // Велосипед
        Bicycle bicycle = new Bicycle("Горный", 35);
        transports.add(bicycle);
        
        // Самолет
        Airplane airplane = new Airplane("Boeing 747", 988, 13750, 68.4, 416);
        airplane.setEngine(new Engine(57000, FuelType.KEROSENE));
        transports.add(airplane);
        
        // Корабль
        Ship ship = new Ship("Титаник", 42, 52310, 2435, 892);
        ship.setEngine(new Engine(50000, FuelType.DIESEL));
        transports.add(ship);
        
        System.out.println("Создано примеров транспорта: " + transports.size());
    }
    
    private static void printMenu() {
        System.out.println("\n=== Меню ===");
        System.out.println("1. Показать весь транспорт");
        System.out.println("2. Создать новый транспорт");
        System.out.println("3. Управлять транспортом");
        System.out.println("4. Выход");
    }
    
    private static void showAllTransports() {
        System.out.println("\n=== Весь транспорт ===");
        for (int i = 0; i < transports.size(); i++) {
            System.out.println((i + 1) + ". " + transports.get(i).getInfo());
        }
    }
    
    private static void createCustomTransport() {
        System.out.println("\n=== Создание транспорта ===");
        System.out.println("1. Автомобиль");
        System.out.println("2. Велосипед");
        System.out.println("3. Самолет");
        System.out.println("4. Корабль");
        
        int choice = getIntInput("Выберите тип транспорта: ");
        
        switch (choice) {
            case 1 -> createCar();
            case 2 -> createBicycle();
            case 3 -> createAirplane();
            case 4 -> createShip();
            default -> System.out.println("Неверный выбор!");
        }
    }
    
    private static void createCar() {
        System.out.print("Введите название: ");
        String name = scanner.nextLine();
        System.out.print("Введите марку: ");
        String brand = scanner.nextLine();
        double speed = getDoubleInput("Введите макс. скорость: ");
        int passengers = getIntInput("Введите кол-во пассажиров: ");
        
        Car car = new Car(name, brand, speed, passengers);
        car.setEngine(createEngine());
        transports.add(car);
        System.out.println("Автомобиль создан!");
    }
    
    private static void createBicycle() {
        System.out.print("Введите название: ");
        String name = scanner.nextLine();
        double speed = getDoubleInput("Введите макс. скорость: ");
        
        Bicycle bicycle = new Bicycle(name, speed);
        transports.add(bicycle);
        System.out.println("Велосипед создан!");
    }
    
    private static void createAirplane() {
        System.out.print("Введите название: ");
        String name = scanner.nextLine();
        double speed = getDoubleInput("Введите макс. скорость: ");
        double altitude = getDoubleInput("Введите макс. высоту: ");
        double wingspan = getDoubleInput("Введите размах крыльев: ");
        int passengers = getIntInput("Введите кол-во пассажиров: ");
        
        Airplane airplane = new Airplane(name, speed, altitude, wingspan, passengers);
        airplane.setEngine(createEngine());
        transports.add(airplane);
        System.out.println("Самолет создан!");
    }
    
    private static void createShip() {
        System.out.print("Введите название: ");
        String name = scanner.nextLine();
        double speed = getDoubleInput("Введите макс. скорость: ");
        double displacement = getDoubleInput("Введите водоизмещение: ");
        int passengers = getIntInput("Введите кол-во пассажиров: ");
        int crew = getIntInput("Введите кол-во экипажа: ");
        
        Ship ship = new Ship(name, speed, displacement, passengers, crew);
        ship.setEngine(createEngine());
        transports.add(ship);
        System.out.println("Корабль создан!");
    }
    
    private static Engine createEngine() {
        System.out.println("\n=== Создание двигателя ===");
        System.out.println("1. Бензин");
        System.out.println("2. Дизель");
        System.out.println("3. Электрический");
        System.out.println("4. Керосин");
        
        int fuelChoice = getIntInput("Выберите тип топлива: ");
        FuelType fuelType = switch (fuelChoice) {
            case 1 -> FuelType.PETROL;
            case 2 -> FuelType.DIESEL;
            case 3 -> FuelType.ELECTRIC;
            case 4 -> FuelType.KEROSENE;
            default -> FuelType.PETROL;
        };
        
        double power = getDoubleInput("Введите мощность (л.с.): ");
        return new Engine(power, fuelType);
    }
    
    private static void operateTransport() {
        if (transports.isEmpty()) {
            System.out.println("Нет доступного транспорта!");
            return;
        }
        
        showAllTransports();
        int index = getIntInput("Выберите транспорт для управления: ") - 1;
        
        if (index < 0 || index >= transports.size()) {
            System.out.println("Неверный индекс!");
            return;
        }
        
        Transport transport = transports.get(index);
        
        System.out.println("\n=== Управление: " + transport.getName() + " ===");
        System.out.println("1. Двигаться");
        System.out.println("2. Остановиться");
        System.out.println("3. Информация");
        
        int action = getIntInput("Выберите действие: ");
        
        switch (action) {
            case 1 -> System.out.println(transport.move());
            case 2 -> System.out.println(transport.stop());
            case 3 -> System.out.println(transport.getInfo());
            default -> System.out.println("Неверное действие!");
        }
    }
    
    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Введите целое число: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return value;
    }
    
    private static double getDoubleInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.print("Введите число: ");
            scanner.next();
        }
        double value = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        return value;
    }
}
