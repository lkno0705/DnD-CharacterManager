package terminal.adapters;

import exceptions.PlayerException;
import terminal.datacontainers.CharacterDataContainer;
import terminal.datacontainers.PlayerDataContainer;
import valueobjects.Player;

public class PlayerAdapter {

    public static void createPlayer(CharacterDataContainer characterDataContainer, PlayerDataContainer playerDataContainer) throws PlayerException {
        Player player = new Player(playerDataContainer.getFirstName(), playerDataContainer.getLastName());
        characterDataContainer.setPlayer(player);
    }

}
