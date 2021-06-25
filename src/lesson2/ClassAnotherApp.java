package lesson2;


public class ClassAnotherApp {
    class Inner { // а если тут поставить поставить static то он в отличие не смогжет вызвать внутрнеие методы
        int innerValue;

        public void innerMethod() {
            System.out.printf("Внутри");
        }

        Inner(int number) {
            this.innerValue = number;
        }
    }

    public void otherMethod() {
        Inner inner = new Inner(1); // а у этого есть контест. место где его вызвали
    }

    public static void main(String[] args) {
        //..Inner anInner = new Inner(1); // не могу его так вызвать . так как нет привязки у статик метода.
        Inner anInner = new ClassAnotherApp().new Inner(2); // а так могу
        // local class
        class Point {
            int x;

            public Point(int y) {
                this.x = y;
            }

            public void setX(int x) {
                this.x = x;
            }

            public void info() {
                System.out.println("x" + " = " + x);
            }
        };
//        анонимный внутрений класс
        Flyable flyable = new Flyable() {
            @Override
            public void fly() {
                System.out.println();
            }
        };
        System.out.println(flyable.getClass().getName()); // вернет lesson2.ClassAnotherApp$1
    }
}
