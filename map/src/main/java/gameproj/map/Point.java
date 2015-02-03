package gameproj.map;

/**
 * Created by d.asadullin on 03.02.2015.
 */
public class Point {
    private int i;
    private int j;

    public Point(int i, int j) {
        this.i = i;
        this.j = j;
    }
    public BattleHex getHex(BattleMap map){
        return map.getBattleHexes()[i][j];
    }
}
