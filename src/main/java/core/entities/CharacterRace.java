package core.entities;

import core.valueobjects.AgeRange;
import core.valueobjects.AttributeBonus;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public abstract class CharacterRace {

    private List<AttributeBonus> attributeBoni;
    private int speed;
    private List<String> languages;
    private final AgeRange ageRange;
    private final Character size;
    private List<String> traits;
    private HashMap<String, Boolean> equipmentProficiencies;
    private CharacterRace subRace;
    private final UUID id;

    public CharacterRace(List<AttributeBonus> attributeBoni, int speed, List<String> languages, AgeRange ageRange, Character size, List<String> traits, HashMap<String, Boolean> equipmentProficiencies, CharacterRace subRace) {
        this.attributeBoni = attributeBoni;
        this.speed = speed;
        this.languages = languages;
        this.ageRange = ageRange;
        this.size = size;
        this.traits = traits;
        this.equipmentProficiencies = equipmentProficiencies;
        this.subRace = subRace;
        this.id = UUID.randomUUID();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterRace that = (CharacterRace) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public List<AttributeBonus> getAttributeBoni() {
        return attributeBoni;
    }

    public int getSpeed() {
        return speed;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public AgeRange getAgeRange() {
        return ageRange;
    }

    public Character getSize() {
        return size;
    }

    public List<String> getTraits() {
        return traits;
    }

    public HashMap<String, Boolean> getEquipmentProficiencies() {
        return equipmentProficiencies;
    }

    public CharacterRace getSubRace() {
        return subRace;
    }

    public UUID getId() {
        return id;
    }
}
