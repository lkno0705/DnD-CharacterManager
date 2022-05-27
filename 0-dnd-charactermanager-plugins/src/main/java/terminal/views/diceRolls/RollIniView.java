package terminal.views.diceRolls;

import exceptions.DiceRollException;
import rolls.DiceRollService;
import terminal.datacontainers.TerminalDataContainer;
import terminal.interfaces.TerminalView;
import terminal.utils.Utils;

import java.io.IOException;

public class RollIniView implements TerminalView {

    TerminalDataContainer terminalDataContainer;
    DiceRollService diceRollService;

    public RollIniView(TerminalDataContainer terminalDataContainer, DiceRollService diceRollService) {
        this.terminalDataContainer = terminalDataContainer;
        this.diceRollService = diceRollService;
    }

    @Override
    public void draw() throws IOException {
        System.out.println("Please Enter Your D20 Roll");
        String in =  Utils.getTerminalInput(terminalDataContainer);
        int roll = Utils.convertInputToInt(in);
        try {
            System.out.println("Your initiative is: " + diceRollService.rollInitiative(roll));

        } catch (DiceRollException e) {
            System.out.println("Invalid Dice Roll");
        }
    }

    @Override
    public TerminalDataContainer getTerminalDataContainer() {
        return null;
    }
}
