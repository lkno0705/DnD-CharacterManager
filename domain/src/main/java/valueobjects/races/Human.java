package valueobjects.races;

import entities.CharacterRace;
import factories.CharacterRaceFactory;

import java.util.Arrays;
import java.util.HashMap;

public final class Human {

    public static CharacterRace build() throws Exception {
        return new CharacterRaceFactory()
                .attributeBoni(
                        new HashMap<String, int>() {{
                            put("Strength", 1);
                            put("Dexterity", 1);
                            put("Constitution", 1);
                            put("Intelligence", 1);
                            put("Wisdom", 1);
                            put("Charisma", 1);
                        }}
                )
                .speed(30)
                .languages(Arrays.asList("Common"))
                .ageRange(1,100)
                .characterSize('M')
                .build();
    }
}
