package org.academiadecodigo.tailormoons.sniperelite.gameobjects;


public class Tree extends GameObject implements Mictable {

    @Override
    public String getMessage() {
        return "Nothing to see here. I'm a tree. Don't mict me please.";
    }


    @Override
    public String mictOnIt() {
        return "Tree mictaded. Mammals will know not to come close.";
    }

}