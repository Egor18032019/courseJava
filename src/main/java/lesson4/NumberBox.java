package lesson4;

public class NumberBox<N extends Number> {
    private N[] array;

    public NumberBox(N... arr) {
        this.array = arr;
    }

    public double average() {
        double avg = 0.0;
        for (int i = 0; i < array.length; i++) {
            avg += array[i].doubleValue();
        }
        return avg / array.length;
    }

    public boolean compareAverage(NumberBox<?> anotherBox) { // если ? то можно любой тип, если N то только тип этой коробки
        return Math.abs(this.average() - anotherBox.average()) < 0.0001;
    }

    public NumberBox<N> doSomethingGen(NumberBox<N> box) {
        return box;
    }
}
