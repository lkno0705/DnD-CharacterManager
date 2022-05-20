package aggregates;

import entities.Currencys;
import exceptions.InventoryException;
import exceptions.WeaponException;
import factories.InventoryFactory;
import valueobjects.Armor;
import valueobjects.Weapon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class Inventory {

    private Currencys currencys;
    private HashMap<String, Integer> items;
    private Weapon[] weapons;
    private Armor armor;

    public Inventory(Currencys currencys, HashMap<String, Integer> items, Weapon[] weapons, Armor armor) throws InventoryException {
        this.currencys = currencys;
        this.items = items;
        if (weapons.length < 5) this.weapons = weapons;
        else throw new InventoryException("Invalid Amount of weapons");
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

    public void addWeapon(Weapon weapon) throws InventoryException {
        int pntr = 0;
        int weaponsInList = (int) Arrays.stream(weapons)
                .filter(Objects::nonNull)
                .count();
        if (weaponsInList < 4) {
            for (Weapon weaponLoop : weapons) {
                if (weaponLoop == null) {
                    weapons[pntr] = weapon;
                    break;
                }
                pntr++;
            }
        } else throw new InventoryException("Could not addWeapon, Inventory Full");
    }

    public void removeWeapon(Weapon weapon){
        int pntr = 0;
        for (Weapon weaponLoop : weapons) {
            if (weaponLoop.equals(weapon)) {
                weapons[pntr] = null;
                break;
            }
            pntr++;
        }
    }

    public void removeArmor(){
        this.armor = null;
    }

    public void addArmor(Armor armor){
        if(this.armor != null)  changeArmor(armor);
        else this.armor = armor;
    }

    public void changeArmor(Armor armor){
        if(this.armor == null) addArmor(armor);
        else this.armor = armor;
    }

    public void addItem(String name, int amount) {
        if (items.containsKey(name)) this.items.replace(name, this.items.get(name) + amount);
        else this.items.put(name, amount);
    }

    public void removeItem(String name, int amount) {
        if (items.containsKey(name)) {
            if (items.get(name) - amount <= 0) items.remove(name);
            else items.replace(name, items.get(name) - amount);
        }

    }

    public static InventoryFactory builder() {
        return new InventoryFactory();
    }
}
