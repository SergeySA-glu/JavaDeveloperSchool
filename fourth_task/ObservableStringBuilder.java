package fourth_task;

import java.util.ArrayList;
import java.util.List;

class ObservableStringBuilder {
    private final StringBuilder sb = new StringBuilder();
    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        String currentValue = sb.toString();
        for (Observer observer : observers) {
            observer.onChange(currentValue);
        }
    }

    // --- Методы, делегирующие вызовы стандартному StringBuilder ---
    public ObservableStringBuilder append(String str) {
        sb.append(str);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder append(char c) {
        sb.append(c);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder insert(int offset, String str) {
        sb.insert(offset, str);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder delete(int start, int end) {
        sb.delete(start, end);
        notifyObservers();
        return this;
    }

    public ObservableStringBuilder reverse() {
        sb.reverse();
        notifyObservers();
        return this;
    }

    public int length() {
        return sb.length();
    }

    public String toString() {
        return sb.toString();
    }
}
