package terminal.views;

import character.CharacterService;
import terminal.datacontainers.TerminalDataContainer;
import terminal.interfaces.TerminalView;
import terminal.utils.Utils;
import terminal.views.createcharacter.CreateCharacter;

import java.io.IOException;
import java.util.HashMap;

public class MainMenu implements TerminalView {

    TerminalDataContainer terminalDataContainer;
    CharacterService characterService;
    HashMap<Integer, Runnable> mainMenuJumpTable = new HashMap<>(){{
        put(1, () -> {
            try {
                CreateCharacter createCharacterView = new CreateCharacter(terminalDataContainer);
                createCharacterView.draw();
                terminalDataContainer = createCharacterView.getTerminalDataContainer();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        put(2, () -> {
            try {
                UpdateCharacter updateCharacter = new UpdateCharacter(characterService, terminalDataContainer);
                updateCharacter.draw();
                terminalDataContainer = updateCharacter.getTerminalDataContainer();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        put(3, () -> {
            try {
                DeleteCharacter deleteCharacter = new DeleteCharacter(terminalDataContainer);
                deleteCharacter.draw();
                terminalDataContainer = deleteCharacter.getTerminalDataContainer();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        put(4, () ->{
            try {
                SelectCharacter selectCharacter = new SelectCharacter(terminalDataContainer);
                selectCharacter.draw();
                terminalDataContainer = selectCharacter.getTerminalDataContainer();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        put(5, () -> DisplayCharacter.draw(characterService));
        put(6, () -> ShowAvailableCharacters.showAvailableCharacters(terminalDataContainer));
        put(7, () -> ShowAvailableCharacters.showDeadCharacters(terminalDataContainer));
        put(8, () -> System.exit(0));
    }};

    public MainMenu(TerminalDataContainer terminalDataContainer) {
        this.terminalDataContainer = terminalDataContainer;
        if (terminalDataContainer.getCurrentlySelectedCharacter() != null) characterService = new CharacterService(
                terminalDataContainer.getCurrentlySelectedCharacter(),
                terminalDataContainer.getRepositoryService()
        );
    }

    public void draw() throws IOException {
        boolean repositoryIsEmpty = terminalDataContainer.getRepositoryService().getAllAliveCharacters().isEmpty();
        boolean selectedCharacterNull = (terminalDataContainer.getCurrentlySelectedCharacter() == null);

        System.out.println("Please Select an Option from below by entering it's respective number");
        System.out.println("1) Create Character");
        System.out.println("2) Update selected Character" + (selectedCharacterNull? "(Not available)": ""));
        System.out.println("3) Delete selected Character" + (selectedCharacterNull? "(Not available)": ""));
        System.out.println("4) Select Character" + (repositoryIsEmpty? "(Not available)": ""));
        System.out.println("5) Display Character" + (selectedCharacterNull? "(Not available)": "") );
        System.out.println("6) Show all Characters");
        System.out.println("7) Show all dead Characters");
        System.out.println("8) Exit");
        String in =  Utils.getTerminalInput(terminalDataContainer);
        int input = Utils.convertInputToInt(in);
        if (input == 0){
            return;
        }
        mainMenuJumpTable.get(input).run();
    }

    public TerminalDataContainer getTerminalDataContainer() {
        return terminalDataContainer;
    }
}
