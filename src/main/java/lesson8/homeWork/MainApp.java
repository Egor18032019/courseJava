package lesson8.homeWork;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

/*
Создайте массив объектов типа Сотрудник (с полями Имя, Возраст, Зарплата) и вычислите
среднюю зарплату сотрудника;
3. Напишите метод, способный найти в массиве сотрудников из п. 2 найдите N самых старших
сотрудников и отпечатает в консоль сообщение вида “N самых старших сотрудников зовут:
имя1, имя2, имяN;”.
 */
public class MainApp {
    private static String path;
    final static int LIMIT = 3;

    public static void main(String[] args) {
        String filePath = "c:\\Users\\Teacher\\Documents\\GitHub\\JAVA\\src\\lesson8\\homeWork\\text.txt";

        Person[] persons = {
                new Person("V1bo", 22, 1, Position.MANAGER),
                new Person("Bob2", 44, 2, Position.DIRECTOR),
                new Person("Bob3", 25, 3, Position.ENGINEER),
                new Person("Bob4", 42, 4, Position.ENGINEER),
                new Person("Bob5", 55, 5, Position.MANAGER),
                new Person("Bob6", 19, 6, Position.MANAGER),
                new Person("Bob7", 33, 7, Position.ENGINEER),
                new Person("Bob8", 37, 8, Position.MANAGER)
        };
        System.out.println(getFrequentlyOccurringWord(filePath));
        System.out.println(getAverageSalary(persons));
        System.out.println(getOldName(persons));

    }


    public static String getFrequentlyOccurringWord(String path) {
        MainApp.path = path;
        String answer;
        HashMapForWords WordsMap = new HashMapForWords();
        Optional<String> occurringWord = Optional.empty();

        try {
            occurringWord = Files.lines(Paths.get(path))
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
        String result = "";
        try {
            // Получаем из файла массив строк
            String[] words = Files.lines(Paths.get(path)).toArray(new IntFunction<String[]>() {
                @Override
                public String[] apply(int value) {
                    return new String[value];
                }
            });
            System.out.println(Arrays.toString(words));
            result = Arrays.stream(words)//завернули масив строк в поток
                    .collect(
                            Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    // сделаем сборку с грпировкой(свернет в map(где ключом будет значение) )
                    .entrySet()
                    .stream()
                    .max(
                            Comparator.comparingLong(
                                    Map.Entry::getValue
                            ))
                    .get()
                    .getKey();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Rezult " + result);

        if (WordsMap.get((occurringWord.orElse(null))) > 1) {
            // и распечатываем со значением по умолчанию
            answer = "Часто встречающееся слово - " + occurringWord.orElse("Что то пошло не так");
        } else {
            answer = "Нет повторяющихся";
        }
        return answer;
    }

    public static String getAverageSalary(Person[] arr) {
        String answer = "Нет данных";
        if (arr.length > 0) {
            Optional<Integer> averageSalary = Arrays.stream(arr)
                    .map(s -> s.getSalary())
                    .reduce((acc, per) -> acc + per);
            answer = "Средняя зп = " + averageSalary.orElse(0) / arr.length;
        }
        // другой метод
        System.out.println(
                Arrays.stream(arr).mapToDouble(Person::getSalary).average().getAsDouble()
                );
        return answer;
    }

    public static String getOldName(Person[] arr) {
        String message = Arrays.stream(arr)
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .limit(LIMIT)
                .map(s -> s.getName())
                .collect(Collectors.joining(" ,", LIMIT + " самых старших сотрудников зовут: ", "."));
        return message;
    }
}

