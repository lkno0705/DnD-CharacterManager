package valueobjects;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public final class Background {

    final Personality personality;
    final HashMap<String, Boolean> skillProficiencies;
    final List<String> languages;
    final List<String> Equipment;
    final List<String> toolProficiencies;

    public Background(Personality personality, HashMap<String, Boolean> skillProficiencies, List<String> languages, List<String> equipment, List<String> toolProficiencies) {
        this.personality = personality;
        this.skillProficiencies = skillProficiencies;
        this.languages = languages;
        Equipment = equipment;
        this.toolProficiencies = toolProficiencies;
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
