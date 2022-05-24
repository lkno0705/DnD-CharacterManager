import repositorys.RPGCharacterGraveyardImpl;
import repositorys.RPGCharacterRepositoryImpl;
import repositorys.RepositoryService;
import terminal.datacontainers.TerminalDataContainer;
import terminal.views.MainMenu;

import java.io.IOException;

public class DnDCharacterManagerApplication {

    public static void main(String[] args) throws IOException {
        RepositoryService repositoryService = new RepositoryService(new RPGCharacterRepositoryImpl(), new RPGCharacterGraveyardImpl());
        TerminalDataContainer terminalDataContainer = new TerminalDataContainer(repositoryService);
        while (true){
            MainMenu mainMenu = new MainMenu(terminalDataContainer);
            mainMenu.draw();
        }
    }

}
