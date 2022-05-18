package valueobjects;

import entities.Attribute;
import exceptions.SavingThrowException;

import java.util.*;

public final class SavingThrowProficiencies {

    final HashMap<String, boolean> savingThrowProficiencies;

    public SavingThrowProficiencies(HashMap<String, boolean> savingThrowProficiencies) throws SavingThrowException {
        if (isValid(savingThrowProficiencies)) this.savingThrowProficiencies = savingThrowProficiencies;
        else throw new SavingThrowException("Invalid SkillProficiencies");
    }

    private boolean isValid(HashMap<String, boolean> savingThrowProficiencys){
        final Set<String> allowedSavingThrowProficiencies = new HashSet<>(Arrays.asList(Attribute.validAttributeNames));
        Set<String> proficiencieKeys = savingThrowProficiencys.keySet();
        return (allowedSavingThrowProficiencies.containsAll(proficiencieKeys) && proficiencieKeys.containsAll(allowedSavingThrowProficiencies));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SavingThrowProficiencies that = (SavingThrowProficiencies) o;
        return Objects.equals(savingThrowProficiencies, that.savingThrowProficiencies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(savingThrowProficiencies);
    }
}
