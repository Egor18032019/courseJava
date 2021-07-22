package lesson8.homeWork;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class MainApp {
    public static void main(String[] args) {
        HashMapForWords WordsMap = new HashMapForWords();

        Optional<String> occurringWord = null;
        try {
            occurringWord = Files.lines(Paths.get("c:\\Users\\Teacher\\Documents\\GitHub\\JAVA\\src\\lesson8\\homeWork\\text.txt"))
                    .map(everyLine -> everyLine.split("\\s"))
                    .flatMap(Arrays::stream)
                    // дальше складываю всё в новый HashMap WordsMap .
                    // Использую peek так как он  тот же самый объект, который получил на входе
                    // можно было бы и map использовать
                    .peek(s -> WordsMap.put(s))
                    // потом оставляю уникальные
                    .distinct()
                    // а потом по уникальному ключу обращаюсь к HashMap WordsMap
                    // сортирую по key
                    .sorted((a, b) -> WordsMap.get(b) - WordsMap.get(a))
                    // и берем самый верхний*первый
                    .findFirst();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (WordsMap.get((occurringWord.orElse(null))) > 1) {
            // и распечатываем со значением по умолчанию
            System.out.println("Часто встречающееся слово - " + occurringWord.orElse("Что то пошло не так"));
        } else {
            System.out.println("Нет повторяющихся");
        }
    }

    static class HashMapForWords extends HashMap<String, Integer> {
        public void put(String key) {
            // если не было то ложим со значением 1
            if (!containsKey(key)) {
                put(key, 1);
                return;
            } else {
                // в другом случаем увеличивам
                put(key, get(key) + 1);
            }
        }

    }

    public static String getCountWords(String[] arr) {
        Map<String, Integer> mapForwords = new HashMap<>();
        Integer firstTimeWords = 1;
        for (String it : arr) {
            if (!mapForwords.containsKey(it)) {
                mapForwords.put(it, firstTimeWords);
            } else {
                mapForwords.put(it, mapForwords.get(it) + 1);
            }
        }

        String mostUnick = Collections.max(mapForwords.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getKey();

        return mostUnick;
    }
}
