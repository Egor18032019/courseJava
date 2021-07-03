package lesson4;

public class GenerikBox<T> {//может быть несолько T типов
    T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public GenerikBox(T obj) {
        setObj(obj);
    }

    public void doSomething2() {

    }
}
