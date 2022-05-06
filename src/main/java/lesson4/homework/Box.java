package lesson4.homework;

import java.util.ArrayList;
import java.util.List;

public class Box {
    protected String type = "empty";
    private int weight;
    private List<Fruit> aList;

    public Box() {
        this.aList = new ArrayList<>();
    }

    public Object addFuit(Fruit fruit) {
        if (this.type == "empty") {
            System.out.println("fruit = " + fruit.type);
            this.type = fruit.type;
        }
        if (fruit.type == this.type) {
            this.aList.add(fruit);
            return fruit;
        }
        return false;
    }

    public boolean compareWeight(Box another) {
        boolean itCompare = false;
        if (this.weight == another.weight) {
            itCompare = true;
        }
        return itCompare;
    }

    public boolean compareType(Box another) {
        if (this.type == another.type) {
            return true;
        }
        if (this.type.equals("empty")) {
            return true;
        } else return false;
    }

    public int getWeight() {
        for (Fruit fruit : this.aList) {
            this.weight = this.weight + fruit.weight;
        }
        return this.weight;
    }

    public List<Fruit> getList() {
        List<Fruit> copyAlist = new ArrayList<>();
        copyAlist.addAll(aList);
        return copyAlist;
    }

    public void removeInBox(int item) {
        System.out.println("this.aList[item] " + this.aList.get(item));

        this.weight = this.weight - this.aList.get(item).weight;
        this.aList.remove(item);
    }

    public void removeInBox(Fruit item) {
        this.weight = this.weight - item.weight;
        this.aList.remove(item);
    }
}
