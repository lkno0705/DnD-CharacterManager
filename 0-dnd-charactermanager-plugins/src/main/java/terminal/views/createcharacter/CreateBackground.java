package terminal.views.createcharacter;

import terminal.adapters.BackgroundAdapter;
import terminal.datacontainers.CharacterDataContainer;
import terminal.datacontainers.TerminalDataContainer;
import terminal.interfaces.TerminalView;
import terminal.utils.Utils;

import java.io.IOException;

public class CreateBackground implements TerminalView {

    private BackgroundAdapter backgroundAdapter;
    private TerminalDataContainer terminalDataContainer;
    private CharacterDataContainer characterDataContainer;

    public CreateBackground(TerminalDataContainer terminalDataContainer, CharacterDataContainer characterDataContainer) {
        this.terminalDataContainer = terminalDataContainer;
        this.characterDataContainer = characterDataContainer;
        this.backgroundAdapter = new BackgroundAdapter(characterDataContainer);
    }

    @Override
    public void draw() throws IOException {
        System.out.println("Please describe the Background of your Character");
        System.out.println("Please enter your personality traits, separated with a ,:");
        String input = Utils.getTerminalInput(terminalDataContainer);
        backgroundAdapter.processTraits(input);
        System.out.println("Please enter your ideals, separated with a ,:");
        input = Utils.getTerminalInput(terminalDataContainer);
        backgroundAdapter.processIdeals(input);
        System.out.println("Please enter your bonds, separated with a ,:");
        input = Utils.getTerminalInput(terminalDataContainer);
        backgroundAdapter.processBonds(input);
        System.out.println("Please enter your Flaws, separated with a ,:");
        input = Utils.getTerminalInput(terminalDataContainer);
        backgroundAdapter.processFlaws(input);
        System.out.println("Please enter your the name of your Background:");
        input = Utils.getTerminalInput(terminalDataContainer);
        backgroundAdapter.setName(input);
        backgroundAdapter.setSkillProficiencies();
        System.out.println("Please enter the languages, separated with a ,:");
        input = Utils.getTerminalInput(terminalDataContainer);
        backgroundAdapter.processLanguages(input);
        backgroundAdapter.setEquipment();
        System.out.println("Please enter the tools you are proficiened with, separated with a ,:");
        input = Utils.getTerminalInput(terminalDataContainer);
        backgroundAdapter.processToolProficiencies(input);
        characterDataContainer = backgroundAdapter.build();
    }

    @Override
    public TerminalDataContainer getTerminalDataContainer() {
        return null;
    }

    public CharacterDataContainer getCharacterDataContainer() {
        return characterDataContainer;
    }
}
