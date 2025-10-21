import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
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

    // Безопасное чтение строки из Scanner — возвращает null при ошибке
    private String safeReadLine(Scanner scanner) {
        try {
            if (scanner == null) 
                return null;

            if (!scanner.hasNextLine()) 
                return null;
                
            return scanner.nextLine();
        } catch (IllegalStateException | NoSuchElementException e) {
            // Scanner закрыт или нет данных
            System.out.println("Ошибка ввода — невозможно прочитать строку.");
            return null;
        } catch (Exception e) {
            System.out.println("Неожиданная ошибка при чтении ввода.");
            return null;
        }
    }

    // Метод для получения размера массива
    public void getArraySizeFromScanner(Scanner scanner) {
        while (true) {
            System.out.println("Просьба ввести размер генерируемого массива чисел: ");
            String input = safeReadLine(scanner);
            if (input == null) {
                System.out.println("Ввод недоступен. Используется размер по умолчанию: " + getArraySize());
                return;
            }

            if (input.equalsIgnoreCase("exit")) {
                return;
            }

            try {
                int size = Integer.parseInt(input.trim());
                if (size > 0) {
                    setArraySize(size);
                    break;
                } else {
                    System.out.println("Размер массива должен быть положительным числом.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ожидалось целое число.");
            } catch (Exception e) {
                System.out.println("Ошибка при обработке размера массива. Попробуйте снова.");
            }
        }
    }

    // Метод для получения минимального значения
    public void getMinRandomFromScanner(Scanner scanner) {
        while (true) {
            System.out.println("Просьба ввести минимальное число, которое хотелось бы видеть в генерируемом массиве чисел: ");
            String input = safeReadLine(scanner);
            if (input == null) {
                System.out.println("Ввод недоступен. Используется минимальное значение по умолчанию: " + getMin());
                return;
            }

            if (input.equalsIgnoreCase("exit")) {
                return;
            }

            try {
                double minFromScanner = Double.parseDouble(input.trim());
                if (Double.isNaN(minFromScanner) || Double.isInfinite(minFromScanner)) {
                    System.out.println("Недопустимое числовое значение.");
                    continue;
                }
                setMin(minFromScanner);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ожидалось число.");
            } catch (Exception e) {
                System.out.println("Ошибка при обработке минимального значения. Попробуйте снова.");
            }
        }
    }

    // Метод для получения максимального значения
    public void getMaxRandomFromScanner(Scanner scanner) {
        while (true) {
            System.out.println("Просьба ввести максимальное число, которое хотелось бы видеть в генерируемом массиве чисел: ");
            String input = safeReadLine(scanner);
            if (input == null) {
                System.out.println("Ввод недоступен. Используется максимальное значение по умолчанию: " + getMax());
                return;
            }

            if (input.equalsIgnoreCase("exit")) {
                return;
            }

            try {
                double maxFromScanner = Double.parseDouble(input.trim());
                if (Double.isNaN(maxFromScanner) || Double.isInfinite(maxFromScanner)) {
                    System.out.println("Недопустимое числовое значение.");
                    continue;
                }
                if (maxFromScanner >= getMin()) {
                    setMax(maxFromScanner);
                    break;
                } else {
                    System.out.printf("Максимальное число должно быть больше минимального, то есть >= %.2f.\n", getMin());
                }
            } catch (NumberFormatException e) {
                System.out.println("Ожидалось число.");
            } catch (Exception e) {
                System.out.println("Ошибка при обработке максимального значения. Попробуйте снова.");
            }
        }
    }

    // Генерация массива случайных чисел
    public double[] generateArray() {
        try {
            if (arraySize <= 0) {
                System.out.println("Размер массива должен быть положительным числом");
                return new double[0];
            }

            // Проверки на корректность min/max
            if (Double.isNaN(min) || Double.isNaN(max)) {
                System.out.println("Некорректные границы диапазона. Используются значения по умолчанию.");
                min = 0;
                max = 1000000000;
            }
            if (Double.isInfinite(min) || Double.isInfinite(max)) {
                System.out.println("Границы диапазона бесконечны. Используются значения по умолчанию.");
                min = 0;
                max = 1000000000;
            }
            if (max < min) {
                System.out.println("Максимум меньше минимума — будут обменены значения.");
                double tmp = min;
                min = max;
                max = tmp;
            }

            double[] array = new double[arraySize];
            for (int i = 0; i < arraySize; i++) {
                array[i] = min + (max - min) * Math.random();
            }
            return array;
        } catch (OutOfMemoryError e) {
            System.out.println("Недостаточно памяти для создания массива нужного размера.");
            return new double[0];
        } catch (Exception e) {
            System.out.println("Неожиданная ошибка при генерации массива: " + e.getMessage());
            return new double[0];
        }
    }

    // Метод поиска максимума
    public int findMax(int[] array) {
        try {
            if (array == null || array.length == 0) {
                return 0;
            }
            int max = array[0];
            for (int i = 1; i < array.length; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
            }
            return max;
        } catch (Exception e) {
            System.out.println("Ошибка при поиске максимума (int[]): " + e.getMessage());
            return 0;
        }
    }

    // Перегрузка метода поиска максимума
    public double findMax(double[] array) {
        try {
            if (array == null || array.length == 0) {
                return 0;
            }
            double max = array[0];
            for (int i = 1; i < array.length; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
            }
            return max;
        } catch (Exception e) {
            System.out.println("Ошибка при поиске максимума (double[]): " + e.getMessage());
            return 0;
        }
    }

    public int findMin(int[] array) {
        try {
            if (array == null || array.length == 0) {
                return 0;
            }
            int min = array[0];
            for (int i = 1; i < array.length; i++) {
                if (array[i] < min) {
                    min = array[i];
                }
            }
            return min;
        } catch (Exception e) {
            System.out.println("Ошибка при поиске минимума (int[]): " + e.getMessage());
            return 0;
        }
    }

    // Перегрузка метода поиска минимума
    public double findMin(double[] array) {
        try {
            if (array == null || array.length == 0) {
                return 0;
            }
            double min = array[0];
            for (int i = 1; i < array.length; i++) {
                if (array[i] < min) {
                    min = array[i];
                }
            }
            return min;
        } catch (Exception e) {
            System.out.println("Ошибка при поиске минимума (double[]): " + e.getMessage());
            return 0;
        }
    }

    // Перегрузка метода вычисления среднего
    public double calculateAverage(double[] array) {
        try {
            if (array == null || array.length == 0) {
                return 0;
            }
            double sum = 0;
            for (double num : array) {
                sum += num;
            }
            return sum / array.length;
        } catch (Exception e) {
            System.out.println("Ошибка при вычислении среднего (double[]): " + e.getMessage());
            return 0;
        }
    }

    public double calculateAverage(int[] array) {
        try {
            if (array == null || array.length == 0) {
                return 0;
            }
            double sum = 0;
            for (int num : array) {
                sum += num;
            }
            return sum / array.length;
        } catch (Exception e) {
            System.out.println("Ошибка при вычислении среднего (int[]): " + e.getMessage());
            return 0;
        }
    }

    // Сортировка по возрастанию (метод пузырька)
    public void sortAscending(double[] array) {
        try {
            if (array == null || array.length <= 1) 
                return;

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
        } catch (Exception e) {
            System.out.println("Ошибка при сортировке (double[]): " + e.getMessage());
        }
    }

    public void sortAscending(int[] array) {
        try {
            if (array == null || array.length <= 1) 
                return;

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
        } catch (Exception e) {
            System.out.println("Ошибка при сортировке (int[]): " + e.getMessage());
        }
    }

    // Сортировка по убыванию (метод пузырька)
    public void sortDescending(double[] array) {
        try {
            if (array == null || array.length <= 1) 
                return;

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
        } catch (Exception e) {
            System.out.println("Ошибка при сортировке по убыванию (double[]): " + e.getMessage());
        }
    }

    public void sortDescending(int[] array) {
        try {
            if (array == null || array.length <= 1) 
                return;

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
        } catch (Exception e) {
            System.out.println("Ошибка при сортировке по убыванию (int[]): " + e.getMessage());
        }
    }

    // Метод завершения программы
    public void goodBye(Scanner scanner) {
        try {
            System.out.println("Программа завершена. До новых встреч! Для закрытия программы нажмите Enter.");
            if (scanner != null) {
                try {
                    if (scanner.hasNextLine()) 
                        scanner.nextLine();
                } catch (IllegalStateException | NoSuchElementException ignored) {
                    // Игнорируем — scanner уже закрыт или нет данных
                }
                try {
                    scanner.close();
                } catch (IllegalStateException ignored) { }
            }
        } catch (Exception e) {
            System.out.println("Ошибка при завершении программы.");
        }
    }

    // Точка входа в программу
    public static void main(String[] args) {
        App firstTaskApp = new App();
        String greeting = firstTaskApp.getGreeting();
        Scanner scanner = null;

        try {
            scanner = new Scanner(System.in);
            System.out.println(greeting);

            firstTaskApp.getArraySizeFromScanner(scanner);
            firstTaskApp.getMinRandomFromScanner(scanner);
            firstTaskApp.getMaxRandomFromScanner(scanner);

            double[] array = firstTaskApp.generateArray();

            if (array == null || array.length == 0) {
                System.out.println("Массив не был сгенерирован.");
                firstTaskApp.goodBye(scanner);
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
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: " + e.getMessage());
            firstTaskApp.goodBye(scanner);
        } catch (OutOfMemoryError e) {
            System.out.println("Недостаточно памяти: " + e.getMessage());
            firstTaskApp.goodBye(scanner);
        } catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
            firstTaskApp.goodBye(scanner);
        } finally {
            // Если scanner не был закрыт в goodBye — попытаться закрыть
            try {
                if (scanner != null) 
                    scanner.close();
            } catch (IllegalStateException ignored) { }
        }
    }
}
// ...existing code...