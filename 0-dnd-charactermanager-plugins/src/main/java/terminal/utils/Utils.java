package terminal.utils;

import terminal.TerminalDataContainer;
import terminal.interfaces.TerminalView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utils {

    public static String getTerminalInput(TerminalDataContainer terminalDataContainer) throws IOException {
        String selectedCharacter = "None";
        if(terminalDataContainer.getCurrentlySelectedCharacter() != null) selectedCharacter = terminalDataContainer.getCurrentlySelectedCharacter().getName();
        System.out.println(selectedCharacter + ">");

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        return reader.readLine();

    }
    public static int convertInputToInt(String input, TerminalView terminalView){
        try{
            int in = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input: " + input);
            System.out.println("Input must be a number");
            terminalView.draw();
        }
    }

}
