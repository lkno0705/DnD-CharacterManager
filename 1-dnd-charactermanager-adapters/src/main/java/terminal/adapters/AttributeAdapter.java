package terminal.adapters;

import exceptions.AttributeException;
import factories.AttributeFactory;
import terminal.datacontainers.CharacterDataContainer;

public class AttributeAdapter {

    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private CharacterDataContainer characterDataContainer;

    public AttributeAdapter(CharacterDataContainer characterDataContainer) {
        this.characterDataContainer = characterDataContainer;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public CharacterDataContainer build(){
        try {
            characterDataContainer.setAttributes(
                    new AttributeFactory()
                            .wisdom(wisdom)
                            .intelligence(intelligence)
                            .constitution(constitution)
                            .charisma(charisma)
                            .dexterity(dexterity)
                            .strength(strength)
                            .build());
        } catch (AttributeException e) {
            System.out.println("Error building Attributes");
        }
        return this.characterDataContainer;
    }
}
