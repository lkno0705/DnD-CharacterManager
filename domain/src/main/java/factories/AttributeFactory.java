package factories;

import aggregates.Attributes;
import entities.Attribute;
import exceptions.AttributeException;

public class AttributeFactory {

    private Attribute strength;
    private Attribute dexterity;
    private Attribute constitution;
    private Attribute intelligence;
    private Attribute wisdom;
    private Attribute charisma;

    public AttributeFactory(){}

    public AttributeFactory strength(Attribute strength){
        this.strength = strength;
        return this;
    }

    public AttributeFactory strength(int value) throws AttributeException {
        this.strength = new Attribute("Strength", value);
        return this;
    }

    public AttributeFactory dexterity(Attribute dexterity){
        this.dexterity = dexterity;
        return this;
    }

    public AttributeFactory dexterity(int value) throws AttributeException {
        this.dexterity = new Attribute("Dexterity", value);
        return this;
    }

    public AttributeFactory constitution(Attribute constitution){
        this.constitution = constitution;
        return this;
    }

    public AttributeFactory constitution(int value) throws AttributeException {
        this.constitution = new Attribute("Constitution", value);
        return this;
    }

    public AttributeFactory intelligence(Attribute intelligence){
        this.intelligence = intelligence;
        return this;
    }

    public AttributeFactory intelligence(int value) throws AttributeException {
        this.intelligence = new Attribute("Intelligence", value);
        return this;
    }

    public AttributeFactory wisdom(Attribute wisdom){
        this.wisdom = wisdom;
        return this;
    }

    public AttributeFactory wisdom(int value) throws AttributeException {
        this.wisdom = new Attribute("Wisdom", value);
        return this;
    }

    public AttributeFactory charisma(Attribute charisma){
        this.charisma = charisma;
        return this;
    }

    public AttributeFactory charisma(int value) throws AttributeException {
        this.charisma = new Attribute("Charisma", value);
        return this;
    }

    public Attributes build() throws AttributeException {
        return new Attributes(strength, dexterity, constitution, intelligence, wisdom, charisma);
    }

}
