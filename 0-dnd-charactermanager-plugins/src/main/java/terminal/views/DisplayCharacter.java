package terminal.views;

import character.CharacterService;

public class DisplayCharacter {

    public static void draw(CharacterService characterService) {
        System.out.println(characterService.displayCharacter());
        System.out.println();
    }
}
