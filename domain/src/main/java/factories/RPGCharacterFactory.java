package factories;

import aggregates.Inventory;
import aggregates.RPGCharacter;
import entities.Attributes;
import entities.CharacterClass;
import entities.CharacterRace;
import entities.DeathSaves;
import valueobjects.AgeRange;
import valueobjects.Background;
import valueobjects.CharacterSize;
import valueobjects.Player;

import java.util.HashMap;
import java.util.List;

public class RPGCharacterFactory {

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

    public RPGCharacterFactory() {
    }

    // Das für alle Variablen
    public RPGCharacterFactory race(CharacterRace race){
        this.race = race;
        return this;
    }

    // Falls ich die Objekt Kreirung in der Factory zulassen will dann so:
    public RPGCharacterFactory race(HashMap<String, Integer> attributeBoni, int speed, List<String> languages, AgeRange ageRange, CharacterSize size){
        // create new race
        return this;
    }

    public RPGCharacter build() {
        return new RPGCharacter(race, characterClass, background, inventory, name, attributes, deathSaves, player, xp, age);
    }

}
