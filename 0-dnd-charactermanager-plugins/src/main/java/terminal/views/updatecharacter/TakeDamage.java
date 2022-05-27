package terminal.views.updatecharacter;

import aggregates.RPGCharacter;
import character.CharacterService;
import terminal.datacontainers.TerminalDataContainer;
import terminal.interfaces.TerminalView;
import terminal.utils.Utils;

import java.io.IOException;

public class TakeDamage implements TerminalView {

    CharacterService characterService;
    TerminalDataContainer terminalDataContainer;

    public TakeDamage(CharacterService characterService, TerminalDataContainer terminalDataContainer) {
        this.characterService = characterService;
        this.terminalDataContainer = terminalDataContainer;
    }

    @Override
    public void draw() throws IOException {
        System.out.println("Please enter the amount of damage your Character has to take");
        String in =  Utils.getTerminalInput(terminalDataContainer);
        int amount = Utils.convertInputToInt(in);
        RPGCharacter updatedCharacter = characterService.takeDamage(amount);
        this.terminalDataContainer.setCurrentlySelectedCharacter(updatedCharacter);
        this.terminalDataContainer.setRepositoryService(characterService.getRpgCharacterRepositoryService());
    }

    @Override
    public TerminalDataContainer getTerminalDataContainer() {
        return terminalDataContainer;
    }
}
