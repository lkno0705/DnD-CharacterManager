package entities;

import valueobjects.AgeRange;
import valueobjects.CharacterSize;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public abstract class CharacterRace {

    private HashMap<String, Integer> attributeBoni;
    private int speed;
    private List<String> languages;
    private AgeRange ageRange;
    private CharacterSize size;
    private final UUID id;

    public CharacterRace() {
        this.id = UUID.randomUUID();
    }

    public CharacterRace(HashMap<String, Integer> attributeBoni, int speed, List<String> languages, AgeRange ageRange, CharacterSize size) {
        this.attributeBoni = attributeBoni;
        this.speed = speed;
        this.languages = languages;
        this.ageRange = ageRange;
        this.size = size;
        this.id = UUID.randomUUID();
    }

    public void setAttributeBoni(HashMap<String, Integer> attributeBoni) {
        this.attributeBoni = attributeBoni;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public void setAgeRange(AgeRange ageRange) {
        this.ageRange = ageRange;
    }

    public void setSize(CharacterSize size) {
        this.size = size;
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

    public CharacterSize getSize() {
        return size;
    }

    public HashMap<String, Integer> getAttributeBoni() {
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

    public UUID getId() {
        return id;
    }
}
