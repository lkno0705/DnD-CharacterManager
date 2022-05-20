public class HaraldHartImNehmen {

    public static RPGCharacter buildHarald(){
        CharacterRace characterRace = Human.build();
        Attributes attributes = new AttributeFactory()
                .strength(15)
                .constitution(14)
                .dexterity(10)
                .intelligence(8)
                .wisdom(13)
                .charisma(12)
                .build();
        CharacterClass characterClass = Fighter.build(attributes.getConstMod());
        Background background = new BackgroundFactory()
                .personality(new String[]{"Harter Bursche"}, new String[]{"Mag es hart"}, new String[]{"An das härteste"}, new String[]{"Wird wohl noch härter"})
                .languages(new ArrayList<String>(){{add("Hartisch");}})
                .name("Harter Background")
                .skillProficiencies(
                        new SkillProficiencies(
                                new HashMap<>(){{
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
                                }}
                        )
                )
                .equipment(new HashMap<>(){{
                    put("Harte Potions", 10);
                }})
                .toolProficiencies(new ArrayList<>(){{add("Harte Tools");}})
                .build();

        this.rpgCharacter = new RPGCharacterFactory()
                .race(characterRace)
                .characterClass(characterClass)
                .background(background)
                .inventory(
                        new Currencys(10,10,10,10,10),
                        new HashMap<String, Integer>(){{
                            put("Harte Items", 10);
                        }},
                        new Weapon[]{new Weapon("Harte Hantel Hartholz", new HitDie(10, 1), false)},
                        new Armor("Harter Harnisch", 2, false, 4, 13)
                )
                .name("Harthold")
                .attributes(attributes)
                .deathSaves()
                .player("Harald", "Hart im Nehmen")
                .age(45)
                .xp(0)
                .build();
    }

}
