package entities;

import exceptions.CharacterRaceException;
import factories.CharacterRaceFactory;
import valueobjects.AgeRange;
import valueobjects.AttributeBoni;
import valueobjects.CharacterSize;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class CharacterRace {

    private AttributeBoni attributeBoni;
    private int speed;
    private List<String> languages;
    private final AgeRange ageRange;
    private CharacterSize size;
    private final String raceName;
    private final UUID id;

    public CharacterRace(AttributeBoni attributeBoni, int speed, List<String> languages, AgeRange ageRange, CharacterSize size, String raceName) throws CharacterRaceException {
        if(attributeBoni != null) this.attributeBoni = attributeBoni;
        else throw new CharacterRaceException("Attributeboni can not be null");

        if(speed > 0) this.speed = speed;
        else throw new CharacterRaceException("Invalid Speed: " + speed);

        if(languages != null) this.languages = languages;
        else throw new CharacterRaceException("Languages can not be null");

        if(ageRange != null) this.ageRange = ageRange;
        else throw new CharacterRaceException("Age range can not be null");

        if(size != null) this.size = size;
        else throw new CharacterRaceException("Character size can not be null");

        if(!raceName.equals("")) this.raceName = raceName;
        else throw new CharacterRaceException("RaceName can not be null");
        this.id = UUID.randomUUID();
    }

    public void setAttributeBoni(AttributeBoni attributeBoni) {
        this.attributeBoni = attributeBoni;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
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

    public AttributeBoni getAttributeBoni() {
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

    public String getRaceName() {
        return raceName;
    }

    public UUID getId() {
        return id;
    }

    public static CharacterRaceFactory builder(){
        return new CharacterRaceFactory();
    }
}
