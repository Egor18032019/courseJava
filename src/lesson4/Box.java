package lesson4;

// для сортировки иплмнт Comparable
public class Box implements Comparable<Box> {
    public int size;

    public Box(int size) {
        this.size = size;
    }


    @Override
    public int compareTo(Box o) {
        return this.size - o.size;
    }
}
