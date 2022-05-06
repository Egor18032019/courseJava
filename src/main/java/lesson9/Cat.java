package lesson9;

public class Cat {
    int defaultField = 4;
    private int privatField;
    public int publickField;

    public Cat() {
    }

    public Cat(int privatField, int defaultField, int publickField) {
        this.privatField = privatField;
        this.defaultField = defaultField;
        this.publickField = publickField;
    }

    public void publicMeow() {
        System.out.println("Mews , Мяу");
    }

    private void privateMeow() {
        System.out.println("Privet");
    }
}
