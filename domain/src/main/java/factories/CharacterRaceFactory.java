package factories;

import entities.CharacterRace;
import exceptions.AgeRangeException;
import exceptions.AttributeBoniException;
import exceptions.CharacterRaceException;
import valueobjects.AgeRange;
import valueobjects.AttributeBoni;
import valueobjects.CharacterSize;

import java.util.HashMap;
import java.util.List;

public class CharacterRaceFactory {

    private AttributeBoni attributeBoni;
    private int speed;
    private List<String> languages;
    private AgeRange ageRange;
    private CharacterSize characterSize;
    private String raceName;

    public CharacterRaceFactory() {}

    public CharacterRaceFactory attributeBoni(AttributeBoni attributeBoni){
        this.attributeBoni = attributeBoni;
        return this;
    }

    public CharacterRaceFactory raceName(String raceName){
        this.raceName = raceName;
        return this;
    }

    public CharacterRaceFactory attributeBoni(HashMap<String, int> attributeBoni) throws AttributeBoniException {
        this.attributeBoni = new AttributeBoni(attributeBoni);
        return this;
    }

    public CharacterRaceFactory speed(int speed){
        this.speed = speed;
        return this;
    }

    public CharacterRaceFactory languages(List<String> languages){
        this.languages = languages;
        return this;
    }

    public CharacterRaceFactory ageRange(AgeRange ageRange){
        this.ageRange = ageRange;
        return this;
    }

    public CharacterRaceFactory ageRange(int minimumAge, int maximumAge) throws AgeRangeException {
        this.ageRange = new AgeRange(minimumAge, maximumAge);
        return this;
    }

    public CharacterRaceFactory characterSize(CharacterSize characterSize){
        this.characterSize = characterSize;
        return this;
    }

    public CharacterRaceFactory characterSize(char size) throws Exception {
        this.characterSize = new CharacterSize(size);
        return this;
    }

    public CharacterRace build() throws CharacterRaceException {
        return new CharacterRace(attributeBoni, speed, languages, ageRange, characterSize, raceName);
    }
}
