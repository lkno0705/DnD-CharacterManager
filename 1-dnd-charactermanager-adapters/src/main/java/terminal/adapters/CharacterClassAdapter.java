package terminal.adapters;

import terminal.datacontainers.CharacterDataContainer;
import valueobjects.classes.Fighter;

public class CharacterClassAdapter {


    public static CharacterDataContainer buildFighter(CharacterDataContainer characterDataContainer){
        try {
           characterDataContainer.setCharacterClass(Fighter.build(characterDataContainer.getAttributes().getConstMod()));
            return characterDataContainer;
        } catch (Exception e) {
            e.printStackTrace();
//            System.out.println("ERROR: Could not create Fighter Class");
        }
        return characterDataContainer;
    }

}
