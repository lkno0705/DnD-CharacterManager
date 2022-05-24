package terminal.adapters;

import terminal.datacontainers.CharacterDataContainer;
import valueobjects.classes.Fighter;

public class CharacterClassAdapter {


    public static void buildFighter(CharacterDataContainer characterDataContainer){
        try {
           characterDataContainer.setCharacterClass(Fighter.build(characterDataContainer.getAttributes().getConstMod()));
        } catch (Exception e) {
            System.out.println("ERROR: Could not create Fighter Class");
        }
    }

}
