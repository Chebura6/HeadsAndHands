package models;


import Exceptions.CreatureException;
import utils.RandomGenerator;

public class Monster extends Creature {
    private final Integer stockDefendIndicator = 1;
    private Integer attack;
    private Integer defend;
    private Integer health;
    private Integer leastDamage;
    private Integer maxDamage;
    private boolean isAlive;

    public Monster(Integer attack, Integer defend, Integer health, Integer leastDamage, Integer maxDamage) throws CreatureException {
        super();
        if (attack < 0 || attack > 30) throw CreatureException.InvalidAttack();
        this.attack = attack;

        if (defend < 0 || defend > 30) throw CreatureException.InvalidDefend();
        this.defend = defend;

        if (health < 0) throw CreatureException.InvalidHealth();
        this.health = health;

        if (leastDamage < 0 || leastDamage > maxDamage) throw CreatureException.InvalidDamage();
        this.leastDamage = leastDamage;
        this.maxDamage = maxDamage;
        this.isAlive = true;
    }

    @Override
    public void toHit(Creature anotherCreature) throws CreatureException {
        super.toHit(anotherCreature);
        if (isAlive == false) throw CreatureException.CreatureDied();
        if (anotherCreature.getIsAlive() == false) throw CreatureException.CreatureDied();
        Integer attackModifier = (anotherCreature.getDefend() + anotherCreature.getStockDefendIndicator()) - this.attack;
        if (attackModifier <= 1) {
            Integer generatedValue = RandomGenerator.get1to6Number();
            if (generatedValue == 5 || generatedValue == 6) {
                Integer totalDamage = RandomGenerator.rnd(leastDamage, maxDamage);
                if (anotherCreature.getHealth() <= totalDamage) {
                    anotherCreature.setHealth(0);
                } else {
                    anotherCreature.setHealth(anotherCreature.getHealth() - totalDamage);
                }
            }
        } else {
            for (int i = 0; i < attackModifier; ++i) {
                Integer generatedValue = RandomGenerator.get1to6Number();
                if (generatedValue == 5 || generatedValue == 6) {
                    Integer totalDamage = RandomGenerator.rnd(leastDamage, maxDamage);
                    if (anotherCreature.getHealth() <= totalDamage) {
                        anotherCreature.setHealth(0);
                    } else {
                        anotherCreature.setHealth(anotherCreature.getHealth() - totalDamage);
                    }
                    break;
                }
            }
        }
    }
    Integer getAttack() {
        return attack;
    }

    void setAttack(Integer attack) throws NullPointerException, CreatureException {
        if (attack == null) throw new NullPointerException();
        if(attack < 0 || attack > 30) throw CreatureException.InvalidAttack();
        this.attack = attack;
    }

    Integer getDefend() {
        return defend;
    }

    void setDefend(Integer defend) throws NullPointerException, CreatureException {
        if (defend == null) throw new NullPointerException();
        if(defend < 0 || defend > 30) throw CreatureException.InvalidDefend();
        this.defend = defend;
    }

    Integer getHealth() {
        return health;
    }

    void setHealth(Integer health) throws NullPointerException, CreatureException {
        if (health == null) throw new NullPointerException();
        if(health < 0) throw CreatureException.InvalidHealth();
        if (health == 0) this.isAlive = false;
        this.health = health;
    }

    Integer getLeastDamage() {
        return leastDamage;
    }

    void setLeastDamage(Integer leastDamage) throws NullPointerException, CreatureException {
        if (leastDamage == null) throw new NullPointerException();
        if(leastDamage < 0 || leastDamage > this.maxDamage) throw CreatureException.InvalidDamage();
        this.leastDamage = leastDamage;
    }

    Integer getMaxDamage() {
        return maxDamage;
    }
    void setMaxDamage(Integer maxDamage) throws NullPointerException, CreatureException {
        if (maxDamage == null) throw new NullPointerException();
        if(maxDamage < 0 || maxDamage < this.leastDamage) throw CreatureException.InvalidDamage();
        this.maxDamage = maxDamage;
    }

    @Override
    Integer getStockDefendIndicator() {
        return super.getStockDefendIndicator();
    }

    boolean getIsAlive() {
        return isAlive;
    }
}
