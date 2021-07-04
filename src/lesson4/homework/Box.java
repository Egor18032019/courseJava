package lesson4.homework;

import java.util.ArrayList;
import java.util.List;

public class Box {
    public String type = "empty";
    public int weight;
    public List<Fruit> aList =new ArrayList<>();

    public Object addFuit(Fruit fruit) {
        if (this.type == "empty") {
            System.out.println("fruit = " + fruit.type);
            this.type = fruit.type;
        }
        if (fruit.type == this.type) {
            aList.add(fruit);
            this.weight=this.weight+ fruit.weight;
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
        if(this.type.equals("empty")){
            return true;
        }
       else return false;
    }

    public int getWeight() {
        return weight;
    }
    public List<Fruit> getList (){
        return aList;
    }
}
