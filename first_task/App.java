import java.util.Arrays;
import java.util.Scanner;

public class App {
    public String getGreeting() {
        return "Приветствуем!";
    }

    private int arraySize = 0;
    public int getArraySize() {
        return arraySize;
    }
    public void setArraySize(int arraySize) {
        this.arraySize = arraySize;
    }

    private double min = 0;
    public double getMin() {
        return min;
    }
    public void setMin(double min) {
        this.min = min;
    }

    private double max = 1000000000;
    public double getMax() {
        return max;
    }
    public void setMax(double max) {
        this.max = max;
    }

    // Метод для получения размера массива
    public void getArraySizeFromScanner(Scanner scanner) {
        while (true) {
            System.out.println("Просьба ввести размер генерируемого массива чисел: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                return;
            }

            try {
                int size = Integer.parseInt(input);
                if (size > 0) {
                    setArraySize(size);
                    break;
                } else {
                    System.out.println("Размер массива должен быть положительным числом.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ожидалось целое число.");
            }
        }
    }

    // Метод для получения минимального значения
    public void getMinRandomFromScanner(Scanner scanner) {
        while (true) {
            System.out.println("Просьба ввести минимальное число, которое хотелось бы видеть в генерируемом массиве чисел: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                return;
            }

            try {
                double minFromScanner = Double.parseDouble(input);
                setMin(minFromScanner);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ожидалось число.");
            }
        }
    }

    // Метод для получения максимального значения
    public void getMaxRandomFromScanner(Scanner scanner) {
        while (true) {
            System.out.println("Просьба ввести максимальное число, которое хотелось бы видеть в генерируемом массиве чисел: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                return;
            }

            try {
                double maxFromScanner = Double.parseDouble(input);
                if (maxFromScanner >= getMin()) {
                    setMax(maxFromScanner);
                    break;
                } else {
                    System.out.printf("Максимальное число должно быть больше минимального, то есть >= %.2f.\n", getMin());
                }
            } catch (NumberFormatException e) {
                System.out.println("Ожидалось число.");
            }
        }
    }

    // Генерация массива случайных чисел
    public double[] generateArray() {
        if (arraySize <= 0) {
            System.out.println("Размер массива должен быть положительным числом");
            return new double[0];
        }

        double[] array = new double[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = min + (max - min) * Math.random();
        }
        return array;
    }

    // Метод поиска максимума
    public int findMax(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    // Перегрузка метода поиска максимума
    public double findMax(double[] array) {
        if (array.length == 0) {
            return 0;
        }
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public int findMin(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    // Перегрузка метода поиска минимума
    public double findMin(double[] array) {
        if (array.length == 0) {
            return 0;
        }
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    // Перегрузка метода вычисления среднего
    public double calculateAverage(double[] array) {
        if (array.length == 0) {
            return 0;
        }
        double sum = 0;
        for (double num : array) {
            sum += num;
        }
        return sum / array.length;
    }

    public double calculateAverage(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        double sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum / array.length;
    }

    // Сортировка по возрастанию (метод пузырька)
    public void sortAscending(double[] array) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    double temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    public void sortAscending(int[] array) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    // Сортировка по убыванию (метод пузырька)
    public void sortDescending(double[] array) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < array.length; i++) {
                if (array[i] > array[i - 1]) {
                    double temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    public void sortDescending(int[] array) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < array.length; i++) {
                if (array[i] > array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    // Метод завершения программы
    public void goodBye(Scanner scanner) {
        System.out.println("Программа завершена. До новых встреч! Для закрытия программы нажмите Enter.");
        scanner.nextLine(); // Ожидание ввода
    }

    // Точка входа в программу
    public static void main(String[] args) {
        App firstTaskApp = new App();
        String greeting = firstTaskApp.getGreeting();
        Scanner scanner = new Scanner(System.in);

        System.out.println(greeting);

        firstTaskApp.getArraySizeFromScanner(scanner);
        firstTaskApp.getMinRandomFromScanner(scanner);
        firstTaskApp.getMaxRandomFromScanner(scanner);

        double[] array = firstTaskApp.generateArray();

        if (array.length == 0) {
            System.out.println("Массив не был сгенерирован.");
            firstTaskApp.goodBye(scanner);
            scanner.close();
            return;
        }

        System.out.println("Максимальное значение: " + firstTaskApp.findMax(array));
        System.out.println("Минимальное значение: " + firstTaskApp.findMin(array));
        System.out.printf("Среднее значение: %.2f\n", firstTaskApp.calculateAverage(array));

        firstTaskApp.sortAscending(array);
        System.out.println("Отсортировано по возрастанию: " + Arrays.toString(array));

        firstTaskApp.sortDescending(array);
        System.out.println("Отсортировано по убыванию: " + Arrays.toString(array));

        firstTaskApp.goodBye(scanner);
        scanner.close();
    }
}
