package factories;

import exceptions.BackgroundException;
import exceptions.PersonalityException;
import exceptions.SkillProficiencyException;
import valueobjects.Background;
import valueobjects.Personality;
import valueobjects.SkillProficiencies;

import java.util.HashMap;
import java.util.List;

public class BackgroundFactory {

    private Personality personality;
    private SkillProficiencies skillProficiencies;
    private List<String> languages;
    private HashMap<String, int> equipment;
    private List<String> toolProficiencies;
    private String name;

    public BackgroundFactory(){}

    public BackgroundFactory personality(Personality personality){
        this.personality = personality;
        return this;
    }

    public BackgroundFactory name(String name){
        this.name = name;
        return this;
    }

    public BackgroundFactory personality(String[] personalityTraits, String[] ideal, String[] bond, String[] flaw) throws PersonalityException {
        this.personality = new Personality(personalityTraits, ideal, bond, flaw);
        return this;
    }

    public BackgroundFactory skillProficiencies(SkillProficiencies skillProficiencies){
        this.skillProficiencies = skillProficiencies;
        return this;
    }

    public BackgroundFactory skillProficiencies(HashMap<String, boolean> skillProficiencies) throws SkillProficiencyException {
        this.skillProficiencies = new SkillProficiencies(skillProficiencies);
        return this;
    }

    public BackgroundFactory languages(List<String> languages){
        this.languages = languages;
        return this;
    }

    public BackgroundFactory equipment(HashMap<String, int> equipment){
        this.equipment = equipment;
        return this;
    }

    public BackgroundFactory toolProficiencies(List<String> toolProficiencies){
        this.toolProficiencies = toolProficiencies;
        return this;
    }

    public Background build() throws BackgroundException {
        return new Background(personality, skillProficiencies, languages, equipment, toolProficiencies, name);
    }
}
