package lesson9.homeWork.tables;

import lesson9.homeWork.anotations.Column;
import lesson9.homeWork.anotations.Id;
import lesson9.homeWork.anotations.Table;

@Table(name = "trainers")
public class Teacher {
    @Id
    @Column(name = "trainer_id")
    private long id;
    @Column
    private String name;
    @Column
    private String lesson;
    @Column
    private int age;

    public Teacher(long id, String name, String lesson, int age) {
        this.id = id;
        this.name = name;
        this.lesson = lesson;
        this.age = age;
    }
}
