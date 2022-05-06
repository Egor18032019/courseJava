package lesson7;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    // что бы тунель проезжали максимум две машины используем класс Semaphore
    Semaphore smp = new Semaphore( CLASS_CONST.CARS_COUNT/2);


    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                if(!smp.tryAcquire()){
                    System.out.println(c.getName() + " готовится к этапу(ждет): " +
                            description);
                    smp.acquire();
                }
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                smp.release();
                System.out.println(c.getName() + " закончил этап: " +
                        description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
