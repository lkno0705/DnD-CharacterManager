package aggregates;

import entities.CharacterRace;
import entities.DeathSaves;
import exceptions.RPGCharacterException;
import factories.RPGCharacterFactory;
import valueobjects.Background;
import valueobjects.Player;
import entities.CharacterClass;

import java.util.HashMap;
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
    private boolean isDead;

    public RPGCharacter() {
        this.id = UUID.randomUUID();
    }

    public RPGCharacter(CharacterRace race, CharacterClass characterClass, Background background, Inventory inventory, String name, Attributes attributes, DeathSaves deathSaves, Player player, int xp, int age) throws RPGCharacterException {
        if (race != null) this.race = race;
        else throw new RPGCharacterException("Race can not be null");

        if (characterClass != null) this.characterClass = characterClass;
        else throw new RPGCharacterException("Character Class can not be null");

        if (background != null) this.background = background;
        else throw new RPGCharacterException("Background can not be null");

        if (inventory != null) this.inventory = inventory;
        else throw new RPGCharacterException("Inventory can not be null");

        if (!name.equals("")) this.name = name;
        else throw new RPGCharacterException("Invalid Name: " + name);

        if (attributes != null) this.attributes = attributes;
        else throw new RPGCharacterException("Attributes can not be null");

        if (deathSaves != null) this.deathSaves = deathSaves;
        else throw new RPGCharacterException("Death Saves can not be null");

        if (player != null) this.player = player;
        else throw new RPGCharacterException("Player can not be null");

        if (xp >= 0) this.xp = xp;
        else throw new RPGCharacterException("Invalid xp: " + xp);

        if (age >= this.race.getAgeRange().getMinimumAge() && age <= this.race.getAgeRange().getMaximumAge())
            this.age = age;
        else throw new RPGCharacterException("Invalid Age: " + age + "for the selected race");
        this.id = UUID.randomUUID();
    }

    public int getLevel() {
        return characterClass.getLevel();
    }

    public int getAC() {
        // dex + 10 + Armor (if Armor in inventory)
        int armorAC;
        if (this.inventory.getArmor().isWithDex()) {
            if (this.attributes.getDexMod() < this.inventory.getArmor().getMaxDexBonus())
                armorAC = this.inventory.getArmor().getBaseAC() + this.attributes.getDexMod();
            else armorAC = this.inventory.getArmor().getBaseAC() + this.inventory.getArmor().getMaxDexBonus();
        } else armorAC = this.inventory.getArmor().getBaseAC();
        return this.attributes.getDexterity() + 10 + armorAC;
    }

    public CharacterRace getRace() {
        return race;
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

    public DeathSaves getDeathSaves() {
        return deathSaves;
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

    public HashMap<String, Integer> getSavingThrows() {
        HashMap<String, Boolean> savingThrowProficiencies = this.characterClass.getSavingThrowProficiencys().getSavingThrowProficiencies();
        return new HashMap<>() {{
            put("Strength", savingThrowProficiencies.get("Strength") ? attributes.getStrengthMod() + characterClass.getProficiencyBonus() : attributes.getStrengthMod());
            put("Dexterity", savingThrowProficiencies.get("Dexterity") ? attributes.getDexMod() + characterClass.getProficiencyBonus() : attributes.getDexMod());
            put("Constitution", savingThrowProficiencies.get("Constitution") ? attributes.getConstMod() + characterClass.getProficiencyBonus() : attributes.getConstMod());
            put("Intelligence", savingThrowProficiencies.get("Intelligence") ? attributes.getIntMod() + characterClass.getProficiencyBonus() : attributes.getIntMod());
            put("Wisdom", savingThrowProficiencies.get("Wisdom") ? attributes.getWisdomMod() + characterClass.getProficiencyBonus() : attributes.getWisdomMod());
            put("Charisma", savingThrowProficiencies.get("Charisma") ? attributes.getCharismaMod() + characterClass.getProficiencyBonus() : attributes.getCharismaMod());
        }};

    }

    //Dies ist hier für Daniel Burgers entertainment :3
    public HashMap<String, Integer> getSkills() {
        HashMap<String, Boolean> classSkillProficiencies = this.characterClass.getSkillProficiencys().getSkillProficiencies();
        HashMap<String, Boolean> backgroundSkillProficiencies = this.background.getSkillProficiencies().getSkillProficiencies();
        HashMap<String, Boolean> skillProficiencies = new HashMap<>() {{
            putAll(classSkillProficiencies);
            putAll(backgroundSkillProficiencies);
        }};
        return new HashMap<>() {{
            put("Acrobatics", skillProficiencies.get("Acrobatics") ? attributes.getDexMod() + characterClass.getProficiencyBonus() : attributes.getDexMod());
            put("AnimalHandling", skillProficiencies.get("AnimalHandling") ? attributes.getWisdomMod() + characterClass.getProficiencyBonus() : attributes.getWisdomMod());
            put("Arcana", skillProficiencies.get("Arcana") ? attributes.getIntMod() + characterClass.getProficiencyBonus() : attributes.getIntMod());
            put("Athletics", skillProficiencies.get("Athletics") ? attributes.getStrengthMod() + characterClass.getProficiencyBonus() : attributes.getStrengthMod());
            put("Deception", skillProficiencies.get("Deception") ? attributes.getCharismaMod() + characterClass.getProficiencyBonus() : attributes.getCharismaMod());
            put("History", skillProficiencies.get("History") ? attributes.getIntMod() + characterClass.getProficiencyBonus() : attributes.getIntMod());
            put("Insight", skillProficiencies.get("Insight") ? attributes.getWisdomMod() + characterClass.getProficiencyBonus() : attributes.getWisdomMod());
            put("Intimidation", skillProficiencies.get("Intimidation") ? attributes.getCharismaMod() + characterClass.getProficiencyBonus() : attributes.getCharismaMod());
            put("Investigation", skillProficiencies.get("Investigation") ? attributes.getIntMod() + characterClass.getProficiencyBonus() : attributes.getIntMod());
            put("Medicine", skillProficiencies.get("Medicine") ? attributes.getWisdomMod() + characterClass.getProficiencyBonus() : attributes.getWisdomMod());
            put("Nature", skillProficiencies.get("Nature") ? attributes.getIntMod() + characterClass.getProficiencyBonus() : attributes.getIntMod());
            put("Perception", skillProficiencies.get("Perception") ? attributes.getWisdomMod() + characterClass.getProficiencyBonus() : attributes.getWisdomMod());
            put("Performance", skillProficiencies.get("Performance") ? attributes.getCharismaMod() + characterClass.getProficiencyBonus() : attributes.getCharismaMod());
            put("Persuasion", skillProficiencies.get("Persuasion") ? attributes.getCharismaMod() + characterClass.getProficiencyBonus() : attributes.getCharismaMod());
            put("Religion", skillProficiencies.get("Religion") ? attributes.getIntMod() + characterClass.getProficiencyBonus() : attributes.getIntMod());
            put("SleightofHand", skillProficiencies.get("SleightofHand") ? attributes.getDexMod() + characterClass.getProficiencyBonus() : attributes.getDexMod());
            put("Stealth", skillProficiencies.get("Stealth") ? attributes.getDexMod() + characterClass.getProficiencyBonus() : attributes.getDexMod());
            put("Survival", skillProficiencies.get("Survival") ? attributes.getWisdomMod() + characterClass.getProficiencyBonus() : attributes.getWisdomMod());
        }};
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

    public static RPGCharacterFactory builder() {
        return new RPGCharacterFactory();
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead() {
        isDead = true;
    }
}
