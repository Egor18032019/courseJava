package lesson2;

public class MainApp {

    public static void main(String[] args) {
        Flyable[] flyables = {
                new Duck(),
                new Airplane()
        };
        for (Flyable f : flyables) {
            f.fly();
        }
        Flyable somethingFlyable = new Duck();
        somethingFlyable.fly();


    }
}
