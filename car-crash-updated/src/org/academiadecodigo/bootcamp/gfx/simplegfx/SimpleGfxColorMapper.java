package org.academiadecodigo.bootcamp.gfx.simplegfx;

import org.academiadecodigo.bootcamp.grid.GridColor;
import org.academiadecodigo.simplegraphics.graphics.Color;



public class SimpleGfxColorMapper {

    private static final Color[] colors = {
            Color.RED,
            Color.GREEN,
            Color.BLUE,
            Color.MAGENTA,
            Color.WHITE,
            Color.ORANGE,
            Color.CYAN,
            Color.DARK_GRAY
    };

    public static Color getColor(GridColor color){

        Color sGfxColor = null;

        switch (color) {
            case RED:
                sGfxColor = colors[0];
                break;
            case GREEN:
                sGfxColor = colors[1];
                break;
            case BLUE:
                sGfxColor = colors[2];
                break;
            case MAGENTA:
                sGfxColor = colors[3];
                break;
            case NOCOLOR:
                sGfxColor = colors[4];
            case ORANGE:
                sGfxColor = colors[5];
                break;
            case CYAN:
                sGfxColor = colors[6];
                break;
            case DARK_GRAY:
                sGfxColor = colors[7];
                break;
            default:
                System.out.println("something went terribly wrong...");
        }

        return sGfxColor;
    }
}
