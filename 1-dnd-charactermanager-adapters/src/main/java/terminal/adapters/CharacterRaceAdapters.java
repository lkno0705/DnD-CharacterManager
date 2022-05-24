package terminal.adapters;

import entities.CharacterRace;
import terminal.datacontainers.CharacterDataContainer;
import valueobjects.races.Human;

public class CharacterRaceAdapters {

    public static void buildHuman(CharacterDataContainer characterDataContainer){
        try {
            characterDataContainer.setCharacterRace(Human.build());
        } catch (Exception e) {
            System.out.println("ERROR: Could not create Fighter Class");
        }
    }

}
