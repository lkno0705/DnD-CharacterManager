package entities;

import exceptions.CharacterClassException;
import factories.CharacterClassFactory;
import valueobjects.HitDie;
import valueobjects.SavingThrowProficiencies;
import valueobjects.SkillProficiencies;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class CharacterClass {

    private int proficiencyBonus;
    private int level;
    private List<String> languages;
    private SkillProficiencies skillProficiencys;
    private SavingThrowProficiencies savingThrowProficiencys;
    private int currentHP;
    private int maxHP;
    private List<HitDie> hitDice;
    private final String name;
    private UUID id;

    public CharacterClass(int proficiencyBonus, int level, List<String> languages, SkillProficiencies skillProficiencys, SavingThrowProficiencies savingThrowProficiencys, int constitutionModifier, List<HitDie> hitDice, String name) throws CharacterClassException {
        if (proficiencyBonus > 0) this.proficiencyBonus = proficiencyBonus;
        else throw new CharacterClassException("Invalid proficiency Bonus: " + proficiencyBonus);

        if(level > 0) this.level = level;
        else throw new CharacterClassException("Invalid level: " + level);

        if(languages != null) this.languages = languages;
        else throw new CharacterClassException("Languages can not be null");

        if(skillProficiencys != null) this.skillProficiencys = skillProficiencys;
        else throw new CharacterClassException("Skill proficiencys can not be null");

        if(savingThrowProficiencys != null) this.savingThrowProficiencys = savingThrowProficiencys;
        else throw new CharacterClassException("Saving Throw proficiencys can not be null");

        if(hitDice != null) this.hitDice = hitDice;
        else throw new CharacterClassException("Hit Dice can not be null");

        if(!name.equals("")) this.name = name;
        else throw new CharacterClassException("Name can not be null");

        this.maxHP = calculateMaxHP(constitutionModifier);
        this.currentHP = this.maxHP;
        this.id = UUID.randomUUID();
    }

    private int calculateMaxHP(int constitutionModifier) throws CharacterClassException {
        int hiDiceSum = 0;
        for (HitDie hitDie: hitDice) {
            hiDiceSum += hitDie.getDieType();
        }
        int maxHP = hiDiceSum + constitutionModifier;
        if (maxHP > 0) return maxHP;
        else throw new CharacterClassException("Invalid Maximum HP: " + maxHP);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterClass that = (CharacterClass) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getProficiencyBonus() {
        return proficiencyBonus;
    }

    public int getLevel() {
        return level;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public SkillProficiencies getSkillProficiencys() {
        return skillProficiencys;
    }

    public SavingThrowProficiencies getSavingThrowProficiencys() {
        return savingThrowProficiencys;
    }

    public int getHP() {
        return currentHP;
    }

    public List<HitDie> getHitDice() {
        return hitDice;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public void setHitDice(List<HitDie> hitDice, int constMod) throws CharacterClassException {
        this.hitDice = hitDice;
        this.maxHP = calculateMaxHP(constMod);
    }

    public static CharacterClassFactory builder() { return new CharacterClassFactory();}
}
