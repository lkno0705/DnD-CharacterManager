package valueobjects;

import exceptions.BackgroundException;
import factories.BackgroundFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public final class Background {

    final Personality personality;
    final SkillProficiencies skillProficiencies;
    final List<String> languages;
    final HashMap<String, Integer> equipment;
    final String name;
    final List<String> toolProficiencies;

    public Background(Personality personality, SkillProficiencies skillProficiencies, List<String> languages, HashMap<String, Integer> equipment, List<String> toolProficiencies, String name) throws BackgroundException {
        if (personality != null) this.personality = personality;
        else throw new BackgroundException("personality can not be null");

        this.skillProficiencies = skillProficiencies;

        if (languages != null) this.languages = languages;
        else throw new BackgroundException("Languages can not be null");

        if (equipment != null) this.equipment = equipment;
        else throw new BackgroundException("Equipment can not be null");

        if (toolProficiencies != null) this.toolProficiencies = toolProficiencies;
        else throw new BackgroundException("Tool Proficiencies can not be null");

        if(!name.equals("")) this.name = name;
        else throw new BackgroundException("Name can not be null");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Background that = (Background) o;
        return Objects.equals(personality, that.personality) && Objects.equals(skillProficiencies, that.skillProficiencies) && Objects.equals(languages, that.languages) && Objects.equals(equipment, that.equipment) && Objects.equals(toolProficiencies, that.toolProficiencies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personality, skillProficiencies, languages, equipment, toolProficiencies);
    }

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

    public String getName() {
        return name;
    }

    public List<String> getToolProficiencies() {
        return toolProficiencies;
    }

    public static BackgroundFactory builder(){ return new BackgroundFactory();}

}
