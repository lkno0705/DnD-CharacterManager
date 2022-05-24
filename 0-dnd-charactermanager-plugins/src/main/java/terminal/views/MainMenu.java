package terminal.views;

import repositorys.RepositoryService;
import terminal.datacontainers.TerminalDataContainer;
import terminal.interfaces.TerminalView;
import terminal.utils.Utils;

import java.io.IOException;
import java.util.HashMap;

public class MainMenu implements TerminalView {

    TerminalDataContainer terminalDataContainer;
    HashMap<Integer, Runnable> mainMenuJumpTable = new HashMap<>(){{
//        put(1, () ->);
//        put(2, () ->)
//        put(3, () ->)
//        put(4, () ->)
        put(5, () -> ShowAvailableCharacters.showAvailableCharacters(terminalDataContainer));
        put(6, () -> ShowAvailableCharacters.showDeadCharacters(terminalDataContainer));
        put(7, () -> System.exit(0));
    }};

    public MainMenu(TerminalDataContainer terminalDataContainer) {
        this.terminalDataContainer = terminalDataContainer;
    }

    public void draw() throws IOException {
        boolean repositoryIsEmpty = terminalDataContainer.getRepositoryService().getAllAliveCharacters().isEmpty();
        boolean selectedCharacterNull = (terminalDataContainer.getCurrentlySelectedCharacter() == null);

        System.out.println("Please Select an Option from below by entering it's respective number");
        System.out.println("1) Create Character");
        System.out.println("2) Update Character" + (selectedCharacterNull? "(Not available)": ""));
        System.out.println("3) Delete Character" + (selectedCharacterNull? "(Not available)": ""));
        System.out.println("4) Select Character" + (repositoryIsEmpty? "(Not available)": ""));
        System.out.println("5) Show all Characters");
        System.out.println("6) Show all dead Characters");
        System.out.println("7) Exit");
        String in =  Utils.getTerminalInput(terminalDataContainer);
        int input = Utils.convertInputToInt(in);
        if (input == 0){
            return;
        }
        mainMenuJumpTable.get(input).run();
    }

}
