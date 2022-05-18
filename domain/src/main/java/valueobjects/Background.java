package valueobjects;

import exceptions.BackgroundException;

import java.util.List;
import java.util.Objects;

public final class Background {

    final Personality personality;
    final SkillProficiencies skillProficiencies;
    final List<String> languages;
    final List<String> Equipment;
    final List<String> toolProficiencies;

    public Background(Personality personality, SkillProficiencies skillProficiencies, List<String> languages, List<String> equipment, List<String> toolProficiencies) throws BackgroundException {
        if (personality != null) this.personality = personality;
        else throw new BackgroundException("personality can not be null");

        this.skillProficiencies = skillProficiencies;

        if (languages != null) this.languages = languages;
        else throw new BackgroundException("Languages can not be null");

        if (equipment != null) Equipment = equipment;
        else throw new BackgroundException("Equipment can not be null");

        if (toolProficiencies != null) this.toolProficiencies = toolProficiencies;
        else throw new BackgroundException("Tool Proficiencies can not be null");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Background that = (Background) o;
        return Objects.equals(personality, that.personality) && Objects.equals(skillProficiencies, that.skillProficiencies) && Objects.equals(languages, that.languages) && Objects.equals(Equipment, that.Equipment) && Objects.equals(toolProficiencies, that.toolProficiencies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personality, skillProficiencies, languages, Equipment, toolProficiencies);
    }
}
