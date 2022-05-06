package lesson2;

public interface SuperFlyable extends Flyable {
    default void superFly() {
        System.out.println("+ летит");
    }
}
