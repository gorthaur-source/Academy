package org.academiadecodigo.tailormoons.BattleGame.Items;

public class Items {

    public enum Weapons {

        BAYONET,
        SWORD,
        QUARTERSTAFF,
        WAND;
    }


    public enum Armor {

        GREATHELM,
        PAULDRON,
        SABATON,
        GAUNTLET;
    }

    public static Items.Weapons randomizeWeapon() {
// return random weapon
        int randIndex = (int) (Math.random() * Items.Weapons.values().length);
        return Items.Weapons.values()[randIndex];

    }

    public static Items.Armor randomizeArmor() {
// return random armor
        int randIndex = (int) (Math.random() * Items.Armor.values().length);
        return Items.Armor.values()[randIndex];
    }
}

