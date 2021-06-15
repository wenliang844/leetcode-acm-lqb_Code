package ACM.每日一题leecode.自刷;


class Car extends Vehicle {
    public static void main(String[] args) {
        new Car().run();
    }
        private final void run () {
            System.out.println("Car");

        }

    }


    class Vehicle {
        private final void run() {
            System.out.println("Vehicle");
        }
    }

