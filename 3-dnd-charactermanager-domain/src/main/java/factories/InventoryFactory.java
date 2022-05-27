package factories;

import aggregates.Inventory;
import entities.Currencys;
import exceptions.CurrencyException;
import exceptions.InventoryException;
import valueobjects.Armor;
import valueobjects.Weapon;

import java.util.HashMap;
import java.util.List;

public class InventoryFactory {

    private Currencys currencys;
    private HashMap<String, Integer> items;
    private Weapon[] weapons;
    private Armor armor;

    public InventoryFactory(){}

    public InventoryFactory currencys(Currencys currencys){
        this.currencys = currencys;
        return this;
    }

    public InventoryFactory currencys(int CP, int SP, int EP, int GP, int PP) throws CurrencyException {
        this.currencys = new Currencys(CP, SP, EP, GP, PP);
        return this;
    }

    public InventoryFactory items(HashMap<String, Integer> items){
        this.items = items;
        return this;
    }

    public InventoryFactory weapons(Weapon[] weapons){
        this.weapons = weapons;
        return this;
    }

    public InventoryFactory weapons(List<Weapon> weaponList){
        this.weapons = weaponList.toArray(new Weapon[0]);
        return this;
    }

    public InventoryFactory armor(Armor armor){
        this.armor = armor;
        return this;
    }

    public Inventory build() throws InventoryException {
        return new Inventory(currencys, items, weapons, armor);
    }

}
