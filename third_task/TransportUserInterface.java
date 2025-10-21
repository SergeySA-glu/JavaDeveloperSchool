import java.util.*;

public class TransportUserInterface {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Transport> transports = new ArrayList<>();

    public static void main(String[] args) {
        try {
            System.out.println("=== Система управления транспортом ===\n");

            // Создаем несколько видов транспорта
            createSampleTransports();

            boolean running = true;
            while (running) {
                try {
                    printMenu();
                    int choice = getIntInput("Выберите действие: ");

                    switch (choice) {
                        case 1 -> showAllTransports();
                        case 2 -> createCustomTransport();
                        case 3 -> operateTransport();
                        case 4 -> running = false;
                        default -> System.out.println("Неверный выбор! Введите число от 1 до 4.");
                    }
                } catch (Exception e) {
                    System.out.println("Ошибка: " + e);
                }
            }

            System.out.println("Программа завершена.");
        } catch (Exception e) {
            System.out.println("Критическая ошибка: " + e);
        } finally {
            try {
                scanner.close();
            } catch (Exception ignored) { }
        }
    }

    private static void createSampleTransports() {
        try {
            Car car = new Car("Model S", "Tesla", 250, 5);
            car.setEngine(new Engine(670, FuelType.ELECTRIC));
            transports.add(car);
        } catch (Exception e) {
            System.out.println("Не удалось создать пример автомобиля: " + e);
        }

        try {
            Bicycle bicycle = new Bicycle("Горный", 35);
            transports.add(bicycle);
        } catch (Exception e) {
            System.out.println("Не удалось создать пример велосипеда: " + e);
        }

        try {
            Airplane airplane = new Airplane("Boeing 747", 988, 13750, 68.4, 416);
            airplane.setEngine(new Engine(57000, FuelType.KEROSENE));
            transports.add(airplane);
        } catch (Exception e) {
            System.out.println("Не удалось создать пример самолёта: " + e);
        }

        try {
            Ship ship = new Ship("Титаник", 42, 52310, 2435, 892);
            ship.setEngine(new Engine(50000, FuelType.DIESEL));
            transports.add(ship);
        } catch (Exception e) {
            System.out.println("Не удалось создать пример корабля: " + e);
        }

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
        if (transports.isEmpty()) {
            System.out.println("Транспорт отсутствует.");
            return;
        }
        for (int i = 0; i < transports.size(); i++) {
            try {
                System.out.println((i + 1) + ". " + transports.get(i).getInfo());
            } catch (Exception e) {
                System.out.println((i + 1) + ". (ошибка при получении информации: " + e + ")");
            }
        }
    }

    private static void createCustomTransport() {
        try {
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
                default -> System.out.println("Неверный выбор! Введите число 1-4.");
            }
        } catch (Exception e) {
            System.out.println("Ошибка: " + e);
        }
    }

    private static void createCar() {
        try {
            String name = getNonEmptyString("Введите название: ");
            String brand = getNonEmptyString("Введите марку: ");
            double speed = getPositiveDoubleInput("Введите макс. скорость: ");
            int passengers = getPositiveIntInput("Введите кол-во пассажиров: ");

            try {
                Car car = new Car(name, brand, speed, passengers);
                car.setEngine(createEngine());
                transports.add(car);
                System.out.println("Автомобиль создан!");
            } catch (Exception e) {
                System.out.println("Ошибка при создании автомобиля: " + e);
            }
        } catch (Exception e) {
            System.out.println("Ошибка ввода при создании автомобиля: " + e);
        }
    }

    private static void createBicycle() {
        try {
            String name = getNonEmptyString("Введите название: ");
            double speed = getPositiveDoubleInput("Введите макс. скорость: ");

            try {
                Bicycle bicycle = new Bicycle(name, speed);
                transports.add(bicycle);
                System.out.println("Велосипед создан!");
            } catch (Exception e) {
                System.out.println("Ошибка при создании велосипеда: " + e);
            }
        } catch (Exception e) {
            System.out.println("Ошибка ввода при создании велосипеда: " + e);
        }
    }

    private static void createAirplane() {
        try {
            String name = getNonEmptyString("Введите название: ");
            double speed = getPositiveDoubleInput("Введите макс. скорость: ");
            double altitude = getPositiveDoubleInput("Введите макс. высоту: ");
            double wingspan = getPositiveDoubleInput("Введите размах крыльев: ");
            int passengers = getPositiveIntInput("Введите кол-во пассажиров: ");

            try {
                Airplane airplane = new Airplane(name, speed, altitude, wingspan, passengers);
                airplane.setEngine(createEngine());
                transports.add(airplane);
                System.out.println("Самолет создан!");
            } catch (Exception e) {
                System.out.println("Ошибка при создании самолета: " + e);
            }
        } catch (Exception e) {
            System.out.println("Ошибка ввода при создании самолета: " + e);
        }
    }

    private static void createShip() {
        try {
            String name = getNonEmptyString("Введите название: ");
            double speed = getPositiveDoubleInput("Введите макс. скорость: ");
            double displacement = getPositiveDoubleInput("Введите водоизмещение: ");
            int passengers = getPositiveIntInput("Введите кол-во пассажиров: ");
            int crew = getPositiveIntInput("Введите кол-во экипажа: ");

            try {
                Ship ship = new Ship(name, speed, displacement, passengers, crew);
                ship.setEngine(createEngine());
                transports.add(ship);
                System.out.println("Корабль создан!");
            } catch (Exception e) {
                System.out.println("Ошибка при создании корабля: " + e);
            }
        } catch (Exception e) {
            System.out.println("Ошибка ввода при создании корабля: " + e);
        }
    }

    private static Engine createEngine() {
        while (true) {
            try {
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
                    default -> {
                        System.out.println("Неверный выбор, используется бензин.");
                        yield FuelType.PETROL;
                    }
                };

                double power = getPositiveDoubleInput("Введите мощность (л.с.): ");
                try {
                    return new Engine(power, fuelType);
                } catch (Exception e) {
                    System.out.println("Ошибка при создании двигателя: " + e);
                    // повторить ввод
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода двигателя: " + e);
            }
        }
    }

    private static void operateTransport() {
        try {
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

            System.out.println("\n=== Управление: " + safeString(transport.getName()) + " ===");
            System.out.println("1. Двигаться");
            System.out.println("2. Остановиться");
            System.out.println("3. Информация");

            int action = getIntInput("Выберите действие: ");

            switch (action) {
                case 1 -> {
                    try {
                        System.out.println(transport.move());
                    } catch (Exception e) {
                        System.out.println("Ошибка при движении: " + e);
                    }
                }
                case 2 -> {
                    try {
                        System.out.println(transport.stop());
                    } catch (Exception e) {
                        System.out.println("Ошибка при остановке: " + e);
                    }
                }
                case 3 -> {
                    try {
                        System.out.println(transport.getInfo());
                    } catch (Exception e) {
                        System.out.println("Ошибка при получении информации: " + e);
                    }
                }
                default -> System.out.println("Неверное действие! Введите число 1-3.");
            }
        } catch (Exception e) {
            System.out.println("Ошибка в управлении транспортом: " + e);
        }
    }

    // --- безопасный ввод и валидация ---

    private static String safeReadLine() {
        try {
            if (scanner == null) 
                return "";
                
            String line = scanner.nextLine();
            return line == null ? "" : line;
        } catch (NoSuchElementException | IllegalStateException e) {
            return "";
        } catch (Exception e) {
            return "";
        }
    }

    private static String getNonEmptyString(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String line = safeReadLine().trim();
                if (line.isEmpty()) {
                    System.out.println("Ввод не может быть пустым. Попробуйте снова.");
                    continue;
                }
                return line;
            } catch (Exception e) {
                System.out.println("Ошибка ввода строки: " + e);
            }
        }
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String line = safeReadLine().trim();
                if (line.isEmpty()) {
                    System.out.println("Ввод не может быть пустым. Попробуйте снова.");
                    continue;
                }
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Введите корректное целое число.");
            } catch (Exception e) {
                System.out.println("Ошибка ввода целого числа: " + e);
            }
        }
    }

    private static int getPositiveIntInput(String prompt) {
        while (true) {
            int val = getIntInput(prompt);
            if (val <= 0) {
                System.out.println("Значение должно быть положительным числом.");
                continue;
            }
            return val;
        }
    }

    private static double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String line = safeReadLine().trim();
                if (line.isEmpty()) {
                    System.out.println("Ввод не может быть пустым. Попробуйте снова.");
                    continue;
                }
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Введите корректное число.");
            } catch (Exception e) {
                System.out.println("Ошибка ввода числа: " + e);
            }
        }
    }

    private static double getPositiveDoubleInput(String prompt) {
        while (true) {
            double val = getDoubleInput(prompt);
            if (Double.isNaN(val) || Double.isInfinite(val) || val <= 0) {
                System.out.println("Значение должно быть конечным положительным числом.");
                continue;
            }
            return val;
        }
    }

    private static String safeString(String s) {
        return s == null ? "" : s;
    }
}