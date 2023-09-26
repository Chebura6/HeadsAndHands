package models;

import Exceptions.CreatureException;

public abstract class Creature {
    private final Integer stockDefendIndicator = 1;
    private Integer attack;
    private Integer defend;
    private Integer health;
    private Integer leastDamage;
    private Integer maxDamage;
    private boolean isAlive;

    Creature() throws CreatureException {

    }
    public void toHit(Creature anotherCreature) throws NullPointerException, CreatureException {
        if (anotherCreature == null) throw new NullPointerException("Null creature");
    }

    Integer getAttack() {
        return attack;
    }

    void setAttack(Integer attack) throws NullPointerException, CreatureException {
        this.attack = attack;
    }

    Integer getDefend() {
        return defend;
    }

    void setDefend(Integer defend) throws NullPointerException, CreatureException {
        this.defend = defend;
    }

    Integer getHealth() {
        return health;
    }

    void setHealth(Integer health) throws NullPointerException, CreatureException {
        this.health = health;
    }

    Integer getLeastDamage() {
        return leastDamage;
    }

    void setLeastDamage(Integer leastDamage) throws NullPointerException, CreatureException {
        this.leastDamage = leastDamage;
    }

    Integer getMaxDamage() {
        return maxDamage;
    }

    void setMaxDamage(Integer maxDamage) throws NullPointerException, CreatureException {
        this.maxDamage = maxDamage;
    }

    Integer getStockDefendIndicator() {
        return stockDefendIndicator;
    }

    boolean getIsAlive() {
        return isAlive;
    }
}
