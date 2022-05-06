package lesson7;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;

public class Car implements Runnable {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;
    private CyclicBarrier cyclicBarrier;
    private Lock lockFinish;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CyclicBarrier cyclicBarrier, Lock lockFinish) {
        this.race = race;
        this.cyclicBarrier = cyclicBarrier;
        this.lockFinish = lockFinish;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            cyclicBarrier.await();
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Что бы все стартанули после обьявленя ставим проверку на барьер
        if (!cyclicBarrier.isBroken()) {
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }
        }

        // проверяем и лочим
        if (lockFinish.tryLock()) {
            System.out.println("ПЕРВЫМ К ФИНИШУ ПРИХОДИТ " + this.name);
        }

    }
}
