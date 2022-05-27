package terminal.adapters;

import exceptions.BackgroundException;
import exceptions.PersonalityException;
import exceptions.SkillProficiencyException;
import factories.BackgroundFactory;
import terminal.datacontainers.BackgroundDataContainer;
import terminal.datacontainers.CharacterDataContainer;
import terminal.datacontainers.PersonalityDataContainer;
import valueobjects.Personality;
import valueobjects.SkillProficiencies;

import java.util.Arrays;
import java.util.HashMap;

public class BackgroundAdapter {

    private PersonalityDataContainer personalityDataContainer = new PersonalityDataContainer();
    private BackgroundDataContainer backgroundDataContainer = new BackgroundDataContainer();
    private CharacterDataContainer characterDataContainer;

    public BackgroundAdapter(CharacterDataContainer characterDataContainer) {
        this.characterDataContainer = characterDataContainer;
    }

    public void processTraits(String input) {
        String[] traits = input.split(",");
        personalityDataContainer.setPersonalityTraits(traits);
    }

    public void processIdeals(String input) {
        String[] ideals = input.split(",");
        personalityDataContainer.setIdeal(ideals);
    }

    public void processBonds(String input) {
        String[] bonds = input.split(",");
        personalityDataContainer.setBond(bonds);
    }

    public void processFlaws(String input) {
        String[] flaws = input.split(",");
        personalityDataContainer.setFlaw(flaws);
        buildPersonality();
    }

    public void setName(String input) {
        backgroundDataContainer.setName(input);
    }

    public void setSkillProficiencies() {
        try {
            SkillProficiencies skillProficiencies = new SkillProficiencies(
                    new HashMap<>() {{
                        put("Acrobatics", true);
                        put("AnimalHandling", true);
                        put("Arcana", false);
                        put("Athletics", true);
                        put("Deception", false);
                        put("History", true);
                        put("Insight", true);
                        put("Intimidation", true);
                        put("Investigation", false);
                        put("Medicine", false);
                        put("Nature", false);
                        put("Perception", false);
                        put("Performance", false);
                        put("Persuasion", false);
                        put("Religion", false);
                        put("SleightofHand", false);
                        put("Stealth", false);
                        put("Survival", false);
                    }}
            );
            backgroundDataContainer.setSkillProficiencies(skillProficiencies);
        } catch (SkillProficiencyException e) {
            System.out.println("ERROR During Skill Proficiency creation!");
        }
    }

    private void buildPersonality() {
        try {
            Personality personality = new Personality(
                    personalityDataContainer.getPersonalityTraits(),
                    personalityDataContainer.getIdeal(),
                    personalityDataContainer.getBond(),
                    personalityDataContainer.getFlaw()
            );
            backgroundDataContainer.setPersonality(personality);
        } catch (PersonalityException e) {
            System.out.println("ERROR! Couldn't build Personality");
        }
    }

    public void processLanguages(String input) {
        String[] flaws = input.split(",");
        backgroundDataContainer.setLanguages(Arrays.stream(flaws).toList());
    }

    public void setEquipment() {
        backgroundDataContainer.setEquipment(new HashMap<>() {{
            put("Harte Potions", 10);
        }});
    }


    public void processToolProficiencies(String input) {
        String[] toolProficiencies = input.split(",");
        backgroundDataContainer.setToolProficiencies(Arrays.stream(toolProficiencies).toList());
    }

    public CharacterDataContainer build() {
        try {
            characterDataContainer.setBackground(
                    new BackgroundFactory()
                            .personality(backgroundDataContainer.getPersonality())
                            .name(backgroundDataContainer.getName())
                            .skillProficiencies(backgroundDataContainer.getSkillProficiencies())
                            .languages(backgroundDataContainer.getLanguages())
                            .equipment(backgroundDataContainer.getEquipment())
                            .toolProficiencies(backgroundDataContainer.getToolProficiencies())
                            .build());
        } catch (BackgroundException e) {
            System.out.println("ERROR building Background!");
        }
        return this.characterDataContainer;
    }
}
