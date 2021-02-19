package lesson5;

import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        Dog drol = new Dog("Дроль");
        System.out.println(drol.run(50));
        System.out.println(drol.swim(5));
        System.out.println(drol.jump(10));

        Horse ksusha = new Horse("Ксюша");
        System.out.println(ksusha.run(150));
        System.out.println(ksusha.swim(30));
        System.out.println(ksusha.jump(200));

        Bird sinichka = new Bird("Синичка");
        System.out.println(sinichka.run(10));
        System.out.println(sinichka.swim(32));
        System.out.println(sinichka.jump(50));

        Cat busya = new Cat("Буся");
        System.out.println(busya.run(65));
        System.out.println(busya.swim(4));
        System.out.println(busya.jump(25));

    }
}
