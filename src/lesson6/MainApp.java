package lesson6;

import java.util.Arrays;

public class MainApp {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        float[] arr = new float[SIZE];
        for (int i = 0; i < SIZE; ++i) {
            arr[i] = 1;
        }
        long startTime = System.currentTimeMillis();
        System.out.println("calculations time calculationsComplex = " + calculationsComplex(startTime, arr));
        long start = System.currentTimeMillis();
        System.out.println("calculations time calculationsSimple = " + calculationsSimple(start, arr));

    }

    public static long calculationsSimple(long start, float[] arr) {
        for (int i = 0; i < SIZE; ++i) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        }
        return (System.currentTimeMillis() - start);
    }

    public static long calculationsComplex(long start, float[] sourceArr) {
        float[] destArr1 = new float[HALF];
        float[] destArr2 = new float[HALF];
        System.arraycopy(sourceArr, 0, destArr1, 0, HALF);
        System.arraycopy(sourceArr, HALF, destArr2, 0, HALF);
/*
    Первым параметром является массив-источник.
    Вторым параметром является позиция начала нового массива.
    Третий параметр — массив-назначения.
    Четвертый параметр является начальным положением целевого массива.
 */
        Thread firstThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < HALF; ++i) {
                    destArr1[i] = (float) (destArr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                            Math.cos(0.4f + i / 2));
                }
            }

        });
        Thread secondThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < HALF; ++i) {
                    destArr2[i] = (float) (destArr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                            Math.cos(0.4f + i / 2));
                }
            }

        });
        firstThread.start();
        secondThread.start();
        try {
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // посчитали -> потом склеиваем
        System.arraycopy(destArr1, 0, sourceArr, 0, HALF);
        System.arraycopy(destArr2, 0, sourceArr, HALF, HALF);
        /*
         Первым параметром является массив-источник.
         Вторым параметром является позиция начала нового массива sourceArr.
         Третий параметр — массив-назначения.
         Четвертый параметр является начальным положением целевого массива sourceArr.
        */
        return (System.currentTimeMillis() - start);
    }

}
