package rolls;

import aggregates.Attributes;
import aggregates.RPGCharacter;
import exceptions.DiceRollException;
import exceptions.HitDieException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import valueobjects.HitDie;
import valueobjects.Weapon;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DiceRollServiceTest {

    private RPGCharacter mockedCharacter;
    DiceRollService diceRollService;

    @BeforeEach
    void setUp() throws HitDieException {
        mockChracter();
        this.diceRollService = new DiceRollService(this.mockedCharacter);
    }

    @Test
    void rollInitiative() throws DiceRollException {
        assertEquals(18, this.diceRollService.rollInitiative(16));
    }

    // Mock Weapon
    @Test
    void attack() throws DiceRollException {
        Weapon weaponWithFinesse = mockWeapon(true);
        Weapon normalWeapon = mockWeapon(false);
        assertEquals(5, this.diceRollService.attack(normalWeapon, 5, 11));
        assertEquals(10, this.diceRollService.attack(normalWeapon, 5, 20));
        assertEquals(7, this.diceRollService.attack(weaponWithFinesse, 5, 11));
        assertEquals(0, this.diceRollService.attack(weaponWithFinesse, 5, 1));
        assertEquals(0, this.diceRollService.attack(weaponWithFinesse, 5, 5));
        assertThrows(DiceRollException.class, () ->{
            this.diceRollService.attack(normalWeapon, 6, 22);
        });
        assertThrows(DiceRollException.class, () ->{
            this.diceRollService.attack(normalWeapon, 15, 15);
        });
    }

    @Test
    void rollSkill() throws DiceRollException {
        assertEquals(13, this.diceRollService.rollSkill("Acrobatics", 10));
    }

    @Test
    void rollSavingThrow() throws DiceRollException {
        assertEquals(13, this.diceRollService.rollSavingThrow("Strength", 10));
    }

    private Attributes mockAttributes(){
        Attributes mockedAttributes = mock(Attributes.class);
        when(mockedAttributes.getDexMod()).thenReturn(2);
        when(mockedAttributes.getStrengthMod()).thenReturn(2);
        return mockedAttributes;
    }

    private HitDie mockDieD6(){
        HitDie mockedDieD6 = mock(HitDie.class);
        when(mockedDieD6.getDieType()).thenReturn(6);
        when(mockedDieD6.getAmount()).thenReturn(2);
        return mockedDieD6;
    }

    private Weapon mockWeapon(boolean isFinesse){
        HitDie mockedDieD6 = mockDieD6();
        Weapon mockedWeapon = mock(Weapon.class);
        when(mockedWeapon.getDamageDie()).thenReturn(mockedDieD6);
        when(mockedWeapon.isFinesse()).thenReturn(isFinesse);
        return mockedWeapon;
    }

    private void mockChracter(){
        Attributes mockedAttributes = mockAttributes();
        this.mockedCharacter = mock(RPGCharacter.class);

        when(this.mockedCharacter.getAttributes()).thenReturn(mockedAttributes);
        when(this.mockedCharacter.getSkills()).thenReturn(new HashMap<>(){{
            put("Acrobatics", 3);
        }});
        when(this.mockedCharacter.getSavingThrows()).thenReturn(new HashMap<>(){{
            put("Strength", 3);
        }});
    }
}