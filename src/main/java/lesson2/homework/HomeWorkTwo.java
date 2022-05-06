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
        String h = "s";
        String u = "f";
        int e = 0;
        e = e + 1;
        e -= 1;
        e++;
        System.out.println(e);
        e = e + 2 * e;
        System.out.println(e);
        e = e + /* dd*/ +1;
        e++;
        System.out.printf(" is %s", e);
        char letter = 'a';
        double d = 1.1;
        float f = 2.2F;
        f = (float) (d * 2);
        Integer a = 10000;
        Integer b = 10000;
        int ea = 10000;
        System.out.println();
        System.out.println((new int []{10-3,22-3,11-3,9-2}).length);


    }
}
