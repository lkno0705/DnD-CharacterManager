package aggregates;

import entities.CharacterClass;
import entities.CharacterRace;
import entities.DeathSaves;
import exceptions.RPGCharacterException;
import factories.RPGCharacterFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import valueobjects.*;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RPGCharacterTest {

    RPGCharacter character;

    @BeforeEach
    public void setup() throws RPGCharacterException {
        buildCharacterForTesting(false, false);
    }

    @Test
    void getAC() throws RPGCharacterException {
        assertEquals(24, this.character.getAC());
        buildCharacterForTesting(false, true);
        assertEquals(26, this.character.getAC());
        buildCharacterForTesting(true, true);
        assertEquals(25, this.character.getAC());
    }

    @Test
    void getSavingThrows() {
        HashMap<String, Integer> expected = new HashMap<>(){{
            put("Strength", 2);
            put("Dexterity", 2);
            put("Constitution", 2);
            put("Intelligence", 0);
            put("Wisdom", 0);
            put("Charisma", 0);
        }};
        assertEquals(expected, this.character.getSavingThrows());
    }

    @Test
    void getSkills() {
        HashMap<String, Integer> expected = new HashMap<>(){{
            put("Acrobatics", 4);
            put("AnimalHandling", 2);
            put("Arcana", 0);
            put("Athletics", 2);
            put("Deception", 0);
            put("History", 2);
            put("Insight", 2);
            put("Intimidation", 2);
            put("Investigation", 0);
            put("Medicine", 2);
            put("Nature", 0);
            put("Perception", 0);
            put("Performance", 0);
            put("Persuasion", 0);
            put("Religion", 0);
            put("SleightofHand", 2);
            put("Stealth", 2);
            put("Survival", 0);
        }};
        assertEquals(expected, this.character.getSkills());
    }

    private void buildCharacterForTesting(boolean withLower, boolean isWithDex) throws RPGCharacterException {
        CharacterClass characterClass = mockClass();
        Armor armor = mockArmor(withLower ? 1 : 3, isWithDex);
        Inventory inventory = mockInventory(armor);
        Attributes attributes = mockAttributes();
        Background background = mockBackground();
        DeathSaves deathSaves = mock(DeathSaves.class);
        Player player = mock(Player.class);
        CharacterRace characterRace = mockRace();
        this.character = new RPGCharacterFactory()
                .characterClass(characterClass)
                .age(15)
                .attributes(attributes)
                .background(background)
                .deathSaves()
                .inventory(inventory)
                .name("Harald")
                .player(player)
                .race(characterRace)
                .xp(0)
                .build();
    }

    private CharacterRace mockRace(){
        AgeRange ageRange = mock(AgeRange.class);
        when(ageRange.getMaximumAge()).thenReturn(100);
        when(ageRange.getMinimumAge()).thenReturn(1);

        CharacterRace race = mock(CharacterRace.class);
        when(race.getAgeRange()).thenReturn(ageRange);
        return race;
    }

    private Background mockBackground() {
        SkillProficiencies skillProficiencies = mock(SkillProficiencies.class);
        when(skillProficiencies.getSkillProficiencies()).thenReturn(new HashMap<>() {{
            put("Acrobatics", true);
            put("AnimalHandling", true);
            put("Arcana", false);
            put("Athletics", true);
            put("Deception", false);
            put("History", true);
            put("Insight", true);
            put("Intimidation", true);
            put("Investigation", false);
            put("Medicine", true);
            put("Nature", false);
            put("Perception", false);
            put("Performance", false);
            put("Persuasion", false);
            put("Religion", false);
            put("SleightofHand", false);
            put("Stealth", false);
            put("Survival", false);
        }});

        Background background = mock(Background.class);
        when(background.getSkillProficiencies()).thenReturn(skillProficiencies);
        return background;
    }

    private Attributes mockAttributes() {
        Attributes attributes = mock(Attributes.class);
        when(attributes.getStrength()).thenReturn(10);
        when(attributes.getStrengthMod()).thenReturn(0);
        when(attributes.getDexterity()).thenReturn(10);
        when(attributes.getDexMod()).thenReturn(2);
        when(attributes.getConstitution()).thenReturn(10);
        when(attributes.getConstMod()).thenReturn(0);
        when(attributes.getIntelligence()).thenReturn(10);
        when(attributes.getIntMod()).thenReturn(0);
        when(attributes.getWisdom()).thenReturn(10);
        when(attributes.getWisdomMod()).thenReturn(0);
        when(attributes.getCharisma()).thenReturn(10);
        when(attributes.getCharismaMod()).thenReturn(0);
        return attributes;
    }

    private Armor mockArmor(int maxDexforArmor, boolean isWithDex){
        Armor armor = mock(Armor.class);
        when(armor.getBaseAC()).thenReturn(4);
        when(armor.getMaxDexBonus()).thenReturn(maxDexforArmor);
        when(armor.isWithDex()).thenReturn(isWithDex);
        return armor;
    }

    private Inventory mockInventory(Armor armor) {
        Inventory inventory = mock(Inventory.class);
        when(inventory.getArmor()).thenReturn(armor);
        return inventory;

    }

    private CharacterClass mockClass() {
        SkillProficiencies skillProficiencies = mock(SkillProficiencies.class);
        when(skillProficiencies.getSkillProficiencies()).thenReturn(new HashMap<>() {{
            put("Acrobatics", true);
            put("AnimalHandling", true);
            put("Arcana", false);
            put("Athletics", true);
            put("Deception", false);
            put("History", true);
            put("Insight", true);
            put("Intimidation", true);
            put("Investigation", false);
            put("Medicine", false);
            put("Nature", false);
            put("Perception", false);
            put("Performance", false);
            put("Persuasion", false);
            put("Religion", false);
            put("SleightofHand", false);
            put("Stealth", false);
            put("Survival", false);
        }});

        SavingThrowProficiencies savingThrowProficiencies = mock(SavingThrowProficiencies.class);
        when(savingThrowProficiencies.getSavingThrowProficiencies()).thenReturn(new HashMap<>() {{
            put("Strength", true);
            put("Dexterity", false);
            put("Constitution", true);
            put("Intelligence", false);
            put("Wisdom", false);
            put("Charisma", false);
        }});

        CharacterClass characterClass = mock(CharacterClass.class);
        when(characterClass.getProficiencyBonus()).thenReturn(2);
        when(characterClass.getSkillProficiencys()).thenReturn(skillProficiencies);
        when(characterClass.getSavingThrowProficiencys()).thenReturn(savingThrowProficiencies);
        return characterClass;
    }


}