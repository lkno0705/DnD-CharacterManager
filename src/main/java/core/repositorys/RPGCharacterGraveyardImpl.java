package core.repositorys;

import core.aggregates.RPGCharacter;

import java.util.ArrayList;
import java.util.List;

public class RPGCharacterGraveyardImpl implements RPGCharacterGraveyard{

    private final List<RPGCharacter> rpgCharacters;

    public RPGCharacterGraveyardImpl() {
        this.rpgCharacters = new ArrayList<>();
    }

    @Override
    public void add(RPGCharacter rpgCharacter) {
        rpgCharacters.add(rpgCharacter);
    }

    @Override
    public void remove(RPGCharacter rpgCharacter) {
        rpgCharacters.remove(rpgCharacter);
    }

    @Override
    public void update(RPGCharacter rpgCharacter) {
        rpgCharacters.remove(rpgCharacter);
        rpgCharacters.add(rpgCharacter);
    }

    @Override
    public List<RPGCharacter> list() {
        return rpgCharacters;
    }
}
