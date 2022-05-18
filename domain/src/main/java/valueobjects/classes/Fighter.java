package valueobjects.classes;

import entities.CharacterClass;
import valueobjects.SkillProficiencies;

import java.util.Arrays;
import java.util.HashMap;

public class Fighter extends CharacterClass {

    public Fighter(){
        super(
                2,
                1,
                Arrays.asList("Common"),
                new SkillProficiencies(new HashMap<String, boolean>(){{
                    put("Acrobatics", true);
                    put("AnimalHandling", true);
                    put("Arcana", false);
                    put("Athletics", true);
                    put("Deception", false);
                    put("History", true);
                    put("Insight", true);
                    put("Intimidation", true);
                    put("Investigation", false);
                    put("Medicine")
                }}
                )
        )
    }

}
