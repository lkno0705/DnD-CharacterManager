package rolls;

import aggregates.RPGCharacter;
import exceptions.DiceRollException;
import exceptions.HitDieException;
import valueobjects.HitDie;
import valueobjects.Weapon;

public class DiceRollService {

    private RPGCharacter rpgCharacter;
    private final HitDie d20;

    public DiceRollService(RPGCharacter rpgCharacter) throws HitDieException {
        this.rpgCharacter = rpgCharacter;
        this.d20 = new HitDie(20, 1);
    }

    public int rollInitiative(int diceRoll) throws DiceRollException {
        checkDiceRange(d20, diceRoll);
        return diceRoll + this.rpgCharacter.getAttributes().getDexMod();
    }

    public int attack(Weapon weapon, int damageDiceRoll, int d20Roll) throws DiceRollException {
        checkDiceRange(weapon.getDamageDie(), damageDiceRoll);
        checkDiceRange(d20, d20Roll);

        int d20BeforeMod = d20Roll;
        if(weapon.isFinesse()){
            int modifier = Math.max(this.rpgCharacter.getAttributes().getStrengthMod(), this.rpgCharacter.getAttributes().getDexMod());
            d20Roll += modifier;
            damageDiceRoll += modifier;
        }

        if(d20BeforeMod == 20){
            return damageDiceRoll * 2;
        }
        if(d20BeforeMod == 1) return 0;
        if (d20Roll > 10) return damageDiceRoll;
        else return 0;
    }

    public int rollSkill(String skillName, int diceRoll) throws DiceRollException {
        checkDiceRange(d20, diceRoll);
        return this.rpgCharacter.getSkills().get(skillName) + diceRoll;
    }

    public int rollSavingThrow(String savingThrowAttribute, int diceRoll) throws DiceRollException {
        checkDiceRange(d20, diceRoll);
        return this.rpgCharacter.getSavingThrows().get(savingThrowAttribute) + diceRoll;
    }

    private void checkDiceRange(HitDie hitDie, int diceRoll) throws DiceRollException {
        if(diceRoll < 1 || diceRoll > hitDie.getDieType() * hitDie.getAmount()) throw new DiceRollException("Invalid Dice Roll!");
    }

}
