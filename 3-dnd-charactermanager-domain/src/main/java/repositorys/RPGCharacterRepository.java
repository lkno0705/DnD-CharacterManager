package repositorys;

import aggregates.RPGCharacter;

import java.util.List;

public interface RPGCharacterRepository {

    void add(RPGCharacter rpgCharacter);

    void remove(RPGCharacter rpgCharacter);

    void update(RPGCharacter rpgCharacter);

    List<RPGCharacter> list();

}
