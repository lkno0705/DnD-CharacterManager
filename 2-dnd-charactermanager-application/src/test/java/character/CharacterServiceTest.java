package character;

import aggregates.RPGCharacter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositorys.RepositoryService;
import valueobjects.HitDie;
import valueobjects.Weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CharacterServiceTest {

    private RPGCharacter mockedCharacter;
    private HitDie mockedDie;
    private Weapon mockedWeapon;
    private RepositoryService mockedRepositoryService;
    private CharacterService characterService;

    @BeforeEach
    void setUp() {
        mockDie();
        mockWeapon();
        mockCharacter();
        mockRepositoryService();
        this.characterService = new CharacterService(mockedCharacter, mockedRepositoryService);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void displayCharacter() {
        assertEquals("Character: " + "Harald Hart im Nehmen" +
                        "\n    Class: " + "Fighter" +
                        "\n    Level: " + 1 +
                        "\n    Background: " + "Harter Background" +
                        "\n    Player Name: " + "Arnold" + " " + "Schwarz" +
                        "\n    Race: " + "Harte Rasse" +
                        "\n    XP: " + 0 +
                        "\n    Age: " + 45 +
                        "\n    Proficiency Bonus: " + 5 +
                        "\n    ArmorClass: " + 14 +
                        "\n    Speed: " + 30 +
                        "\n    maxHP: " + 10 +
                        "\n    CurrentHP: " + 10 +
                        "\n    Hit Dice: " + "HitDie{" +
                        "dieType=" + 10 +
                        ", amount=" + 1 +
                        '}' +
                        "\n    Death Saves: " + "DeathSaves{" +
                        "successes=" + 0 +
                        ", failures=" + 0 +
                        '}' +
                        "\n    Personality: " + "Personality{personalityTraits=traits, ideal=ideals, bond=bonds, flaw=flaws}" +
                        "\n    isDead: " + false +
                        "\n---------------------Attributes------------------------" +
                        "\n    Strength: " + 10 +
                        "\n    Strength Modifier: " + 0 +
                        "\n    Dexterity: " + 10 +
                        "\n    DexterityModifier: " + 0 +
                        "\n    Consitution: " + 10 +
                        "\n    Constitution Modifier: " + 0 +
                        "\n    Intelligence: " + 10 +
                        "\n    Intelligence Modifier: " + 0 +
                        "\n    Wisdom: " + 10 +
                        "\n    Wisdom Modifier: " + 0 +
                        "\n    Charisma: " + 10 +
                        "\n    Charisma Modifier: " + 0 +
                        "\n---------------------Saving Throws------------------------" +
                        "\n    " + "Strength: 3\n    " + "Dexterity: 4\n    " +
                        "\n---------------------Skills------------------------" +
                        "\n    " + "Acrobatics: 3\n    " + "AnimalHandling: 4\n    " +
                        "\n---------------------Inventory------------------------" +
                        "\n    CP" + 10 +
                        "\n    SP" + 10 +
                        "\n    EP" + 10 +
                        "\n    GP" + 10 +
                        "\n    PP" + 10 +
                        "\n    Items:" + "\n        " + "item1: 1\n    " + "item2: 2\n    " +
                        "\n    Weapons:" + "\n        " + "Harte Hantel Hartholz: Damage die=(d10,1)\n        " +
                        "\n    Armor: " + "Armor{" +
                        "name='" + "Rüstung" + '\'' +
                        ", baseAC=" + 3 +
                        ", withDex=" + false +
                        ", maxDexBonus=" + 4 +
                        ", minimumStrength=" + 10 +
                        '}',
                characterService.displayCharacter()
        );
    }

    @Test
    void takeDamage() {
    }

    @Test
    void heal() {
    }

    @Test
    void deathSaves() {
    }

    @Test
    void die() {
    }

    private void mockDie() {
        this.mockedDie = mock(HitDie.class);
        when(mockedDie.toString()).thenReturn("HitDie{" +
                "dieType=" + 10 +
                ", amount=" + 1 +
                '}');
        when(mockedDie.getDieType()).thenReturn(10);
        when(mockedDie.getAmount()).thenReturn(1);
    }

    private void mockWeapon() {
        this.mockedWeapon = mock(Weapon.class);
        when(mockedWeapon.getDamageDie()).thenReturn(mockedDie);
        when(mockedWeapon.getName()).thenReturn("Harte Hantel Hartholz");
        when(mockedWeapon.isFinesse()).thenReturn(false);
    }

    private void mockRepositoryService() {
        this.mockedRepositoryService = mock(RepositoryService.class);
        doNothing().when(mockedRepositoryService.getAllAliveCharacters());
        doNothing().when(mockedRepositoryService.getAllDeadCharacters());
    }

    private void mockCharacter() {
        /*Rewrite this to function like this:
        A.getB().getC().getInt()
        Mocke A
        Mocke B
        Mocke C
        Definiere ein mockInt = 42

        When(A.getB()).thenReturn(mockB)
        When(B.getC()).thenReturn(mockC)
        When(C.getInt()).thenReturn(mockInt)
         */
        this.mockedCharacter = mock(RPGCharacter.class);
        when(this.mockedCharacter.getCharacterClass().getHitDice()).thenReturn(new ArrayList<>() {{
            add(mockedDie);
        }});
        when(this.mockedCharacter.getName()).thenReturn("Harald Hart im Nehmen");
        when(this.mockedCharacter.getCharacterClass().getName()).thenReturn("Fighter");
        when(this.mockedCharacter.getLevel()).thenReturn(1);
        when(this.mockedCharacter.getBackground().getName()).thenReturn("Harter Background");
        when(this.mockedCharacter.getPlayer().getFirstName()).thenReturn("Arnold");
        when(this.mockedCharacter.getPlayer().getLastName()).thenReturn("Schwarz");
        when(this.mockedCharacter.getRace().getRaceName()).thenReturn("Harte Rasse");
        when(this.mockedCharacter.getXp()).thenReturn(0);
        when(this.mockedCharacter.getAge()).thenReturn(45);
        when(this.mockedCharacter.getCharacterClass().getProficiencyBonus()).thenReturn(5);
        when(this.mockedCharacter.getAC()).thenReturn(14);
        when(this.mockedCharacter.getRace().getSpeed()).thenReturn(30);
        when(this.mockedCharacter.getCharacterClass().getMaxHP()).thenReturn(10);
        when(this.mockedCharacter.getCharacterClass().getCurrentHP()).thenReturn(10);
        when(this.mockedCharacter.getDeathSaves().toString()).thenReturn("DeathSaves{" +
                "successes=" + 0 +
                ", failures=" + 0 +
                '}');
        when(this.mockedCharacter.getBackground().getPersonality().toString()).thenReturn("Personality{personalityTraits=traits, ideal=ideals, bond=bonds, flaw=flaws}");
        when(this.mockedCharacter.isDead()).thenReturn(false);
        when(this.mockedCharacter.getAttributes().getStrength()).thenReturn(10);
        when(this.mockedCharacter.getAttributes().getStrengthMod()).thenReturn(0);
        when(this.mockedCharacter.getAttributes().getDexterity()).thenReturn(10);
        when(this.mockedCharacter.getAttributes().getDexMod()).thenReturn(0);
        when(this.mockedCharacter.getAttributes().getConstitution()).thenReturn(10);
        when(this.mockedCharacter.getAttributes().getConstMod()).thenReturn(0);
        when(this.mockedCharacter.getAttributes().getIntelligence()).thenReturn(10);
        when(this.mockedCharacter.getAttributes().getIntMod()).thenReturn(0);
        when(this.mockedCharacter.getAttributes().getWisdom()).thenReturn(10);
        when(this.mockedCharacter.getAttributes().getWisdomMod()).thenReturn(0);
        when(this.mockedCharacter.getAttributes().getCharisma()).thenReturn(10);
        when(this.mockedCharacter.getAttributes().getCharismaMod()).thenReturn(0);
        when(this.mockedCharacter.getSavingThrows()).thenReturn(new HashMap<>() {{
            put("Strength", 3);
            put("Dexterity", 4);
        }});
        when(this.mockedCharacter.getSkills()).thenReturn(new HashMap<>() {{
            put("Acrobatics", 3);
            put("AnimalHandling", 4);
        }});
        when(this.mockedCharacter.getInventory().getCurrencys().getCP()).thenReturn(10);
        when(this.mockedCharacter.getInventory().getCurrencys().getSP()).thenReturn(10);
        when(this.mockedCharacter.getInventory().getCurrencys().getEP()).thenReturn(10);
        when(this.mockedCharacter.getInventory().getCurrencys().getGP()).thenReturn(10);
        when(this.mockedCharacter.getInventory().getCurrencys().getPP()).thenReturn(10);
        when(this.mockedCharacter.getInventory().getItems()).thenReturn(new HashMap<>() {{
            put("item1", 1);
            put("item2", 2);
        }});
        when(this.mockedCharacter.getInventory().getWeapons()).thenReturn(new Weapon[]{mockedWeapon});
        when(this.mockedCharacter.getInventory().getArmor().toString()).thenReturn("Armor{" +
                "name='" + "Rüstung" + '\'' +
                ", baseAC=" + 3 +
                ", withDex=" + false +
                ", maxDexBonus=" + 4 +
                ", minimumStrength=" + 10 +
                '}');
    }
}