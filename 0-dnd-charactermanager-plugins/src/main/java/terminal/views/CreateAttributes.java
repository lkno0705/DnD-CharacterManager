package terminal.views;

import terminal.adapters.AttributeAdapter;
import terminal.datacontainers.CharacterDataContainer;
import terminal.datacontainers.TerminalDataContainer;
import terminal.interfaces.TerminalView;
import terminal.utils.Utils;

import java.io.IOException;

public class CreateAttributes implements TerminalView {

    TerminalDataContainer terminalDataContainer;
    CharacterDataContainer characterDataContainer;
    AttributeAdapter attributeAdapter;

    public CreateAttributes(TerminalDataContainer terminalDataContainer, CharacterDataContainer characterDataContainer) {
        this.terminalDataContainer = terminalDataContainer;
        this.characterDataContainer = characterDataContainer;
        this.attributeAdapter = new AttributeAdapter(characterDataContainer);
    }

    @Override
    public void draw() throws IOException {
        System.out.println("Please Enter the rolled Values for the displayed Attribute");
        System.out.println("Strength");
        String in =  Utils.getTerminalInput(terminalDataContainer);
        attributeAdapter.setStrength(Utils.convertInputToInt(in));
        System.out.println("Dexterity");
        in =  Utils.getTerminalInput(terminalDataContainer);
        attributeAdapter.setDexterity(Utils.convertInputToInt(in));
        System.out.println("Constitution");
        in =  Utils.getTerminalInput(terminalDataContainer);
        attributeAdapter.setConstitution(Utils.convertInputToInt(in));
        System.out.println("Intelligence");
        in =  Utils.getTerminalInput(terminalDataContainer);
        attributeAdapter.setIntelligence(Utils.convertInputToInt(in));
        System.out.println("Wisdom");
        in =  Utils.getTerminalInput(terminalDataContainer);
        attributeAdapter.setWisdom(Utils.convertInputToInt(in));
        System.out.println("Charisma");
        in =  Utils.getTerminalInput(terminalDataContainer);
        attributeAdapter.setCharisma(Utils.convertInputToInt(in));
        attributeAdapter.build();
    }
}
