package lesson5;

public class Bird extends Animal {
    public Bird(String name) {
        this.maxRunDistance = 5;
        this.maxJumpDistance = 0.2f;
        this.maxSwimDistance = CANNOT_SWIM;
        this.name = name;
    }

}
