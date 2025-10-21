package fourth_task;

import java.util.ArrayList;
import java.util.List;

public class ObservableStringBuilder {
    private StringBuilder stringBuilder;
    private List<Observer> observers;

    public ObservableStringBuilder() {
        stringBuilder = new StringBuilder();
        observers = new ArrayList<>();
    }

    public void attach(Observer observer) {
        try {
            if (observer == null) {
                throw new IllegalArgumentException("Observer не может быть null");
            }
            if (!observers.contains(observer)) {
                observers.add(observer);
            }
        } catch (Exception e) {
            System.err.println("Ошибка при добавлении observer: " + e.getMessage());
        }
    }

    public void detach(Observer observer) {
        try {
            if (observer == null) {
                throw new IllegalArgumentException("Observer не может быть null");
            }
            observers.remove(observer);
        } catch (Exception e) {
            System.err.println("Ошибка при удалении observer: " + e.getMessage());
        }
    }

    private void notifyObservers() {
        String message = stringBuilder.toString();
        for (Observer observer : observers) {
            try {
                observer.update(message);
            } catch (Exception e) {
                System.err.println("Ошибка при оповещении observer: " + e.getMessage());
            }
        }
    }

    public void append(String str) {
        try {
            if (str == null) {
                throw new IllegalArgumentException("Строка не может быть null");
            }
            stringBuilder.append(str);
            notifyObservers();
        } catch (Exception e) {
            System.err.println("Ошибка при добавлении строки: " + e.getMessage());
        }
    }

    public void delete(int start, int end) {
        try {
            if (start < 0 || end > stringBuilder.length() || start > end) {
                throw new IllegalArgumentException("Неверные индексы для удаления");
            }
            stringBuilder.delete(start, end);
            notifyObservers();
        } catch (Exception e) {
            System.err.println("Ошибка при удалении: " + e.getMessage());
        }
    }

    public void insert(int offset, String str) {
        try {
            if (str == null) {
                throw new IllegalArgumentException("Строка не может быть null");
            }
            if (offset < 0 || offset > stringBuilder.length()) {
                throw new IllegalArgumentException("Неверный индекс для вставки");
            }
            stringBuilder.insert(offset, str);
            notifyObservers();
        } catch (Exception e) {
            System.err.println("Ошибка при вставке: " + e.getMessage());
        }
    }

    public void reverse() {
        try {
            stringBuilder.reverse();
            notifyObservers();
        } catch (Exception e) {
            System.err.println("Ошибка при развороте строки: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}