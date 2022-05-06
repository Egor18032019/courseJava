package lesson9;

public class ClassForAnnotationTest {
    public static void method2(){
        System.out.println("method 2 ");
    }
    @MyAnnotation(priority = 10)
    public static void method1(){
        System.out.println("method 1 ");
    }
    @MyAnnotation()
    public static void method3(){
        System.out.println("method 3 ");
    }

}
