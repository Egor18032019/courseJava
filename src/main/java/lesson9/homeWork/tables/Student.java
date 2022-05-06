package lesson9.homeWork.tables;

import lesson9.homeWork.anotations.Column;
import lesson9.homeWork.anotations.Id;
import lesson9.homeWork.anotations.Table;

@Table(name = "students")
public class Student {
    @Id
    @Column(name = "students_id")
    private long id;
    @Column
    private String name;
    @Column
    private int age;

    public Student(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
