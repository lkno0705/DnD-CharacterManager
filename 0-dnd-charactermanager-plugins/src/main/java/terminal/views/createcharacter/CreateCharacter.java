package terminal.views.createcharacter;

import aggregates.RPGCharacter;
import terminal.adapters.InventoryAdapter;
import terminal.datacontainers.CharacterDataContainer;
import terminal.datacontainers.TerminalDataContainer;
import terminal.interfaces.TerminalView;
import terminal.utils.Utils;

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
        characterDataContainer = createCharacterRace.getCharacterDataContainer();
        CreateAttributes createAttributes = new CreateAttributes(terminalDataContainer, characterDataContainer);
        createAttributes.draw();
        characterDataContainer = createAttributes.getCharacterDataContainer();
        CreateCharacterClass createCharacterClass = new CreateCharacterClass(terminalDataContainer, characterDataContainer);
        createCharacterClass.draw();
        characterDataContainer = createCharacterClass.getCharacterDataContainer();
        CreateBackground createBackground = new CreateBackground(terminalDataContainer, characterDataContainer);
        createBackground.draw();
        characterDataContainer = createBackground.getCharacterDataContainer();
        characterDataContainer = InventoryAdapter.buildStarterInventory(characterDataContainer);
        System.out.println("Please enter the name of your character");
        String in =  Utils.getTerminalInput(terminalDataContainer);
        characterDataContainer.setName(in);
        characterDataContainer.setXp(0);
        System.out.println("Please enter the age of your character");
        in =  Utils.getTerminalInput(terminalDataContainer);
        int input = Utils.convertInputToInt(in);
        characterDataContainer.setAge(input);
        CreatePlayer createPlayer = new CreatePlayer(terminalDataContainer, characterDataContainer);
        createPlayer.draw();
        try {
            RPGCharacter character = characterDataContainer.build();
            this.terminalDataContainer.setCurrentlySelectedCharacter(character);
        } catch (Exception e) {
            System.out.println("ERROR During Character Creation!");
        }
    }

    public TerminalDataContainer getTerminalDataContainer() {
        return terminalDataContainer;
    }
}
