package fourth_task;

public class MyObserver implements Observer {

    public MyObserver() {
    }

    @Override
    public void onChange(String newValue) {
        System.out.println("MyObserver: состояние изменилось на -> " + newValue);
    }
}
