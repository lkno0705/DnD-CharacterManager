package terminal.adapters;

import terminal.datacontainers.CharacterDataContainer;
import valueobjects.races.Human;

public class CharacterRaceAdapters {

    public static CharacterDataContainer buildHuman(CharacterDataContainer characterDataContainer){
        try {
            characterDataContainer.setCharacterRace(Human.build());
        } catch (Exception e) {
            System.out.println("ERROR: Could not create Fighter Class");
        }
        return characterDataContainer;
    }

}
