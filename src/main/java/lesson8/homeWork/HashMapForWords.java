package lesson8.homeWork;

import java.util.HashMap;

public class HashMapForWords extends HashMap<String, Integer> {
        public void put(String key) {
            // если не было то положим со значением 1
            if (!containsKey(key)) {
                put(key, 1);
                return;
            } else {
                // в другом случаем увеличивам
                put(key, get(key) + 1);
            }
        }
}
