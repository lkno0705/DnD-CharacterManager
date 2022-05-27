package terminal.adapters;

import entities.Currencys;
import exceptions.CurrencyException;
import exceptions.HitDieException;
import exceptions.WeaponException;
import factories.InventoryFactory;
import terminal.datacontainers.CharacterDataContainer;
import valueobjects.Armor;
import valueobjects.HitDie;
import valueobjects.Weapon;

import java.util.HashMap;

public class InventoryAdapter {

    public static CharacterDataContainer buildStarterInventory(CharacterDataContainer characterDataContainer) {

        try {
            characterDataContainer.setInventory(
                    new InventoryFactory()
                            .currencys(new Currencys(10, 10, 10, 10, 10))
                            .items(new HashMap<String, Integer>() {{
                                put("Adventurers Kit", 1);
                            }})
                            .weapons(new Weapon[]{new Weapon("Harte Hantel Hartholz", new HitDie(10, 1), false)})
                            .armor(new Armor("Leather Armor", 2, false, 4, 13))
                            .build()
            );
        } catch (Exception e) {
            System.out.println("ERROR couldn't create Inventory!");
        }
        return characterDataContainer;
    }

}
