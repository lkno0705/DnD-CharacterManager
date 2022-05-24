package terminal;

import repositorys.RepositoryService;
import terminal.interfaces.TerminalView;
import terminal.utils.Utils;

import java.io.IOException;

public class MainMenu implements TerminalView {

    RepositoryService repositoryService;
    TerminalDataContainer terminalDataContainer;

    public MainMenu(RepositoryService repositoryService, TerminalDataContainer terminalDataContainer) {
        this.repositoryService = repositoryService;
        this.terminalDataContainer = terminalDataContainer;
    }

    public void draw() throws IOException {
        boolean repositoryIsEmpty = repositoryService.getAllAliveCharacters().isEmpty();
        boolean selectedCharacterNull = (terminalDataContainer.getCurrentlySelectedCharacter() == null);

        System.out.println("Please Select an Option from below by entering it's respective number");
        System.out.println("1) Create Character");
        System.out.println("2) Update Character" + (selectedCharacterNull? "(Not available)": ""));
        System.out.println("3) Delete Character" + (selectedCharacterNull? "(Not available)": ""));
        System.out.println("4) Select Character" + (repositoryIsEmpty? "(Not available)": ""));
        System.out.println("5) Show all Characters");
        System.out.println("6) Show all dead Characters");
        String in =  Utils.getTerminalInput(terminalDataContainer);
        int input = Utils.convertInputToInt(in, this);
    }

}
