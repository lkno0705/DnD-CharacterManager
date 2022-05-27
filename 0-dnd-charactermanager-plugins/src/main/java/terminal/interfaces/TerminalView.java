package terminal.interfaces;

import terminal.datacontainers.CharacterDataContainer;
import terminal.datacontainers.TerminalDataContainer;

import java.io.IOException;

public interface TerminalView {

    void draw() throws IOException;

    TerminalDataContainer getTerminalDataContainer();

}
