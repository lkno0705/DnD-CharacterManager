package aggregates;

import entities.Attribute;
import exceptions.AttributeException;

import java.util.Objects;
import java.util.UUID;

public class Attributes {

    private final Attribute strength;
    private final Attribute dexterity;
    private final Attribute constitution;
    private final Attribute intelligence;
    private final Attribute wisdom;
    private final Attribute charisma;
    private final UUID id;

    public Attributes(Attribute strength, Attribute dexterity, Attribute constitution, Attribute intelligence, Attribute wisdom, Attribute charisma) throws AttributeException {
        if(strength.getAttributeName().equals("Strength")) this.strength = strength;
        else throw new AttributeException("Invalid Attribute Name: " + strength.getAttributeName() + "for Attribute Strength");

        if(dexterity.getAttributeName().equals("Dexterity")) this.dexterity = dexterity;
        else throw new AttributeException("Invalid Attribute Name: " + dexterity.getAttributeName() + "for Attribute Dexterity");

        if(constitution.getAttributeName().equals("Consitution")) this.constitution = constitution;
        else throw new AttributeException("Invalid Attribute Name: " + constitution.getAttributeName() + "for Attribute Constitution");

        if(intelligence.getAttributeName().equals("Intelligence")) this.intelligence = intelligence;
        else throw new AttributeException("Invalid Attribute Name: " + intelligence.getAttributeName() + "for Attribute Intelligence");

        if(wisdom.getAttributeName().equals("Wisdom")) this.wisdom = wisdom;
        else throw new AttributeException("Invalid Attribute Name: " + wisdom.getAttributeName() + "for Attribute Wisdom");

        if(charisma.getAttributeName().equals("Charisma")) this.charisma = charisma;
        else throw new AttributeException("Invalid Attribute Name: " + charisma.getAttributeName() + "for Attribute Charisma");
        this.id = UUID.randomUUID();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attributes that = (Attributes) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setStrength(int strength) throws AttributeException {
        this.strength.setAttributeValue(strength);
    }

    public void setDexterity(int dexterity) throws AttributeException {
        this.dexterity.setAttributeValue(dexterity);
    }

    public void setConstitution(int constitution) throws AttributeException {
        this.constitution.setAttributeValue(constitution);
    }

    public void setIntelligence(int intelligence) throws AttributeException {
        this.intelligence.setAttributeValue(intelligence);
    }

    public void setWisdom(int wisdom) throws AttributeException {
        this.wisdom.setAttributeValue(wisdom);
    }

    public void setCharisma(int charisma) throws AttributeException {
        this.charisma.setAttributeValue(charisma);
    }

    public int getStrength() {
        return strength.getAttributeValue();
    }

    public int getDexterity() {
        return dexterity.getAttributeValue();
    }

    public int getConstitution() {
        return constitution.getAttributeValue();
    }

    public int getIntelligence() {
        return intelligence.getAttributeValue();
    }

    public int getWisdom() {
        return wisdom.getAttributeValue();
    }

    public int getCharisma() {
        return charisma.getAttributeValue();
    }

    public int getStrengthMod() {
        return this.strength.getAttributeModifier();
    }

    public int getDexMod() {
        return this.dexterity.getAttributeModifier();
    }

    public int getConstMod() {
        return this.constitution.getAttributeModifier();
    }

    public int getIntMod() {
        return this.intelligence.getAttributeModifier();
    }

    public int getWisdomMod() {
        return this.wisdom.getAttributeModifier();
    }

    public int getCharismaMod() {
        return this.wisdom.getAttributeModifier();
    }
}
