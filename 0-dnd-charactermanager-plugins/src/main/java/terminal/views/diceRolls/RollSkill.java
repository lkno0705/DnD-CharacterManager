package terminal.views.diceRolls;

import exceptions.DiceRollException;
import rolls.DiceRollService;
import terminal.datacontainers.TerminalDataContainer;
import terminal.interfaces.TerminalView;
import terminal.utils.Utils;
import valueobjects.SkillProficiencies;

import java.io.IOException;

public class RollSkill implements TerminalView {

    TerminalDataContainer terminalDataContainer;
    DiceRollService diceRollService;

    public RollSkill(TerminalDataContainer terminalDataContainer, DiceRollService diceRollService) {
        this.terminalDataContainer = terminalDataContainer;
        this.diceRollService = diceRollService;
    }

    @Override
    public void draw() throws IOException {
        System.out.println("Please choose a skill to roll by entering its NAME");
        for (String skillName: SkillProficiencies.getAllowedSkillProficiencies()) {
            System.out.println("- " + skillName);
        }
        String skillName =  Utils.getTerminalInput(terminalDataContainer);
        System.out.println("Please enter your d20 Roll");
        String in = Utils.getTerminalInput(terminalDataContainer);
        int d20Roll = Utils.convertInputToInt(in);
        try {
            System.out.println("You rolled a " + diceRollService.rollSkill(skillName, d20Roll));
        } catch (DiceRollException e) {
            System.out.println("Error during skill check");
        }
    }

    @Override
    public TerminalDataContainer getTerminalDataContainer() {
        return null;
    }
}
