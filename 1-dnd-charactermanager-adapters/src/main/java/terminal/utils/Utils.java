package terminal.utils;

import java.util.List;

public class Utils {

    public static List<String> convertStringToStringList(String input){
        return List.of(input.split(","));
    }



}
