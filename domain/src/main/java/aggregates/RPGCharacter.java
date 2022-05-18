package aggregates;

import entities.CharacterRace;
import entities.DeathSaves;
import exceptions.RPGCharacterException;
import factories.RPGCharacterFactory;
import valueobjects.Background;
import valueobjects.Player;
import entities.CharacterClass;

import java.util.Objects;
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

    public RPGCharacter(CharacterRace race, CharacterClass characterClass, Background background, Inventory inventory, String name, Attributes attributes, DeathSaves deathSaves, Player player, int xp, int age) throws RPGCharacterException {
        if(race != null) this.race = race;
        else throw new RPGCharacterException("Race can not be null");

        if(characterClass != null) this.characterClass = characterClass;
        else throw new RPGCharacterException("Character Class can not be null");

        if(background != null) this.background = background;
        else throw new RPGCharacterException("Background can not be null");

        if(inventory != null) this.inventory = inventory;
        else throw new RPGCharacterException("Inventory can not be null");

        if(!name.equals("")) this.name = name;
        else throw new RPGCharacterException("Invalid Name: " + name);

        if(attributes != null) this.attributes = attributes;
        else throw new RPGCharacterException("Attributes can not be null");

        if(deathSaves != null) this.deathSaves = deathSaves;
        else throw new RPGCharacterException("Death Saves can not be null");

        if(player != null) this.player = player;
        else throw new RPGCharacterException("Player can not be null");

        if(xp >= 0) this.xp = xp;
        else throw new RPGCharacterException("Invalid xp: " + xp);

        if(age >= this.race.getAgeRange().getMinimumAge() && age <= this.race.getAgeRange().getMaximumAge()) this.age = age;
        else throw new RPGCharacterException("Invalid Age: " + age + "for the selected race");
        this.id = UUID.randomUUID();
    }

    public int getLevel(){
        return characterClass.getLevel();
    }

    public int getAC(){
        // dex + 10 + Armor (if Armor in inventory)
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RPGCharacter that = (RPGCharacter) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static RPGCharacterFactory builder(){
        return new RPGCharacterFactory();
    }


}
