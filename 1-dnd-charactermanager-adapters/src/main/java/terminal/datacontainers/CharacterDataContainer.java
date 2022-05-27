package terminal.datacontainers;

import aggregates.Attributes;
import aggregates.Inventory;
import aggregates.RPGCharacter;
import character.CharacterService;
import entities.CharacterClass;
import entities.CharacterRace;
import exceptions.RPGCharacterException;
import repositorys.RepositoryService;
import valueobjects.Background;
import valueobjects.Player;

public class CharacterDataContainer {

    CharacterRace characterRace;
    CharacterClass characterClass;
    Background background;
    Inventory inventory;
    String name;
    Attributes attributes;
    Player player;
    int xp;
    int age;
    RepositoryService repositoryService;

    public CharacterDataContainer(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    public void setCharacterRace(CharacterRace characterRace) {
        this.characterRace = characterRace;
    }

    public void setCharacterClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
    }

    public void setBackground(Background background) {
        this.background = background;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public CharacterRace getCharacterRace() {
        return characterRace;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public Background getBackground() {
        return background;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public String getName() {
        return name;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public Player getPlayer() {
        return player;
    }

    public int getXp() {
        return xp;
    }

    public int getAge() {
        return age;
    }

    public RPGCharacter build() {
        try {
            return CharacterService.createNewCharacter(characterRace, characterClass, background, inventory, name, attributes, player, age, repositoryService);

        } catch (RPGCharacterException e) {
            System.out.println("ERROR During Character Creation!");
            return null;
        }
    }
}
