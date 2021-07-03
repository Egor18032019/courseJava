package lesson4.lists;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        ArrayList<String> arrList = new ArrayList<>(Arrays.asList("args", "3", "A", "B", "B", "B", "C", "D", "AA", "1"));
        // set замеит
        // add добавляет *вклинивает
        arrList.ensureCapacity(10000);
        arrList.trimToSize();
        arrList.size();
        arrList.get(1);
        arrList.remove("A");
        System.out.println(arrList);
        while (arrList.remove("B")) ; //удаляет все буквы B
        System.out.println(arrList);
        Collections.sort(arrList);
        System.out.println(arrList);
        arrList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        System.out.println(arrList);
        arrList.sort((o1, o2) -> o2.length() - o1.length());
        System.out.println(arrList);
        List<String> linkdeList = new LinkedList<>();
        timeForSort();
    }

    public static void timeForSort() {
        ArrayList<Integer> alist = new ArrayList<>(1000000);
        List<Integer> llist = new LinkedList<>();
        for(int i =0;i<1000000 ; i++){
            int x =(int)(Math.random()*4444);
            alist.add(x);
            llist.add(x);
        }
        long time =System.currentTimeMillis();
        Collections.sort(alist);
        System.out.println("a_time: " + (System.currentTimeMillis()-time));

        time =System.currentTimeMillis();
        Collections.sort(llist);
        System.out.println("l_time: " + (System.currentTimeMillis()-time));
    }
}
