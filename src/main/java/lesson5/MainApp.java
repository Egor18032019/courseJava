package lesson5;

import java.lang.reflect.Field;
import java.util.*;

public class MainApp {
    public static void main(String[] args) throws Exception {
        Map<String, String> map = new HashMap<>(8);
        map.put("A", "B");
        map.put("1", "2");
        map.put("3", "4");
        map.put("4", "4");
        map.put("5", "4");
        map.put("6", "4");
        map.put("7", "4");
        map.put("8", "4");
        Class hashMapClass = HashMap.class;
        Field tableField = hashMapClass.getDeclaredField("table");
        tableField.setAccessible(true);
        int capacity = ((Object[]) tableField.get(map)).length;
        System.out.println(map.entrySet());
        System.out.println(capacity);
        for (Map.Entry<String, String> it : map.entrySet()) {
            System.out.print(it.getKey() + " : ");
            System.out.println(it.getValue());

        }
        System.out.println(map.getOrDefault("Z", "no have"));
        //HasMap - пришло и раскидалось
//        еще есть LinkMap и ?
//        HasSet  уникальные значения
        Set<String> set = new HashSet<>();
        // LinkSet or ThreeSet
        set.add("A");
        set.add("A");
        set.add("B");
        set.add("BC");
        set.add("CC");
        System.out.println(set);
        List<String> list = new ArrayList<>(Arrays.asList("A", "A", "A", "B", "C"));
        Iterator<String> iter = list.iterator(); //+ работает с set
        while (iter.hasNext()) {
            String o = iter.next();
            if (o.equals("A")) {
                iter.remove();
            }
        }
        Iterator<String> iterForSet = set.iterator();
        while (iterForSet.hasNext()) {
            String foo = iterForSet.next();
            if (foo.length() > 1) {
                iterForSet.remove();
            }
        }
        System.out.println(list);
        System.out.println(set);
    // есть специализированый для List
        ListIterator<String> forList = list.listIterator();
    }
}
