package utils;

public class RandomGenerator {
    public static Integer get1to6Number() {
        return (int) (Math.random() * 6) + 1;
    }

    public static Integer rnd(Integer min, Integer max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
