package terminal.views;

import terminal.datacontainers.TerminalDataContainer;
import terminal.interfaces.TerminalView;

import java.io.IOException;

public class DeleteCharacter implements TerminalView {

    TerminalDataContainer terminalDataContainer;

    public DeleteCharacter(TerminalDataContainer terminalDataContainer) {
        this.terminalDataContainer = terminalDataContainer;
    }

    @Override
    public void draw() throws IOException {
        this.terminalDataContainer.getRepositoryService().deleteCharacter(this.terminalDataContainer.getCurrentlySelectedCharacter());
        System.out.println("The Character: " + terminalDataContainer.getCurrentlySelectedCharacter().getName() + ", played by: " + this.terminalDataContainer.getCurrentlySelectedCharacter().getPlayer().toString() + "Has been deleted");
        this.terminalDataContainer.setCurrentlySelectedCharacter(null);
    }

    @Override
    public TerminalDataContainer getTerminalDataContainer() {
        return terminalDataContainer;
    }
}
