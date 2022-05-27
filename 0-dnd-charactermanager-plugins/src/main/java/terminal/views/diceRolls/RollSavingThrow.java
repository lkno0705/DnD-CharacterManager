package terminal.views.diceRolls;

import entities.Attribute;
import exceptions.DiceRollException;
import rolls.DiceRollService;
import terminal.datacontainers.TerminalDataContainer;
import terminal.interfaces.TerminalView;
import terminal.utils.Utils;

import java.io.IOException;

public class RollSavingThrow implements TerminalView {

    TerminalDataContainer terminalDataContainer;
    DiceRollService diceRollService;

    public RollSavingThrow(TerminalDataContainer terminalDataContainer, DiceRollService diceRollService) {
        this.terminalDataContainer = terminalDataContainer;
        this.diceRollService = diceRollService;
    }

    @Override
    public void draw() throws IOException {
        System.out.println("Please choose a Attribute for your Saving Throw");
        int count = 0;
        for (String attributeName: Attribute.validAttributeNames) {
            count++;
            System.out.println(count + ") " + attributeName);
        }
        String in = Utils.getTerminalInput(terminalDataContainer);
        int attributeID = Utils.convertInputToInt(in);
        String attributeName = Attribute.validAttributeNames[attributeID - 1];
        System.out.println("Enter your d20 rolll");
        in = Utils.getTerminalInput(terminalDataContainer);
        int d20Roll = Utils.convertInputToInt(in);
        try {
            System.out.println("You rolled a " + diceRollService.rollSavingThrow(attributeName, d20Roll) + " saving Throw check");
        } catch (DiceRollException e) {
            e.printStackTrace();
        }
    }

    @Override
    public TerminalDataContainer getTerminalDataContainer() {
        return null;
    }
}
