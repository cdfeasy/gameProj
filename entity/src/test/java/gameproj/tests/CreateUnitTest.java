package gameproj.tests;

import gameproj.entity.Unit;
import gameproj.entity.UnitBase;
import gameproj.entity.UnitRec;
import org.junit.Test;

/**
 * Created by d.asadullin on 03.02.2015.
 */
public class CreateUnitTest {
    @Test
    public void test(){
        UnitBase base=new UnitBase();
        base.setHp(10);
        UnitRec rec=new UnitRec(base);
        rec.setHp(5);
        Unit unit=new Unit(rec);
        System.out.println(unit.getHp());
        System.out.println(rec.getHp());
        unit.setHp(unit.getHp()-2);
        System.out.println(unit.getHp());
        System.out.println(rec.getHp());
    }
}
