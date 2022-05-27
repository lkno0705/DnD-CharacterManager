package terminal.views.createcharacter;

import exceptions.PlayerException;
import terminal.adapters.PlayerAdapter;
import terminal.datacontainers.CharacterDataContainer;
import terminal.datacontainers.PlayerDataContainer;
import terminal.datacontainers.TerminalDataContainer;
import terminal.interfaces.TerminalView;
import terminal.utils.Utils;

import java.io.IOException;

public class CreatePlayer implements TerminalView {

    private PlayerDataContainer playerDataContainer = new PlayerDataContainer();
    private TerminalDataContainer terminalDataContainer;
    private CharacterDataContainer characterDataContainer;

    public CreatePlayer(TerminalDataContainer terminalDataContainer, CharacterDataContainer characterDataContainer) {
        this.terminalDataContainer = terminalDataContainer;
        this.characterDataContainer = characterDataContainer;
    }

    @Override
    public void draw() throws IOException {
        System.out.println("Please enter the credentials for your player:");
        System.out.println("firstName: ");
        playerDataContainer.setFirstName(Utils.getTerminalInput(terminalDataContainer));
        System.out.println("lastName: ");
        playerDataContainer.setLastName(Utils.getTerminalInput(terminalDataContainer));
        try {
            PlayerAdapter.createPlayer(characterDataContainer, playerDataContainer);
        } catch (PlayerException e) {
            System.out.println("Error creating Player");
        }
    }

    @Override
    public TerminalDataContainer getTerminalDataContainer() {
        return null;
    }
}
