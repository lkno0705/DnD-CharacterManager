package terminal.views.createcharacter;

import terminal.adapters.CharacterRaceAdapters;
import terminal.datacontainers.CharacterDataContainer;
import terminal.datacontainers.TerminalDataContainer;
import terminal.interfaces.TerminalView;
import terminal.utils.Utils;

import java.io.IOException;
import java.util.HashMap;

public class CreateCharacterRace implements TerminalView {

    TerminalDataContainer terminalDataContainer;
    CharacterDataContainer characterDataContainer;
    HashMap<Integer, Runnable> characterRaceJumpTable = new HashMap<>(){{
        put(1, () -> characterDataContainer = CharacterRaceAdapters.buildHuman(characterDataContainer));
    }};

    public CreateCharacterRace(TerminalDataContainer terminalDataContainer, CharacterDataContainer characterDataContainer) {
        this.terminalDataContainer = terminalDataContainer;
        this.characterDataContainer = characterDataContainer;
    }

    @Override
    public void draw() throws IOException {
        System.out.println("Choose between the Following Races:");
        System.out.println("1) Human");
        String in =  Utils.getTerminalInput(terminalDataContainer);
        int input = Utils.convertInputToInt(in);
        if (input == 0){
            return;
        }
        characterRaceJumpTable.get(input).run();
    }

    @Override
    public TerminalDataContainer getTerminalDataContainer() {
        return terminalDataContainer;
    }

    public CharacterDataContainer getCharacterDataContainer() {
        return characterDataContainer;
    }
}
