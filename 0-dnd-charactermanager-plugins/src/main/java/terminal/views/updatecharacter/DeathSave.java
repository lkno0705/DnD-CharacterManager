package terminal.views.updatecharacter;

import aggregates.RPGCharacter;
import character.CharacterService;
import terminal.datacontainers.TerminalDataContainer;
import terminal.interfaces.TerminalView;
import terminal.utils.Utils;

import java.io.IOException;

public class DeathSave implements TerminalView {

    CharacterService characterService;
    TerminalDataContainer terminalDataContainer;

    public DeathSave(CharacterService characterService, TerminalDataContainer terminalDataContainer) {
        this.characterService = characterService;
        this.terminalDataContainer = terminalDataContainer;
    }

    @Override
    public void draw() throws IOException {
        System.out.println("Please enter your d20 dice roll");
        String in =  Utils.getTerminalInput(terminalDataContainer);
        int roll = Utils.convertInputToInt(in);
        RPGCharacter updatedCharacter = characterService.deathSaves(roll);
        this.terminalDataContainer.setCurrentlySelectedCharacter(updatedCharacter);
        if (updatedCharacter.isDead()){
            System.out.println("Your Character has died and moved to the graveyard");
            this.terminalDataContainer.setCurrentlySelectedCharacter(null);
        }
        this.terminalDataContainer.setRepositoryService(characterService.getRpgCharacterRepositoryService());
    }

    @Override
    public TerminalDataContainer getTerminalDataContainer() {
        return terminalDataContainer;
    }
}
