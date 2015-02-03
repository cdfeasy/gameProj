package gameproj.entity;

import gameproj.entity.ability.interfaces.Ability;

import java.util.List;

/**
 * Created by d.asadullin on 03.02.2015.
 * Concrete user unit
 */
public class UnitRec extends UnitBase {
    private UnitBase base;
    private Long curId;
    private Long exp;
    private Long maxExp;
    private Short level;
    private Short realLevel;
    private List<Ability> abilities;

    public Long getCurId() {
        return curId;
    }

    public void setCurId(Long curId) {
        this.curId = curId;
    }

    public UnitBase getBase() {
        return base;
    }

    public void setBase(UnitBase base) {
        this.base = base;
    }

    public UnitRec(UnitBase base){
        this.base=base;
    }

    public Long getExp() {
        return exp;
    }

    public void setExp(Long exp) {
        this.exp = exp;
    }

    public Long getMaxExp() {
        return maxExp;
    }

    public void setMaxExp(Long maxExp) {
        this.maxExp = maxExp;
    }

    public Short getLevel() {
        return level;
    }

    public void setLevel(Short level) {
        this.level = level;
    }

    public Short getRealLevel() {
        return realLevel;
    }

    public void setRealLevel(Short realLevel) {
        this.realLevel = realLevel;
    }
}
