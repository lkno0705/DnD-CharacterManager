package aggregates;

import entities.Currencys;

import java.util.HashMap;

public class Inventory {

    private Currencys currencys;
    private HashMap<String, Integer> items;
    /*
    TODO: Add Entity Weapon, Add List of Weapons (mit fiktivem Limit von 4 wie auf Character Sheet)
        & 1 Slot of Armor
    TODO: Add method get Weapons, get Armor
    Weapon:
        * Namen
        * DamageDie
            DieType -> Welcher Würfel
            Amount
        * isFinesse -> Use Strength or Dexterity modifier for Attack Rolls & Damage Rolls
    Armor:
        * Name
        * base Armor Class
        * With Dex: Bool
        * Max DexBonus
        * Minimum Strength -> Wenn nicht erfüllt, dann geht nicht ins Inventar
     */

    public Inventory() {
    }
}
