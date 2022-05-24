package terminal.views;

import terminal.datacontainers.CharacterDataContainer;
import terminal.datacontainers.TerminalDataContainer;
import terminal.interfaces.TerminalView;

import java.io.IOException;

public class CreateCharacter implements TerminalView {

    private TerminalDataContainer terminalDataContainer;
    private CharacterDataContainer characterDataContainer;

    public CreateCharacter(TerminalDataContainer terminalDataContainer) {
        this.terminalDataContainer = terminalDataContainer;
        this.characterDataContainer = new CharacterDataContainer(terminalDataContainer.getRepositoryService());
    }

    @Override
    public void draw() throws IOException {
        System.out.println("Welcome to Character creation");
        CreateCharacterRace createCharacterRace = new CreateCharacterRace(terminalDataContainer, characterDataContainer);
        createCharacterRace.draw();
        CreateAttributes createAttributes = new CreateAttributes(terminalDataContainer, characterDataContainer);
        createAttributes.draw();
        CreateCharacterClass createCharacterClass = new CreateCharacterClass(terminalDataContainer, characterDataContainer);
        createCharacterClass.draw();

    }
}
