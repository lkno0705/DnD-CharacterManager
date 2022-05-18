package aggregates;

import entities.Currencys;
import exceptions.WeaponException;
import factories.InventoryFactory;
import valueobjects.Armor;
import valueobjects.Weapon;

import java.util.HashMap;

public class Inventory {

    private Currencys currencys;
    private HashMap<String, int> items;
    private Weapon[] weapons;
    private Armor armor;

    public Inventory(Currencys currencys, HashMap<String, int> items, Weapon[] weapons, Armor armor) throws WeaponException {
        this.currencys = currencys;
        this.items = items;
        if(weapons.length < 5) this.weapons = weapons;
        else throw new WeaponException("Invalid Amount of weapons");
        this.armor = armor;
    }

    public Currencys getCurrencys() {
        return currencys;
    }

    public HashMap<String, int> getItems() {
        return items;
    }

    public Weapon[] getWeapons() {
        return weapons;
    }

    public Armor getArmor() {
        return armor;
    }

    public static InventoryFactory builder(){ return new InventoryFactory();}
}
