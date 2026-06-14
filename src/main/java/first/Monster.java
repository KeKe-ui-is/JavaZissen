package first;

import java.util.ArrayList;
import java.util.List;

public record Monster(String name, int hp, boolean isBoss) {
    public Monster{
        if (hp < 0) throw new IllegalArgumentException();
    }

    public static void main(String[] args){
        Monster monster1 = new Monster("お化けキノコ",-10,false);
        Monster monster2 = new Monster("ゴブリン",25,false);
        Monster monster3 = new Monster("ドラゴン",120,false);

        List<Monster> monsters = List.of(monster1,monster2,monster3);
        for(Monster monster : monsters){
            System.out.println(monster);
        }
    }
}
