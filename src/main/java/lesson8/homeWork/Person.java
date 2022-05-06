package lesson8.homeWork;


public class Person {
    private String name;
    private int age;
    private int salary;
    private Position position;

    public Person(String name, int age, int salary, Position position) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.position = position;
    }

    public Person( ) {

    }

    public int getSalary() {
        return this.salary;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
