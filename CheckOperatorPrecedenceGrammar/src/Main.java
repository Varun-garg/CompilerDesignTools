import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static class Production {
        public String NonTerminal;
        public String Expression;
    }

    static boolean checkOperatorPrecedenceGrammar(Production production) {
        if (production.Expression == null || production.Expression.length() == 0)
            return false; // empty right side
        int consistentNonTerminalCount = 0;
        for (int i = 0; i < production.Expression.length(); i++) {
            if (Character.isUpperCase(production.Expression.charAt(i)))
                consistentNonTerminalCount = 0;
            else if (production.Expression.charAt(i) == '|')
                consistentNonTerminalCount = 0;
            else if (consistentNonTerminalCount == 1)
                return false; // 2nd consistent non terminal
            else consistentNonTerminalCount = 1;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        String input;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your production (use @ for null)");
        input = bufferedReader.readLine();
        Production production = new Production();
        production.NonTerminal = input.replaceFirst("(.*)(->)(/*)", "$1").trim();
        production.Expression = input.replaceFirst("(.*)(->)(/*)", "$3").trim();
        if (checkOperatorPrecedenceGrammar(production)) {
            System.out.println("Given grammar is operator precedent");
        } else {
            System.out.println("Given grammar is NOT operator precedent");
        }
    }
}
