package com.mygdx.game.gfx;

import java.util.ArrayList;

public class MapFactory {
    public static Map createMap(int level) {
        Map m = new Map(
                createTreeMap(),
                createSandMap(),
                level
        );

        return m;
    }

    private static ArrayList<Tree> createTreeMap() {
        ArrayList<Tree> t = new ArrayList<Tree>();

        return t;
    }


    private static ArrayList<SandSpot> createSandMap() {
        ArrayList<SandSpot> s = new ArrayList<SandSpot>();
        s.add(new SandSpot(0,3));
        s.add(new SandSpot(0,3.5f, 3));
        s.add(new SandSpot(0,4));
        return s;
    }
}
