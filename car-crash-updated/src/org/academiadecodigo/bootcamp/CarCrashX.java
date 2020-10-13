package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.grid.GridType;

// Added features:
// 2 Player support (one controls with WASD and other with direction keys).
// Circular shaped cars added called "ambulances", they "heal" crashed cars and do not crash with them, but do get crashed by Players.
// Game ends when all ambulances have been crashed by Players, in which case players with most takedowns win.
// Game also ends when all non-ambulance cars crash, in which case both Players lose.

public class CarCrashX {

    public static void main(String[] args) throws InterruptedException {

        //Game g = new Game(GridType.LANTERNA, 80, 25, 200);
        Game g = new Game(GridType.SIMPLE_GFX, 80, 25, 100);

        g.init();
        g.start();

    }

}
