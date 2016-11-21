import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        String input, production[];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a production in form of A -> Ab|B");
        input = bufferedReader.readLine();
        production = input.split("->");
        production[0] = production[0].trim();
        production[1] = production[1].trim();

        if (production[1].matches(production[0] + ".*")) {
            if(!production[1].contains("|"))
                production[1] = production[1] + "|@";
            System.out.println("Left Recursion Detected");
            String Eliminated = production[1].replaceAll("(" + production[0] + ")(.*)(\\|)(.*)",  "$1 -> $4" +
                    "$1'\n$1' -> $2$1'|@");
            System.out.println(Eliminated);
        } else
            System.out.println("No Left Recurion Found");
    }
}
