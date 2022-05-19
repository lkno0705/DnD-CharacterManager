package character;

import aggregates.Attributes;
import aggregates.Inventory;
import aggregates.RPGCharacter;
import entities.CharacterClass;
import entities.CharacterRace;
import entities.DeathSaves;
import exceptions.RPGCharacterException;
import factories.RPGCharacterFactory;
import repositorys.*;
import valueobjects.Background;
import valueobjects.HitDie;
import valueobjects.Player;
import valueobjects.Weapon;

import java.util.HashMap;

public class CharacterService {

    private RPGCharacter character;
    private RepositoryService rpgCharacterRepositoryService;

    public CharacterService(RPGCharacter character, RepositoryService repositoryService) {
        this.character = character;
        this.rpgCharacterRepositoryService = repositoryService;
    }

    public CharacterService(RPGCharacter character) {
        this.character = character;
        this.rpgCharacterRepositoryService = new RepositoryService();
    }

    public void updateCharacter(RPGCharacter rpgCharacter) {
        this.character = rpgCharacter;
        this.rpgCharacterRepositoryService.updateCharacter(rpgCharacter);
    }

    private String displayHashmap(HashMap<String, int> hashMap) {
        StringBuilder builder = new StringBuilder();
        for (String key : hashMap.keySet()) {
            builder.append(key).append(": ").append(hashMap.get(key)).append("\n    ");
        }
        return builder.toString();
    }

    public String displayCharacter() {

        StringBuilder hitDice = new StringBuilder();
        for (HitDie hitDie : this.character.getCharacterClass().getHitDice()) {
            hitDice.append(hitDie.toString());
        }
        StringBuilder weapons = new StringBuilder();
        Weapon[] weaponArray = this.character.getInventory().getWeapons();
        for (Weapon weapon : weaponArray) {
            weapons
                    .append(weapon.getName())
                    .append(": Damage die=(d")
                    .append(weapon.getDamageDie().getDieType())
                    .append(",")
                    .append(weapon.getDamageDie().getAmount())
                    .append(weapon.isFinesse() ? "finesse" : "")
                    .append("\n        ");
        }

        return "Character: " + this.character.getName() +
                "\n    Class: " + this.character.getCharacterClass().getName() +
                "\n    Level: " + this.character.getLevel() +
                "\n    Background: " + this.character.getBackground().getName() +
                "\n    Player Name: " + this.character.getPlayer().getFirstName() + " " + this.character.getPlayer().getLastName() +
                "\n    Race: " + this.character.getRace().getRaceName() +
                "\n    XP: " + this.character.getXp() +
                "\n    Age: " + this.character.getAge() +
                "\n    Proficiency Bonus: " + this.character.getCharacterClass().getProficiencyBonus() +
                "\n    ArmorClass: " + this.character.getAC() +
                "\n    Speed: " + this.character.getRace().getSpeed() +
                "\n    maxHP: " + this.character.getCharacterClass().getMaxHP() +
                "\n    CurrentHP: " + this.character.getCharacterClass().getCurrentHP() +
                "\n    Hit Dice: " + hitDice +
                "\n    Death Saves: " + this.character.getDeathSaves().toString() +
                "\n    Personality: " + this.character.getBackground().getPersonality().toString() +
                "\n    isDead: " + this.character.isDead() +
                "\n---------------------Attributes------------------------" +
                "\n    Strength: " + this.character.getAttributes().getStrength() +
                "\n    Strength Modifier: " + this.character.getAttributes().getStrengthMod() +
                "\n    Dexterity: " + this.character.getAttributes().getDexterity() +
                "\n    DexterityModifier: " + this.character.getAttributes().getDexMod() +
                "\n    Consitution: " + this.character.getAttributes().getConstitution() +
                "\n    Constitution Modifier: " + this.character.getAttributes().getConstMod() +
                "\n    Intelligence: " + this.character.getAttributes().getIntelligence() +
                "\n    Intelligence Modifier: " + this.character.getAttributes().getIntMod() +
                "\n    Wisdom: " + this.character.getAttributes().getWisdom() +
                "\n    Wisdom Modifier: " + this.character.getAttributes().getWisdomMod() +
                "\n    Charisma: " + this.character.getAttributes().getCharisma() +
                "\n    Charisma Modifier: " + this.character.getAttributes().getCharisma() +
                "\n---------------------Saving Throws------------------------" +
                "\n    " + displayHashmap(this.character.getSavingThrows()) +
                "\n---------------------Skills------------------------" +
                "\n    " + displayHashmap(this.character.getSkills()) +
                "\n---------------------Inventory------------------------" +
                "\n    CP" + this.character.getInventory().getCurrencys().getCP() +
                "\n    SP" + this.character.getInventory().getCurrencys().getSP() +
                "\n    EP" + this.character.getInventory().getCurrencys().getEP() +
                "\n    GP" + this.character.getInventory().getCurrencys().getGP() +
                "\n    PP" + this.character.getInventory().getCurrencys().getPP() +
                "\n    PP" + this.character.getInventory().getCurrencys().getPP() +
                "\n    Items:" + "\n        " + displayHashmap(this.character.getInventory().getItems()) +
                "\n    Weapons:" + "\n        " + weapons +
                "\n    Armor: " + this.character.getInventory().getArmor().toString();
    }

    public static RPGCharacter createNewCharacter(CharacterRace characterRace, CharacterClass characterClass, Background background, Inventory inventory, String name, Attributes attributes, DeathSaves deathSaves, Player player, int xp, int age) throws RPGCharacterException {
        RPGCharacter character = new RPGCharacterFactory()
                .race(characterRace)
                .characterClass(characterClass)
                .background(background)
                .inventory(inventory)
                .name(name)
                .attributes(attributes)
                .deathSaves(deathSaves)
                .player(player)
                .xp(xp)
                .age(age)
                .build();
        if(background.getEquipment() != null) for (String itemName: background.getEquipment().keySet()) {
            character.getInventory().addItem(itemName, background.getEquipment().get(itemName));
        }
        return character;
    }

    public static RPGCharacter createNewCharacter(CharacterRace characterRace, CharacterClass characterClass, Background background, Inventory inventory, String name, Attributes attributes, Player player, int age) throws RPGCharacterException {
        RPGCharacter character =  new RPGCharacterFactory()
                .race(characterRace)
                .characterClass(characterClass)
                .background(background)
                .inventory(inventory)
                .name(name)
                .attributes(attributes)
                .deathSaves()
                .player(player)
                .xp(0)
                .age(age)
                .build();
        if(background.getEquipment() != null) for (String itemName: background.getEquipment().keySet()) {
            character.getInventory().addItem(itemName, background.getEquipment().get(itemName));
        }
        return character;
    }

    public RPGCharacter takeDamage(int damage) {
        if (Math.abs(this.character.getCharacterClass().getCurrentHP() - damage) > this.character.getCharacterClass().getMaxHP()) {
            die();
        } else {
            this.character.getCharacterClass().setCurrentHP(Math.max(this.character.getCharacterClass().getCurrentHP() - damage, 0));
        }
        this.rpgCharacterRepositoryService.updateCharacter(this.character);
        return this.character;
    }

    public RPGCharacter heal(int amount) {
        this.character.getCharacterClass().setCurrentHP(this.character.getCharacterClass().getCurrentHP() + amount);
        this.character.getDeathSaves().reset();
        this.rpgCharacterRepositoryService.updateCharacter(this.character);
        return this.character;
    }

    public RPGCharacter deathSaves(int roll) {
        if (roll == 20) {
            this.character.getDeathSaves().setSuccess();
            this.character.getDeathSaves().setSuccess();
        } else if (roll >= 10) {
            this.character.getDeathSaves().setSuccess();
        } else if (roll == 1) {
            this.character.getDeathSaves().setFailure();
            this.character.getDeathSaves().setFailure();
        } else this.character.getDeathSaves().setFailure();
        if (this.character.getDeathSaves().getFailures() == 3) {
            die();
        }
        if (this.character.getDeathSaves().getSuccesses() == 3) {
            this.character.getDeathSaves().reset();
            this.character.getCharacterClass().setCurrentHP(1);
        }
        return this.character;
    }

    public void die() {
        this.character.setDead();
        this.rpgCharacterRepositoryService.moveCharacterToGraveyard(this.character);
    }
}
