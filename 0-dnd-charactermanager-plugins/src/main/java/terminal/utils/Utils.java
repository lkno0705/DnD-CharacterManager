package terminal.utils;

import terminal.datacontainers.TerminalDataContainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utils {

    public static String getTerminalInput(TerminalDataContainer terminalDataContainer) throws IOException {
        String selectedCharacter = "None";
        if(terminalDataContainer.getCurrentlySelectedCharacter() != null) selectedCharacter = terminalDataContainer.getCurrentlySelectedCharacter().getName();
        System.out.print(selectedCharacter + "> ");

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        return reader.readLine();

    }
    public static int convertInputToInt(String input) throws IOException {
        try{
            int in = Integer.parseInt(input);
            return in;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input: " + input);
            System.out.println("Input must be a number");
        }
        return 0;
    }

}
