package fourth_task;

public class ObserverDemo {
    public static void main(String[] args) {
        try {
            ObservableStringBuilder observable = new ObservableStringBuilder();
            
            try {
                Observer observer1 = new MyObserver("Наблюдатель 1");
                Observer observer2 = new MyObserver("Наблюдатель 2");
                
                observable.attach(observer1);
                observable.attach(observer2);
                
                System.out.println("\nДобавляем текст:");
                observable.append("Привет, ");
                
                System.out.println("\nДобавляем еще текст:");
                observable.append("мир!");
                
                System.out.println("\nВставляем текст:");
                observable.insert(7, "чудесный ");
                
                System.out.println("\nУдаляем часть текста:");
                observable.delete(0, 7);
                
                System.out.println("\nРазворачиваем строку:");
                observable.reverse();
                
                observable.detach(observer2);
                
                System.out.println("\nПосле удаления второго наблюдателя:");
                observable.append(" :)");
                
            } catch (IllegalArgumentException e) {
                System.err.println("Ошибка при создании наблюдателя: " + e.getMessage());
            }
            
        } catch (Exception e) {
            System.err.println("Непредвиденная ошибка: " + e.getMessage());
        }
    }
}