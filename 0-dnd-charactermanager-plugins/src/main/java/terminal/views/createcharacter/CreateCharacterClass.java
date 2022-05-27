package terminal.views.createcharacter;

import terminal.adapters.CharacterClassAdapter;
import terminal.datacontainers.CharacterDataContainer;
import terminal.datacontainers.TerminalDataContainer;
import terminal.interfaces.TerminalView;
import terminal.utils.Utils;
import valueobjects.classes.Fighter;

import java.io.IOException;
import java.util.HashMap;

public class CreateCharacterClass implements TerminalView {

    private TerminalDataContainer terminalDataContainer;
    private CharacterDataContainer characterDataContainer;
    private HashMap<Integer, Runnable> characterClassJumpTable = new HashMap<>(){{
        put(1,() -> {
            characterDataContainer = CharacterClassAdapter.buildFighter(characterDataContainer);
        });
    }};

    public CreateCharacterClass(TerminalDataContainer terminalDataContainer, CharacterDataContainer characterDataContainer) {
        this.terminalDataContainer = terminalDataContainer;
        this.characterDataContainer = characterDataContainer;
    }

    @Override
    public void draw() throws IOException {
        System.out.println("Choose between the Following classes:");
        System.out.println("1) Fighter");
        String in =  Utils.getTerminalInput(terminalDataContainer);
        int input = Utils.convertInputToInt(in);
        if (input == 0){
            return;
        }
        characterClassJumpTable.get(input).run();
    }

    @Override
    public TerminalDataContainer getTerminalDataContainer() {
        return null;
    }

    public CharacterDataContainer getCharacterDataContainer() {
        return characterDataContainer;
    }
}
