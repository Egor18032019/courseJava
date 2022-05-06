package lesson4;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        GenerikBox<String> strBox = new GenerikBox<>("JAva");
        GenerikBox<Integer> strBox2 = new GenerikBox<>(11);
        GenerikBox<Integer> strBox3 = new GenerikBox<>(22);
        strBox2.setObj(2);
        int sum = strBox2.getObj() + strBox3.getObj();
        System.out.println(sum);
        NumberBox<Integer> intBox = new NumberBox<>(1, 2, 3, 4, 5);
        NumberBox<Integer> intBox2 = new NumberBox<>(1, 2, 3, 4, 5);
        System.out.println(intBox.average());
        System.out.println(intBox.compareAverage(intBox2));
        doSomething1(strBox2);
    }

    public static void doSomething1(GenerikBox<? extends Number> box) {

    }

    public static void doSomething2(GenerikBox<Number> box) {

    }

    public  <T> T doSomethingGen(List <T> list) {
        return list.get(0);
    }
    public  <N extends Number> NumberBox<N> doSomethingGen(NumberBox<N> box) {
        return box.doSomethingGen(box);
    }
}
