package lesson5;

public class Cat extends Animal {

    public Cat(String name) {
        this.maxRunDistance = 200;
        this.maxJumpDistance = 2;
        this.maxSwimDistance = CANNOT_SWIM;
        this.name = name;
    }

}
