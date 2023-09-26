package models;

import Exceptions.CreatureException;
import utils.RandomGenerator;

public class Player extends Creature {
    private final Integer maxHealCount = 4;
    private Integer attack;
    private Integer defend;
    private Integer maxHealth;
    private Integer health;
    private Integer leastDamage;
    private Integer maxDamage;
    private Integer healedCount = 0;
    private boolean isAlive;

    public Player(Integer attack, Integer defend, Integer health, Integer leastDamage, Integer maxDamage) throws CreatureException {
        super();
        if (attack < 0 || attack > 30) throw CreatureException.InvalidAttack();
        this.attack = attack;

        if (defend < 0 || defend > 30) throw CreatureException.InvalidDefend();
        this.defend = defend;

        if (health < 0) throw CreatureException.InvalidHealth();
        this.health = health;
        this.maxHealth = health;

        if (leastDamage < 0 || leastDamage > maxDamage) throw CreatureException.InvalidDamage();
        this.leastDamage = leastDamage;
        this.maxDamage = maxDamage;
        this.healedCount = 0;
        this.isAlive = true;
    }

    public void toHeal() throws CreatureException{
        if (isAlive == false) throw CreatureException.CreatureDied();
        if (healedCount < maxHealCount)  {
            Integer toAdd = (int)Math.round(maxHealth * 0.3);
            healedCount += 1;
            health += toAdd;
            if (health > maxHealth) {
                health = maxHealth;
            }
        }


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

    @Override
    Integer getAttack() {
        return this.attack;
    }

    @Override
    void setAttack(Integer attack) throws NullPointerException, CreatureException {
        if (attack == null) throw new NullPointerException();
        if (attack < 0 || attack > 30) throw CreatureException.InvalidAttack();
        this.attack = attack;
    }

    @Override
    Integer getDefend() {
        return defend;
    }

    @Override
    void setDefend(Integer defend) throws NullPointerException, CreatureException{
        if (defend == null) throw new NullPointerException();
        if (defend < 0 || defend > 30) throw CreatureException.InvalidDefend();
        this.defend = defend;

    }

    @Override
    Integer getHealth() {
        return health;
    }

    void setHealth(Integer health) throws NullPointerException, CreatureException {
        if (health == null) throw new NullPointerException();
        if (health < 0) throw CreatureException.InvalidHealth();
        if (health == 0) this.isAlive = false;
        this.health = health;
    }

     Integer getMaxHealCount() {
        return maxHealCount;
    }

    @Override
    Integer getLeastDamage() {
        return leastDamage;
    }

    @Override
    void setLeastDamage(Integer leastDamage) throws NullPointerException, CreatureException {
        if (leastDamage == null) throw new NullPointerException();
        if (leastDamage < 0 || leastDamage > maxDamage) throw CreatureException.InvalidDamage();
        this.leastDamage = leastDamage;
    }

    @Override
    Integer getMaxDamage() {
        return maxDamage;
    }

    @Override
    void setMaxDamage(Integer maxDamage) throws NullPointerException, CreatureException {
        if (maxDamage == null) throw new NullPointerException();
        if (maxDamage < 0 || maxDamage < leastDamage) throw CreatureException.InvalidHealth();
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
