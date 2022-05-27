package terminal.views;

import exceptions.HitDieException;
import rolls.DiceRollService;
import terminal.datacontainers.TerminalDataContainer;
import terminal.interfaces.TerminalView;
import terminal.utils.Utils;
import terminal.views.diceRolls.RollAttack;
import terminal.views.diceRolls.RollIniView;
import terminal.views.diceRolls.RollSavingThrow;
import terminal.views.diceRolls.RollSkill;

import java.io.IOException;
import java.util.HashMap;

public class CheckView implements TerminalView {

    private TerminalDataContainer terminalDataContainer;
    private DiceRollService diceRollService;
    HashMap<Integer, Runnable> checkViewJumpTable = new HashMap<>(){{
        put(1, () -> {
            try {
                new RollIniView(terminalDataContainer, diceRollService).draw();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        put(2, () -> {
            try {
                new RollAttack(terminalDataContainer, diceRollService).draw();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        put(3, () -> {
            try {
                new RollSkill(terminalDataContainer, diceRollService).draw();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        put(4, () -> {
            try {
                new RollSavingThrow(terminalDataContainer, diceRollService).draw();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }};

    public CheckView(TerminalDataContainer terminalDataContainer) {
        this.terminalDataContainer = terminalDataContainer;
        try {
            this.diceRollService = new DiceRollService(terminalDataContainer.getCurrentlySelectedCharacter());
        } catch (HitDieException e) {
            System.out.println("Invalid Hit Die");
        }
    }

    @Override
    public void draw() throws IOException {
        System.out.println("Please Select the Type of check to perform");
        System.out.println("1) initiative");
        System.out.println("2) attack");
        System.out.println("3) skill");
        System.out.println("4) saving throw");
        String in =  Utils.getTerminalInput(terminalDataContainer);
        int input = Utils.convertInputToInt(in);
        if (input == 0){
            return;
        }
        checkViewJumpTable.get(input).run();
    }

    @Override
    public TerminalDataContainer getTerminalDataContainer() {
        return null;
    }
}
