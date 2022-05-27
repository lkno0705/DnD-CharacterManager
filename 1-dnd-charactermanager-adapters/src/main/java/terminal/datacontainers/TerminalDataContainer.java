package terminal.datacontainers;

import aggregates.RPGCharacter;
import repositorys.RepositoryService;

public class TerminalDataContainer {

    RPGCharacter currentlySelectedCharacter = null;
    RepositoryService repositoryService;

    public TerminalDataContainer(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    public RepositoryService getRepositoryService() {
        return repositoryService;
    }

    public RPGCharacter getCurrentlySelectedCharacter() {
        return currentlySelectedCharacter;
    }

    public void setCurrentlySelectedCharacter(RPGCharacter currentlySelectedCharacter) {
        this.currentlySelectedCharacter = currentlySelectedCharacter;
    }

    public void setRepositoryService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }
}
