package aggregates;

import entities.Currencys;
import valueobjects.Armor;
import valueobjects.Weapon;

import java.util.HashMap;
import java.util.List;

public class Inventory {

    private Currencys currencys;
    private HashMap<String, Integer> items;
    private Weapon[] weapons = new Weapon[4];
    private Armor armor;

    public Inventory(Currencys currencys, HashMap<String, Integer> items, Weapon[] weapons, Armor armor) {
        this.currencys = currencys;
        this.items = items;
        this.weapons = weapons;
        this.armor = armor;
    }

    public Currencys getCurrencys() {
        return currencys;
    }

    public HashMap<String, Integer> getItems() {
        return items;
    }

    public Weapon[] getWeapons() {
        return weapons;
    }

    public Armor getArmor() {
        return armor;
    }
}
