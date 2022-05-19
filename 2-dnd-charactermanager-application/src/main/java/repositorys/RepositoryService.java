package repositorys;

import aggregates.RPGCharacter;

import java.util.List;

public final class RepositoryService {

    private final RPGCharacterRepository rpgCharacterRepository;
    private final RPGCharacterGraveyard rpgCharacterGraveyard;

    public RepositoryService(RPGCharacterRepository rpgCharacterRepository, RPGCharacterGraveyard rpgCharacterGraveyard) {
        this.rpgCharacterRepository = rpgCharacterRepository;
        this.rpgCharacterGraveyard = rpgCharacterGraveyard;
    }

    public RepositoryService() {
        this.rpgCharacterRepository = new RPGCharacterRepositoryImpl();
        this.rpgCharacterGraveyard = new RPGCharacterGraveyardImpl();
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

    public List<RPGCharacter> getAllDeadCharacters(){
        return this.rpgCharacterGraveyard.list();
    }

    public void updateCharacter(RPGCharacter rpgCharacter){
        this.rpgCharacterRepository.update(rpgCharacter);
    }

}