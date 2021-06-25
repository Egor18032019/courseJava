package lesson2.homework;

public class HomeWorkTwo {

    static void forActionEach(Player[] arr, Activity[] array) {
        for (Player i : arr) {
            for (Activity barrier : array) {
                 if (i.getCanNextAction()) {
                    i.startAction(barrier);
                }
//                 if (!i.startAction(barrier)){
//                     break;
//                 } или так
            }
        }
    }

    public static void main(String[] args) {
        Player[] players = {
                new Man(),
                new Roboto(),
                new Cot()
        };
        Activity[] barriers = {
                new Wall(2),
                new RunWall(11),
                new Wall(5),
                new RunWall(111),
                new Wall(55),
                new RunWall(1111)
        };
        forActionEach(players, barriers);
    }
}
