package terminal.views.diceRolls;

import exceptions.DiceRollException;
import rolls.DiceRollService;
import terminal.datacontainers.TerminalDataContainer;
import terminal.interfaces.TerminalView;
import terminal.utils.Utils;
import valueobjects.Weapon;

import java.io.IOException;

public class RollAttack implements TerminalView {

    TerminalDataContainer terminalDataContainer;
    DiceRollService diceRollService;

    public RollAttack(TerminalDataContainer terminalDataContainer, DiceRollService diceRollService) {
        this.terminalDataContainer = terminalDataContainer;
        this.diceRollService = diceRollService;
    }

    @Override
    public void draw() throws IOException {
        System.out.println("Please choose a weapon from below");
        int count = 0;
        for (Weapon weapon: terminalDataContainer.getCurrentlySelectedCharacter().getInventory().getWeapons()){
            count++;
            StringBuilder weaponString = new StringBuilder();
            weaponString.append(weapon.getName())
                    .append(": Damage die=(d")
                    .append(weapon.getDamageDie().getDieType())
                    .append(",")
                    .append(weapon.getDamageDie().getAmount())
                    .append(weapon.isFinesse() ? ",finesse" : "")
                    .append(")");
            System.out.println(count + ") " + weaponString);
        }
        String in =  Utils.getTerminalInput(terminalDataContainer);
        int weaponId = Utils.convertInputToInt(in);
        Weapon chosenWeapon = this.terminalDataContainer.getCurrentlySelectedCharacter().getInventory().getWeapons()[weaponId - 1];
        System.out.println("Please enter your d20 Roll");
        in =  Utils.getTerminalInput(terminalDataContainer);
        int d20Roll = Utils.convertInputToInt(in);
        System.out.println("Please enter your d" + chosenWeapon.getDamageDie().getDieType() + " roll");
        in =  Utils.getTerminalInput(terminalDataContainer);
        int damageRoll = Utils.convertInputToInt(in);
        try {
            System.out.println("You do " + diceRollService.attack(chosenWeapon, damageRoll, d20Roll) + "damage");
        } catch (DiceRollException e) {
            System.out.println("ERROR during Damage calculation");
        }
    }

    @Override
    public TerminalDataContainer getTerminalDataContainer() {
        return null;
    }
}
