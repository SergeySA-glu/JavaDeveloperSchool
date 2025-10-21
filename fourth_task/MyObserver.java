package fourth_task;

public class MyObserver implements Observer {
    private String name;

    public MyObserver(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя наблюдателя не может быть пустым");
        }
        this.name = name;
    }

    @Override
    public void update(String message) throws IllegalArgumentException {
        if (message == null) {
            throw new IllegalArgumentException("Сообщение не может быть null");
        }
        try {
            System.out.printf("%s получил обновление: %s%n", name, message);
        } catch (Exception e) {
            System.err.println("Ошибка при выводе обновления: " + e.getMessage());
        }
    }
}