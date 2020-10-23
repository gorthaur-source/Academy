package org.academiadecodigo.tailormoons.mapeditor;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Cursor extends Node {

    private Node selectedNode;
    private int x;
    private int y;

    public Cursor(Node node) {
        selectedNode = node;
        selectedNode.getSquare().setColor(Color.GREEN);
        selectedNode.getSquare().fill();
    }




    public void hide() {
        selectedNode.getSquare().delete();
    }

}
