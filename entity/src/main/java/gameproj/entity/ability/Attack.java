package gameproj.entity.ability;

import gameproj.entity.ability.interfaces.Context;
import gameproj.entity.ability.interfaces.Melee;

/**
 * Created by d.asadullin on 03.02.2015.
 */
public class Attack implements Melee{
    private Integer power;
    @Override
    public void execute(Context context) {
        context.getTarget().getHex(context.getBattleMap());
    }
}
