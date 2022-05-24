package terminal;

import aggregates.RPGCharacter;

public class TerminalDataContainer {

    RPGCharacter currentlySelectedCharacter = null;

    public RPGCharacter getCurrentlySelectedCharacter() {
        return currentlySelectedCharacter;
    }

    public void setCurrentlySelectedCharacter(RPGCharacter currentlySelectedCharacter) {
        this.currentlySelectedCharacter = currentlySelectedCharacter;
    }
}
