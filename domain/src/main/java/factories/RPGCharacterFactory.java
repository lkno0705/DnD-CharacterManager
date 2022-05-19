package factories;

import aggregates.Inventory;
import aggregates.RPGCharacter;
import aggregates.Attributes;
import entities.*;
import exceptions.*;
import valueobjects.*;

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
    public RPGCharacterFactory race(AttributeBoni attributeBoni, int speed, List<String> languages, AgeRange ageRange, CharacterSize size) throws AttributeBoniException, CharacterRaceException {
        this.race = new CharacterRaceFactory()
                .attributeBoni(attributeBoni)
                .speed(speed)
                .languages(languages)
                .ageRange(ageRange)
                .characterSize(size)
                .build();
        return this;
    }

    public RPGCharacterFactory characterClass(CharacterClass characterClass){
        this.characterClass = characterClass;
        return this;
    }

    public RPGCharacterFactory characterClass(int proficiencyBonus, int level, List<String> languages, SkillProficiencies skillProficiencys, SavingThrowProficiencies savingThrowProficiencys, int constitutionModifier, List<HitDie> hitDice) throws CharacterClassException {
        this.characterClass = new CharacterClassFactory()
                .proficiencyBonus(proficiencyBonus)
                .level(level)
                .languages(languages)
                .skillProficiencies(skillProficiencys)
                .savingThrowProficiencies(savingThrowProficiencys)
                .constitutionModifier(constitutionModifier)
                .hitDice(hitDice)
                .build();
        return this;
    }

    public RPGCharacterFactory background(Background background){
        this.background = background;
        return this;
    }

    public RPGCharacterFactory background(Personality personality, SkillProficiencies skillProficiencies, List<String> languages, HashMap<String, int> equipment, List<String> toolProficiencies) throws BackgroundException {
        this.background = new BackgroundFactory()
                .personality(personality)
                .skillProficiencies(skillProficiencies)
                .languages(languages)
                .equipment(equipment)
                .toolProficiencies(toolProficiencies)
                .build();
        return this;
    }

    public RPGCharacterFactory inventory(Inventory inventory){
        this.inventory = inventory;
        return this;
    }

    public RPGCharacterFactory inventory(Currencys currencys, HashMap<String, int> items, Weapon[] weapons, Armor armor) throws InventoryException {
        this.inventory = new InventoryFactory()
                .currencys(currencys)
                .items(items)
                .weapons(weapons)
                .armor(armor)
                .build();
        return this;
    }

    public RPGCharacterFactory name(String name){
        this.name = name;
        return this;
    }

    public RPGCharacterFactory attributes(Attributes attributes){
        this.attributes = attributes;
        return this;
    }

    public RPGCharacterFactory attributes(Attribute strength, Attribute dexterity, Attribute constitution, Attribute intelligence, Attribute wisdom, Attribute charisma) throws AttributeException {
        this.attributes = new AttributeFactory()
                .strength(strength)
                .dexterity(dexterity)
                .constitution(constitution)
                .intelligence(intelligence)
                .wisdom(wisdom)
                .charisma(charisma)
                .build();
        return this;
    }

    public RPGCharacterFactory attributes(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) throws AttributeException {
        this.attributes = new AttributeFactory()
                .strength(strength)
                .dexterity(dexterity)
                .constitution(constitution)
                .intelligence(intelligence)
                .wisdom(wisdom)
                .charisma(charisma)
                .build();
        return this;
    }

    public RPGCharacterFactory deathSaves(DeathSaves deathSaves){
        this.deathSaves = deathSaves;
        return this;
    }

    public RPGCharacterFactory deathSaves(){
        this.deathSaves = new DeathSaves();
        return this;
    }

    public RPGCharacterFactory player(Player player){
        this.player = player;
        return this;
    }

    public RPGCharacterFactory player(String firstName, String lastName) throws PlayerException {
        this.player = new Player(firstName, lastName);
        return this;
    }

    public RPGCharacterFactory xp(int xp){
        this.xp = xp;
        return this;
    }

    public RPGCharacterFactory age(int age){
        this.age = age;
        return this;
    }

    public RPGCharacter build() throws RPGCharacterException {
        return new RPGCharacter(race, characterClass, background, inventory, name, attributes, deathSaves, player, xp, age);
    }

}
