package core.entities;

import core.valueobjects.HitDie;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public abstract class CharacterClass {

    private int proficiencyBonus;
    private int level;
    private List<String> languages;
    private HashMap<String, Boolean> skillProficiencys;
    private HashMap<String, Boolean> savingThrowProficiencys;
    private int currentHP;
    private int maxHP;
    private List<HitDie> hitDice;
    private UUID id;

    public CharacterClass(int proficiencyBonus, int level, List<String> languages, HashMap<String, Boolean> skillProficiencys, HashMap<String, Boolean> equipmentProficiencys, HashMap<String, Boolean> savingThrowProficiencys, int maxHP, List<HitDie> hitDice) {
        this.proficiencyBonus = proficiencyBonus;
        this.level = level;
        this.languages = languages;
        this.skillProficiencys = skillProficiencys;
        this.savingThrowProficiencys = savingThrowProficiencys;
        this.maxHP = maxHP;
        this.hitDice = hitDice;
        this.id = UUID.randomUUID();
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

    public HashMap<String, Boolean> getSkillProficiencys() {
        return skillProficiencys;
    }

    public HashMap<String, Boolean> getSavingThrowProficiencys() {
        return savingThrowProficiencys;
    }

    public int getHP() {
        return currentHP;
    }

    public List<HitDie> getHitDice() {
        return hitDice;
    }

    public UUID getId() {
        return id;
    }
}
