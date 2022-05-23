package character;

import aggregates.Attributes;
import aggregates.Inventory;
import aggregates.RPGCharacter;
import entities.CharacterClass;
import entities.CharacterRace;
import entities.Currencys;
import entities.DeathSaves;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositorys.RepositoryService;
import valueobjects.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CharacterServiceTest {

    private RPGCharacter mockedCharacter;
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
                        "\n    " + "Dexterity: 4\n    " + "Strength: 3\n    " +
                        "\n---------------------Skills------------------------" +
                        "\n    " + "AnimalHandling: 4\n    " + "Acrobatics: 3\n    " +
                        "\n---------------------Inventory------------------------" +
                        "\n    CP" + 10 +
                        "\n    SP" + 10 +
                        "\n    EP" + 10 +
                        "\n    GP" + 10 +
                        "\n    PP" + 10 +
                        "\n    Items:" + "\n        " + "item2: 2\n    " + "item1: 1\n    " +
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

// All of these are basically setter methods with extra steps
//    @Test
//    void takeDamage() {
//
//
//
//    }
//
//    @Test
//    void heal() {
//    }
//
//    @Test
//    void deathSaves() {
//    }
//
//    @Test
//    void die() {
//    }

    private HitDie mockDie() {
        HitDie mockedDie = mock(HitDie.class);
        when(mockedDie.toString()).thenReturn("HitDie{" +
                "dieType=" + 10 +
                ", amount=" + 1 +
                '}');
        when(mockedDie.getDieType()).thenReturn(10);
        when(mockedDie.getAmount()).thenReturn(1);
        return mockedDie;
    }

    private void mockWeapon() {
        HitDie mockedDie = mockDie();

        this.mockedWeapon = mock(Weapon.class);
        when(mockedWeapon.getDamageDie()).thenReturn(mockedDie);
        when(mockedWeapon.getName()).thenReturn("Harte Hantel Hartholz");
        when(mockedWeapon.isFinesse()).thenReturn(false);
    }

    private void mockRepositoryService() {
        this.mockedRepositoryService = mock(RepositoryService.class);
    }

    private Player mockPlayer(){
        Player player = mock(Player.class);
        when(player.getLastName()).thenReturn("Schwarz");
        when(player.getFirstName()).thenReturn("Arnold");
        return player;
    }

    private CharacterClass mockClass(){
        HitDie mockedDie = mockDie();

        CharacterClass characterClass = mock(CharacterClass.class);
        when(characterClass.getName()).thenReturn("Fighter");
        when(characterClass.getProficiencyBonus()).thenReturn(5);
        when(characterClass.getMaxHP()).thenReturn(10);
        when(characterClass.getCurrentHP()).thenReturn(10);
        when(characterClass.getHitDice()).thenReturn(new ArrayList<>() {{
            add(mockedDie);
        }});
        return characterClass;
    }

    private Background mockBackground(){
        Personality personality = mock(Personality.class);
        when(personality.toString()).thenReturn("Personality{personalityTraits=traits, ideal=ideals, bond=bonds, flaw=flaws}");
        Background background = mock(Background.class);
        when(background.getName()).thenReturn("Harter Background");
        when(background.getPersonality()).thenReturn(personality);
        return background;
    }

    private CharacterRace mockRace(){
        CharacterRace race = mock(CharacterRace.class);
        when(race.getSpeed()).thenReturn(30);
        when(race.getRaceName()).thenReturn("Harte Rasse");
        return race;
    }

    private DeathSaves mockDeathSaves(){
        DeathSaves deathSaves = mock(DeathSaves.class);
        when(deathSaves.toString()).thenReturn("DeathSaves{" +
                "successes=" + 0 +
                ", failures=" + 0 +
                '}');
        return deathSaves;
    }

    private Attributes mockAttributes(){
        Attributes attributes = mock(Attributes.class);
        when(attributes.getStrength()).thenReturn(10);
        when(attributes.getStrengthMod()).thenReturn(0);
        when(attributes.getDexterity()).thenReturn(10);
        when(attributes.getDexMod()).thenReturn(0);
        when(attributes.getConstitution()).thenReturn(10);
        when(attributes.getConstMod()).thenReturn(0);
        when(attributes.getIntelligence()).thenReturn(10);
        when(attributes.getIntMod()).thenReturn(0);
        when(attributes.getWisdom()).thenReturn(10);
        when(attributes.getWisdomMod()).thenReturn(0);
        when(attributes.getCharisma()).thenReturn(10);
        when(attributes.getCharismaMod()).thenReturn(0);
        return attributes;
    }

    private Inventory mockInventory(){
        Currencys currencys = mock(Currencys.class);
        when(currencys.getCP()).thenReturn(10);
        when(currencys.getSP()).thenReturn(10);
        when(currencys.getEP()).thenReturn(10);
        when(currencys.getGP()).thenReturn(10);
        when(currencys.getPP()).thenReturn(10);

        Armor armor = mock(Armor.class);
        when(armor.toString()).thenReturn("Armor{" +
                "name='" + "Rüstung" + '\'' +
                ", baseAC=" + 3 +
                ", withDex=" + false +
                ", maxDexBonus=" + 4 +
                ", minimumStrength=" + 10 +
                '}');

        Inventory inventory = mock(Inventory.class);
        when(inventory.getCurrencys()).thenReturn(currencys);
        when(inventory.getItems()).thenReturn(new HashMap<>() {{
            put("item1", 1);
            put("item2", 2);
        }});
        when(inventory.getWeapons()).thenReturn(new Weapon[]{mockedWeapon});
        when(inventory.getArmor()).thenReturn(armor);
        return inventory;
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
        Inventory mockedInventory = mockInventory();
        CharacterRace mockedRace = mockRace();
        CharacterClass mockedClass = mockClass();
        DeathSaves mockedDeathSaves = mockDeathSaves();
        Attributes mockedAttributes = mockAttributes();
        Player mockedPlayer = mockPlayer();
        Background mockedBackground = mockBackground();

        this.mockedCharacter = mock(RPGCharacter.class);

        when(this.mockedCharacter.getName()).thenReturn("Harald Hart im Nehmen");
        when(this.mockedCharacter.getCharacterClass()).thenReturn(mockedClass);
        when(this.mockedCharacter.getLevel()).thenReturn(1);
        when(this.mockedCharacter.getBackground()).thenReturn(mockedBackground);
        when(this.mockedCharacter.getPlayer()).thenReturn(mockedPlayer);
        when(this.mockedCharacter.getRace()).thenReturn(mockedRace);
        when(this.mockedCharacter.getXp()).thenReturn(0);
        when(this.mockedCharacter.getAge()).thenReturn(45);
        when(this.mockedCharacter.getAC()).thenReturn(14);
        when(this.mockedCharacter.getDeathSaves()).thenReturn(mockedDeathSaves);
        when(this.mockedCharacter.isDead()).thenReturn(false);
        when(this.mockedCharacter.getAttributes()).thenReturn(mockedAttributes);
        when(this.mockedCharacter.getSavingThrows()).thenReturn(new HashMap<>() {{
            put("Strength", 3);
            put("Dexterity", 4);
        }});
        when(this.mockedCharacter.getSkills()).thenReturn(new HashMap<>() {{
            put("Acrobatics", 3);
            put("AnimalHandling", 4);
        }});
        when(this.mockedCharacter.getInventory()).thenReturn(mockedInventory);
    }
}