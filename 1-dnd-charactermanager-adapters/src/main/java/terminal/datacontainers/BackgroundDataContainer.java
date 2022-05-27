package terminal.datacontainers;

import valueobjects.Personality;
import valueobjects.SkillProficiencies;

import java.util.HashMap;
import java.util.List;

public class BackgroundDataContainer {

    private Personality personality;
    private SkillProficiencies skillProficiencies;
    private List<String> languages;
    private HashMap<String, Integer> equipment;
    private List<String> toolProficiencies;
    private String name;

    public Personality getPersonality() {
        return personality;
    }

    public SkillProficiencies getSkillProficiencies() {
        return skillProficiencies;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public HashMap<String, Integer> getEquipment() {
        return equipment;
    }

    public List<String> getToolProficiencies() {
        return toolProficiencies;
    }

    public String getName() {
        return name;
    }

    public void setPersonality(Personality personality) {
        this.personality = personality;
    }

    public void setSkillProficiencies(SkillProficiencies skillProficiencies) {
        this.skillProficiencies = skillProficiencies;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public void setEquipment(HashMap<String, Integer> equipment) {
        this.equipment = equipment;
    }

    public void setToolProficiencies(List<String> toolProficiencies) {
        this.toolProficiencies = toolProficiencies;
    }

    public void setName(String name) {
        this.name = name;
    }
}
