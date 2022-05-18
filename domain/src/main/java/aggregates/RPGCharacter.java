package aggregates;

import core.entities.*;
import entities.CharacterRace;
import entities.DeathSaves;
import factories.RPGCharacterFactory;
import valueobjects.Background;
import valueobjects.Player;
import entities.Attributes;
import entities.CharacterClass;

import java.util.UUID;

public class RPGCharacter {

    private final UUID id;
    private CharacterRace race;
    private CharacterClass characterClass;
    private Background background;
    private Inventory inventory;
    private String name;
    private Attributes attributes;
    private DeathSaves deathSaves;
    private Player player;
    private int xp;
    private int age;

    public RPGCharacter() {
        this.id = UUID.randomUUID();
    }

    public RPGCharacter(CharacterRace race, CharacterClass characterClass, Background background, Inventory inventory, String name, Attributes attributes, DeathSaves deathSaves, Player player, int xp, int age) {
        this.race = race;
        this.characterClass = characterClass;
        this.background = background;
        this.inventory = inventory;
        this.name = name;
        this.attributes = attributes;
        this.deathSaves = deathSaves;
        this.player = player;
        this.xp = xp;
        this.age = age;
        this.id = UUID.randomUUID();
    }

    public int getLevel(){
        return characterClass.getLevel();
    }

    public int getAC(){
        // dex + 10 + Armor (if Armor in inventory)
        return 1;
    }

    public static RPGCharacterFactory builder(){
        return new RPGCharacterFactory();
    }


}
