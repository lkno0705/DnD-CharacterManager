package character;

import aggregates.RPGCharacter;
import exceptions.InventoryException;
import repositorys.RepositoryService;
import valueobjects.Armor;
import valueobjects.Weapon;

public class InventoryService {

    private final RPGCharacter character;
    private final RepositoryService rpgCharacterRepositoryService;

    public InventoryService(RPGCharacter character, RepositoryService rpgCharacterRepositoryService){
        this.character = character;
        this.rpgCharacterRepositoryService = rpgCharacterRepositoryService;
    }

    public RPGCharacter addItem(String itemName, int amount){
        this.character.getInventory().addItem(itemName, amount);
        this.rpgCharacterRepositoryService.updateCharacter(this.character);
        return this.character;
    }

    public RPGCharacter removeItem(String name, int amount){
        this.character.getInventory().removeItem(name, amount);
        this.rpgCharacterRepositoryService.updateCharacter(this.character);
        return this.character;
    }

    public RPGCharacter addWeapon(Weapon weapon) throws InventoryException {
        this.character.getInventory().addWeapon(weapon);
        this.rpgCharacterRepositoryService.updateCharacter(this.character);
        return this.character;
    }

    public RPGCharacter removeWeapon(Weapon weapon){
        this.character.getInventory().removeWeapon(weapon);
        this.rpgCharacterRepositoryService.updateCharacter(this.character);
        return this.character;
    }

    public RPGCharacter addArmor(Armor armor){
        this.character.getInventory().addArmor(armor);
        this.rpgCharacterRepositoryService.updateCharacter(this.character);
        return this.character;
    }

    public RPGCharacter removeArmor(){
        this.character.getInventory().removeArmor();
        this.rpgCharacterRepositoryService.updateCharacter(this.character);
        return this.character;
    }

    public RPGCharacter changeArmor(Armor armor){
        this.character.getInventory().changeArmor(armor);
        this.rpgCharacterRepositoryService.updateCharacter(this.character);
        return this.character;
    }

}
