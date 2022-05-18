package entities;

import java.util.Objects;
import java.util.UUID;

public class Attributes {

    //TODO: FOR ALL Entities CHECK IF VALID ENTRYS

    // Could change this to attribute entities -> check if correctly there
    // This would then be an aggregate
    private int strength;
    private int strengthMod;
    private int dexterity;
    private int dexMod;
    private int constitution;
    private int constMod;
    private int intelligence;
    private int intMod;
    private int wisdom;
    private int wisdomMod;
    private int charisma;
    private int charismaMod;
    private UUID id;

    public Attributes(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        this.strength = strength;
        this.strengthMod = calcMod(strength);
        this.dexterity = dexterity;
        this.dexMod = calcMod(dexterity);
        this.constitution = constitution;
        this.constMod = calcMod(constitution);
        this.intelligence = intelligence;
        this.intMod = calcMod(intelligence);
        this.wisdom = wisdom;
        this.wisdomMod = calcMod(wisdom);
        this.charisma = charisma;
        this.charismaMod = calcMod(charisma);
        this.id = UUID.randomUUID();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attributes that = (Attributes) o;
        return id.equals(that.id);
    }

    private int calcMod(int attribute){
        return (attribute - 10) / 2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setStrength(int strength) {
        this.strength = strength;
        this.strengthMod = calcMod(strength);
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
        this.dexMod = calcMod(dexterity);
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
        this.constMod = calcMod(constitution);
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
        this.intMod = calcMod(intelligence);
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
        this.wisdomMod = calcMod(wisdom);
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
        this.charismaMod = calcMod(charisma);
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public int getStrengthMod() {
        return strengthMod;
    }

    public int getDexMod() {
        return dexMod;
    }

    public int getConstMod() {
        return constMod;
    }

    public int getIntMod() {
        return intMod;
    }

    public int getWisdomMod() {
        return wisdomMod;
    }

    public int getCharismaMod() {
        return charismaMod;
    }
}
