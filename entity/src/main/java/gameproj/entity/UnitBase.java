package gameproj.entity;

import gameproj.entity.ability.interfaces.Ability;

import java.util.List;

/**
 * Created by dmitry on 01.02.2015.
 * Basic unit class
 */
public class UnitBase {
    protected Integer id;
    protected Integer hp;
    protected Integer speed;
    protected Integer stamina;
    protected Integer morale;
    protected Resistance resistance;
    protected Movement movement;
    protected Double expCoeff;
    protected List<Ability> basicAbilities;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getStamina() {
        return stamina;
    }

    public void setStamina(Integer stamina) {
        this.stamina = stamina;
    }

    public Integer getMorale() {
        return morale;
    }

    public void setMorale(Integer morale) {
        this.morale = morale;
    }

    public Resistance getResistance() {
        return resistance;
    }

    public void setResistance(Resistance resistance) {
        this.resistance = resistance;
    }

    public Movement getMovement() {
        return movement;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    public Double getExpCoeff() {
        return expCoeff;
    }

    public void setExpCoeff(Double expCoeff) {
        this.expCoeff = expCoeff;
    }

    public List<Ability> getBasicAbilities() {
        return basicAbilities;
    }

    public void setBasicAbilities(List<Ability> basicAbilities) {
        this.basicAbilities = basicAbilities;
    }
}
