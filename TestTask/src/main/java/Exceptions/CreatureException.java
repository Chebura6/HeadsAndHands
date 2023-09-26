package Exceptions;

public class CreatureException extends Exception {
    private CreatureException(String message) {
        super(message);
    }
    public static CreatureException InvalidAttack() {
        return new CreatureException("Attack parameter must be a 0-30 number!");
    }

    public static CreatureException InvalidDefend() {
        return new CreatureException("Defend parameter must be a 0-30 number!");
    }

    public static CreatureException InvalidHealth() {
        return new CreatureException("Health cannot be less than 1!");
    }

    public static CreatureException InvalidDamage() {
        return new CreatureException("Damage must be 2 M, N positive numbers where M < N!");
    }

    public static CreatureException CreatureDied() {
        return new CreatureException("Invalid operation: creature has killed!");
    }
}
