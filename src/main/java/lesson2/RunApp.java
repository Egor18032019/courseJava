package lesson2;

public class RunApp {
    static class Human {
        private Transport currentTransport;

        public void drive(Transport transport) {
            transport.start();
            this.currentTransport = transport;
        }

        public void stop() {
            if (currentTransport != null) {
                currentTransport.stop();
                currentTransport = null;
            } else {
                System.out.println("Не еду я.");
            }
        }

        public void skateActions() {
            if (!(currentTransport instanceof Skate)) {
                System.out.println("А нет скейта");
                return;
            }
            Skate skateboard = (Skate) currentTransport;
             skateboard.makeTrick(); // или подключить другой интерфейс
        }

    }

    static class Car implements Transport {
        public void run() {
            System.out.println("Машина едет");

        }

        @Override
        public void start() {
            System.out.println("Машина start");
        }

        @Override
        public void stop() {
            System.out.println("Машина stop");

        }
    }

    static class Skate implements Transport {
        public void makeTrick() {
            System.out.println("aaaAAAAAA");
        }

        @Override
        public void start() {
            System.out.println("Skate stop");
        }

        @Override
        public void stop() {
            System.out.println("Skate start");
        }
    }

    static class Moto implements Transport {
        public void run() {
            System.out.println("Moto run");
        }

        @Override
        public void start() {
            System.out.println("Moto stop");
        }

        @Override
        public void stop() {
            System.out.println("Moto start");
        }
    }

    public static void main(String[] args) {
        Moto moto = new Moto();
        Human human = new Human();
        human.stop();
        human.drive(moto);
        human.stop();
        Transport trans = new Car();
        human.drive(trans);
        human.stop();

    }

}
