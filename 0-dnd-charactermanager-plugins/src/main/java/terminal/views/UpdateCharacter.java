package terminal.views;

import character.CharacterService;
import terminal.datacontainers.TerminalDataContainer;
import terminal.interfaces.TerminalView;
import terminal.utils.Utils;
import terminal.views.updatecharacter.DeathSave;
import terminal.views.updatecharacter.HealCharacter;
import terminal.views.updatecharacter.TakeDamage;

import java.io.IOException;
import java.util.HashMap;

public class UpdateCharacter implements TerminalView {

    CharacterService characterService;
    TerminalDataContainer terminalDataContainer;
    HashMap<Integer, Runnable> updateCharacterJumpTable = new HashMap<>(){{
        put(1, () -> {
            TakeDamage takeDamage = new TakeDamage(characterService, terminalDataContainer);
            try {
                takeDamage.draw();
                terminalDataContainer = takeDamage.getTerminalDataContainer();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        put(2, () -> {
            HealCharacter healCharacter = new HealCharacter(characterService, terminalDataContainer);
            try {
                healCharacter.draw();
                terminalDataContainer = healCharacter.getTerminalDataContainer();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        put(3, () -> {
            DeathSave deathSave = new DeathSave(characterService, terminalDataContainer);
            try {
                deathSave.draw();
                terminalDataContainer = deathSave.getTerminalDataContainer();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }};

    public UpdateCharacter(CharacterService characterService, TerminalDataContainer terminalDataContainer) {
        this.characterService = characterService;
        this.terminalDataContainer = terminalDataContainer;
    }

    @Override
    public void draw() throws IOException {
        System.out.println("Please Select an Option from below by entering it's respective number");
        System.out.println("1) Take Damage");
        System.out.println("2) Heal");
        System.out.println("3) Death Save");
        String in =  Utils.getTerminalInput(terminalDataContainer);
        int input = Utils.convertInputToInt(in);
        if (input == 0){
            return;
        }
        updateCharacterJumpTable.get(input).run();
    }

    public TerminalDataContainer getTerminalDataContainer() {
        return terminalDataContainer;
    }
}
