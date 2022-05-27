package terminal.views.updatecharacter;

import aggregates.RPGCharacter;
import character.CharacterService;
import terminal.datacontainers.TerminalDataContainer;
import terminal.interfaces.TerminalView;
import terminal.utils.Utils;

import java.io.IOException;

public class HealCharacter implements TerminalView {

    CharacterService characterService;
    TerminalDataContainer terminalDataContainer;

    public HealCharacter(CharacterService characterService, TerminalDataContainer terminalDataContainer) {
        this.characterService = characterService;
        this.terminalDataContainer = terminalDataContainer;
    }

    @Override
    public void draw() throws IOException {
        System.out.println("Please enter the amount to heal your Character");
        String in =  Utils.getTerminalInput(terminalDataContainer);
        int amount = Utils.convertInputToInt(in);
        RPGCharacter updatedCharacter = characterService.heal(amount);
        this.terminalDataContainer.setCurrentlySelectedCharacter(updatedCharacter);
        this.terminalDataContainer.setRepositoryService(characterService.getRpgCharacterRepositoryService());
    }

    public TerminalDataContainer getTerminalDataContainer() {
        return terminalDataContainer;
    }
}
