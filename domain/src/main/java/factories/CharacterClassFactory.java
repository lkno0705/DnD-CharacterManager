package factories;

import entities.CharacterClass;
import exceptions.CharacterClassException;
import exceptions.SavingThrowException;
import exceptions.SkillProficiencyException;
import valueobjects.HitDie;
import valueobjects.SavingThrowProficiencies;
import valueobjects.SkillProficiencies;

import java.util.HashMap;
import java.util.List;

public class CharacterClassFactory {

    private int proficiencyBonus;
    private int level;
    private List<String> languages;
    private SkillProficiencies skillProficiencies;
    private SavingThrowProficiencies savingThrowProficiencys;
    private int constitutionModifier;
    private String name;
    private List<HitDie> hitDice;

    public CharacterClassFactory(){}

    public CharacterClassFactory proficiencyBonus(int proficiencyBonus){
        this.proficiencyBonus = proficiencyBonus;
        return this;
    }

    public CharacterClassFactory level(int level){
        this.level = level;
        return this;
    }

    public CharacterClassFactory languages(List<String> languages){
        this.languages = languages;
        return this;
    }

    public CharacterClassFactory skillProficiencies(SkillProficiencies skillProficiencies){
        this.skillProficiencies = skillProficiencies;
        return this;
    }

    public CharacterClassFactory skillProficiencies(HashMap<String, boolean> skillProficiencies) throws SkillProficiencyException {
        this.skillProficiencies = new SkillProficiencies(skillProficiencies);
        return this;
    }

    public CharacterClassFactory savingThrowProficiencies(SavingThrowProficiencies savingThrowProficiencys){
        this.savingThrowProficiencys = savingThrowProficiencys;
        return this;
    }

    public CharacterClassFactory savingThrowProficiencies(HashMap<String, boolean> savingThrowProficiencies) throws SavingThrowException {
        this.savingThrowProficiencys = new SavingThrowProficiencies(savingThrowProficiencies);
        return this;
    }

    public CharacterClassFactory constitutionModifier(int constitutionModifier){
        this.constitutionModifier = constitutionModifier;
        return this;
    }

    public CharacterClassFactory hitDice(List<HitDie> hitDice){
        this.hitDice = hitDice;
        return this;
    }

    public CharacterClassFactory name(String name){
        this.name = name;
        return this;
    }

    public CharacterClass build() throws CharacterClassException {
        return new CharacterClass(proficiencyBonus, level, languages, skillProficiencies, savingThrowProficiencys, constitutionModifier, hitDice, name);
    }

}
