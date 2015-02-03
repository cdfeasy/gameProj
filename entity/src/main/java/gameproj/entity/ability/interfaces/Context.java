package gameproj.entity.ability.interfaces;

import gameproj.entity.Unit;
import gameproj.map.BattleMap;
import gameproj.map.Point;

/**
 * Created by d.asadullin on 03.02.2015.
 */
public class Context {
    private BattleMap battleMap;
    private Integer turnId;
    private Point target;
    private Unit user;

    public BattleMap getBattleMap() {
        return battleMap;
    }

    public void setBattleMap(BattleMap battleMap) {
        this.battleMap = battleMap;
    }

    public Integer getTurnId() {
        return turnId;
    }

    public void setTurnId(Integer turnId) {
        this.turnId = turnId;
    }

    public Point getTarget() {
        return target;
    }

    public void setTarget(Point target) {
        this.target = target;
    }

    public Unit getUser() {
        return user;
    }

    public void setUser(Unit user) {
        this.user = user;
    }
}
