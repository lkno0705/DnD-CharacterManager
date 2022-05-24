package terminal.views;

import aggregates.RPGCharacter;
import terminal.datacontainers.TerminalDataContainer;

import java.util.List;

public class ShowAvailableCharacters {

    public static int showAvailableCharacters(TerminalDataContainer terminalDataContainer){
        List<RPGCharacter> aliveCharacters = terminalDataContainer.getRepositoryService().getAllAliveCharacters();
        return printListOfCharacters(aliveCharacters);
    }

    public static int showDeadCharacters(TerminalDataContainer terminalDataContainer){
        List<RPGCharacter> deadCharacters = terminalDataContainer.getRepositoryService().getAllDeadCharacters();
        return printListOfCharacters(deadCharacters);
    }

    private static int printListOfCharacters(List<RPGCharacter> rpgCharacters){
        int counter = 0;
        if(rpgCharacters.isEmpty()) System.out.println("No characters in Repository!\n");
        else {
            for (RPGCharacter rpgcharacter : rpgCharacters) {
                counter++;
                System.out.println(counter + ") " + rpgcharacter.getName());
            }
        }
        return counter;
    }

}
