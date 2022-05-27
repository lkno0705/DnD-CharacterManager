package entities;

import exceptions.AttributeException;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

public class Attribute {

    private final UUID id;
    private final String attributeName;
    private int attributeModifier;
    private int attributeValue;
    public static final String[] validAttributeNames = {
            "Strength",
            "Dexterity",
            "Constitution",
            "Intelligence",
            "Wisdom",
            "Charisma"
    };

    public Attribute(String attributeName, int attributeValue) throws AttributeException {
        if(isValidAttributeName(attributeName)) this.attributeName = attributeName;
        else throw new AttributeException("Invalid Attribute Name: " + attributeName);

        setAttributeValue(attributeValue);
        this.id = UUID.randomUUID();
    }

    private boolean isValidAttributeName(String attributeName){

        return Arrays.asList(validAttributeNames).contains(attributeName);

    }

    private int calcMod(int attributeValue){
        return (attributeValue - 10) / 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attribute attribute = (Attribute) o;
        return Objects.equals(id, attribute.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setAttributeValue(int attributeValue) throws AttributeException {
        if (attributeValue > 0 && attributeValue < 20) this.attributeValue = attributeValue;
        else throw new AttributeException("Invalid attribute Value: " + attributeValue);
        this.attributeModifier = calcMod(attributeValue);
    }

    public String getAttributeName() {
        return attributeName;
    }

    public int getAttributeModifier() {
        return attributeModifier;
    }

    public int getAttributeValue() {
        return attributeValue;
    }
}
