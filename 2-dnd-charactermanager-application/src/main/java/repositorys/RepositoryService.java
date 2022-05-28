package repositorys;

import aggregates.RPGCharacter;

import java.util.List;

public final class RepositoryService {

    private final RPGCharacterRepositoryImpl rpgCharacterRepository;
    private final RPGCharacterGraveyardImpl rpgCharacterGraveyard;

    public RepositoryService(RPGCharacterRepositoryImpl rpgCharacterRepository, RPGCharacterGraveyardImpl rpgCharacterGraveyard) {
        this.rpgCharacterRepository = rpgCharacterRepository;
        this.rpgCharacterGraveyard = rpgCharacterGraveyard;
    }

    public List<RPGCharacter> getAllAliveCharacters(){
        return this.rpgCharacterRepository.list();
    }

    public void deleteCharacter(RPGCharacter character){
        this.rpgCharacterRepository.remove(character);
        this.rpgCharacterGraveyard.remove(character);
    }

    public void moveCharacterToGraveyard(RPGCharacter character){
        this.rpgCharacterRepository.remove(character);
        this.rpgCharacterGraveyard.add(character);
    }

    public void addCharacter(RPGCharacter rpgCharacter){
        this.rpgCharacterRepository.add(rpgCharacter);
    }

    public List<RPGCharacter> getAllDeadCharacters(){
        return this.rpgCharacterGraveyard.list();
    }

    public void updateCharacter(RPGCharacter rpgCharacter){
        this.rpgCharacterRepository.update(rpgCharacter);
    }

}
