package lesson5;

public abstract class Animal {

    protected static final int CANNOT_SWIM = -1;

    protected int maxRunDistance;
    protected int maxSwimDistance;
    protected float maxJumpDistance;

    protected String name;


    String run(int distance) {
        if (distance <= maxRunDistance){
            return name + " пробежал(а) " + distance + " метров";
        }
        return name + " не может бегать так далеко";
    }

    String swim(int distance) {
        if (maxSwimDistance == CANNOT_SWIM){
            return name + " не умеет плавать";
        }
        if (distance <= maxSwimDistance) {
            return name + " проплыл(а) " + distance + " метров";
        }
        return name + " не может плыть так далеко";
    }

    String jump(int distance) {
        if (distance <= maxJumpDistance) {
            return name + " прыгнул(а) на " + distance + " метров";
        }
        return name + " не может прыгнуть так далеко";
    }

}
