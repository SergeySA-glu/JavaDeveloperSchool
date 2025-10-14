package fourth_task;

public class ObserverDemo {
    public static void main(String[] args) {
        ObservableStringBuilder osb = new ObservableStringBuilder();

        // Добавляем двух наблюдателей
        Observer observer1 = new MyObserver();
        osb.addObserver(observer1);

        Observer observer2 = new Observer() {
            @Override
            public void onChange(String newValue) {
                System.out.println("Anonymous Observer: состояние изменилось на -> " + newValue);
            }
        };
        osb.addObserver(observer2);

        // Работа с объектом
        osb.append("Hello");
        osb.append(", ");
        osb.append("World!");
        osb.delete(5, 7);
        osb.insert(5, " wonderful ");
        osb.reverse();
    }
}