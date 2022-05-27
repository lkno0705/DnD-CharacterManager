package terminal.interfaces;

import terminal.datacontainers.TerminalDataContainer;

import java.io.IOException;

public interface TerminalView {

    void draw() throws IOException;

    TerminalDataContainer getTerminalDataContainer();

}
