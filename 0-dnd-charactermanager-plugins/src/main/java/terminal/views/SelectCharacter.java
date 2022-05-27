package terminal.views;

import terminal.datacontainers.TerminalDataContainer;
import terminal.interfaces.TerminalView;
import terminal.utils.Utils;

import java.io.IOException;

public class SelectCharacter implements TerminalView {

    TerminalDataContainer terminalDataContainer;

    public SelectCharacter(TerminalDataContainer terminalDataContainer) {
        this.terminalDataContainer = terminalDataContainer;
    }

    @Override
    public void draw() throws IOException {
        System.out.println("Please Select your Character from the available Characters below");
        ShowAvailableCharacters.showAvailableCharacters(terminalDataContainer);
        String in = Utils.getTerminalInput(terminalDataContainer);
        int number = Utils.convertInputToInt(in);
        terminalDataContainer.setCurrentlySelectedCharacter(terminalDataContainer.getRepositoryService().getAllAliveCharacters().get(number - 1));
        System.out.println("You selected Character: " + terminalDataContainer.getCurrentlySelectedCharacter().getName() + ", played by: " + this.terminalDataContainer.getCurrentlySelectedCharacter().getPlayer().toString());
        System.out.println();
    }

    @Override
    public TerminalDataContainer getTerminalDataContainer() {
        return terminalDataContainer;
    }
}
