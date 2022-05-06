package lesson9;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainApp {
    public static void main(String[] args) throws Exception {
        Cat cat = new Cat(1, 23, 33);
        Class classCat = Cat.class;

        Field[] fieldsArr = classCat.getDeclaredFields();
        String fields = Arrays.toString(fieldsArr);
        System.out.println(fields);
        System.out.println(fieldsArr[0].get(cat));
        fieldsArr[0].set(cat, 33);
        System.out.println(fieldsArr[0].get(cat));
        Method[] methods = classCat.getDeclaredMethods();
        for (Method o : methods) {
            System.out.println(o.getName());
        }
//        methods[1].invoke(cat);// именно в методах пляшет расположение
//        methods[0].setAccessible(true); // дали разрешение
//        methods[0].invoke(cat);
        int mods = methods[0].getModifiers();
        System.out.println(" isStatic = " + Modifier.isStatic(mods));

        Cat cat3 = (Cat) classCat.getConstructor(int.class, int.class, int.class)
                .newInstance(20, 30, 40);
////        URL url = new File("c:\\Users\\Teacher\\Documents\\GitHub\\JAVA\\out\\production\\geekbrains\\lesson8\\homeWork\\").toURI().toURL();
//        URL url1 = new File("C:/Users/Teacher/Documents/GitHub/JAVA/out/production/geekbrains/lesson8/homeWork").toURI().toURL();
//        System.out.println("url " + url1 + " Нашел ?");
//        ClassLoader classLoader = new URLClassLoader(new URL[]{url1});
//        Class humanClass = classLoader.loadClass("Person");

// тест анотации
        Class testClass = ClassForAnnotationTest.class;
        Method[] methodsAno = testClass.getDeclaredMethods();
        List<Method> executionList = new ArrayList<>();
        for (Method o : methodsAno) {
            if (o.isAnnotationPresent(MyAnnotation.class)) {
                o.invoke(null);//так как статик
            }
        }
        executionList.sort(
                (o1, o2) -> o2.getAnnotation(MyAnnotation.class).priority() - o1.getAnnotation(MyAnnotation.class).priority()
        );
        executionList = Arrays.stream(methodsAno)
                .filter(
                        m -> m.isAnnotationPresent(MyAnnotation.class)
                )
                .sorted(
                        (o1, o2) -> o2.getAnnotation(MyAnnotation.class).priority() - o1.getAnnotation(MyAnnotation.class).priority()
                )
                .collect(Collectors.toList());
        for (Method m : executionList) {
            m.invoke(null);
        }
    }
}
