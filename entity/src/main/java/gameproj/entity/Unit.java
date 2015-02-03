package gameproj.entity;

import gameproj.entity.ability.interfaces.Magic;
import gameproj.entity.ability.interfaces.Melee;
import gameproj.entity.ability.interfaces.Range;

import java.util.List;

/**
 * Created by d.asadullin on 03.02.2015.
 * User unit on battlefield(изменения не сохраняются)
 */
public class Unit extends UnitRec{
    private UnitRec rec;
    private List<Melee> melee;
    private List<Range> range;
    private List<Magic> magic;
    public Unit(UnitRec rec){
        super(rec.getBase());
        this.rec=rec;
        this.setCurId(rec.getCurId());
        append();
    }
    private void append(){
        this.setHp(rec.getHp()+getBase().getHp());
    }
}
