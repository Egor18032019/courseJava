package lesson7;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HomeWorkLesson7Threading {
    public static final int CARS_COUNT = CLASS_CONST.CARS_COUNT;

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
         System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        // делаем защелку
        CyclicBarrier cyclicBarrier = new CyclicBarrier(CARS_COUNT + 1); // +1 это для майнапотока
        // делаем замочек для финиша
        Lock lockFinish = new ReentrantLock();

        // создаем массив потоков
        Thread[] threadsArray = new Thread[CARS_COUNT];
        //  в массив Cars складываем машинки с рандомными показателями
        // +  в машинку передаем защёлку + барьер и вызываем их внутри класса
        for (int i = 0; i < CARS_COUNT; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cyclicBarrier,lockFinish);
        // тут мы должны в каждый поток передать машинку которая едет по трасе
        // (расчет трасы в классе Car)
            Thread thread = new Thread(cars[i]);
            thread.start();
            threadsArray[i] = thread;
        }

        try {
            cyclicBarrier.await();
            // что бы когда защелка cyclicBarrier упал
            // и последний закончивший не стартанул до обьявления
            // в Car ставим проверку на барьер
            //  и это не помогает
            // ставим после обьявления еще один барьер
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < CARS_COUNT; i++)
            try {
            threadsArray[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }


}
