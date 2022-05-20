package valueobjects;

import exceptions.SkillProficiencyException;

import java.util.*;

public final class SkillProficiencies {

    final HashMap<String, Boolean> skillProficiencies;

    public SkillProficiencies(HashMap<String, Boolean> skillProficiencies) throws SkillProficiencyException {
        if (isValid(skillProficiencies)) this.skillProficiencies = skillProficiencies;
        else throw new SkillProficiencyException("Invalid SkillProficiencies");
    }

    private boolean isValid(HashMap<String, Boolean> skillProficiencies){
        final Set<String> allowedSkillProficiencies = new HashSet<>(Arrays.asList(
                "Acrobatics",
                "AnimalHandling",
                "Arcana",
                "Athletics",
                "Deception",
                "History",
                "Insight",
                "Intimidation",
                "Investigation",
                "Medicine",
                "Nature",
                "Perception",
                "Performance",
                "Persuasion",
                "Religion",
                "SleightofHand",
                "Stealth",
                "Survival"
        ));
        Set<String> proficiencieKeys = skillProficiencies.keySet();
        return (allowedSkillProficiencies.containsAll(proficiencieKeys) && proficiencieKeys.containsAll(allowedSkillProficiencies));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkillProficiencies that = (SkillProficiencies) o;
        return Objects.equals(skillProficiencies, that.skillProficiencies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skillProficiencies);
    }

    public HashMap<String, Boolean> getSkillProficiencies() {
        return skillProficiencies;
    }
}
