package valueobjects.classes;

import entities.CharacterClass;
import exceptions.CharacterClassException;
import exceptions.HitDieException;
import exceptions.SavingThrowException;
import exceptions.SkillProficiencyException;
import factories.CharacterClassFactory;
import valueobjects.HitDie;
import valueobjects.SkillProficiencies;

import java.util.Arrays;
import java.util.HashMap;

public final class Fighter {

    public static CharacterClass build(int constitutionModifier) throws SkillProficiencyException, SavingThrowException, HitDieException, CharacterClassException {
        return new CharacterClassFactory()
                .proficiencyBonus(2)
                .level(1)
                .languages(Arrays.asList("Common"))
                .skillProficiencies(
                        new HashMap<>() {{
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
                            put("SleightofHand", true);
                            put("Stealth", true);
                            put("Survival", false);
                        }}
                )
                .savingThrowProficiencies(
                        new HashMap<>() {{
                            put("Strength", true);
                            put("Dexterity", false);
                            put("Constitution", true);
                            put("Intelligence", false);
                            put("Wisdom", false);
                            put("Charisma", false);
                        }}
                )
                .constitutionModifier(constitutionModifier)
                .hitDice(Arrays.asList(
                        new HitDie(10, 1)
                ))
                .name("Fighter")
                .build();
    }
}
