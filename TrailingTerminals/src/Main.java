import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static class Production {
        public String NonTerminal;
        public String Expression;
    }

    static char TrailingTerminal(Production production) {
        for (int i = production.Expression.length() - 1; i >= 0; i--) {
            if (Character.isLowerCase(production.Expression.charAt(i)))
                return production.Expression.charAt(i);
        }
        return '@'; // null
    }

    public static void main(String[] args) throws IOException {

        String input;
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter productions in form S -> Sb, @ for Epsilon/null.");
        System.out.println("Instead of using S -> Sb / d, enter 2 productions s -> Sb and S -> d");
        System.out.print("Enter no of productions\t:");
        n = Integer.parseInt(br.readLine());

        System.out.println("Enter productions");
        for (int i = 0; i < n; i++) {
            input = br.readLine();
            String arr[] = input.trim().split("->");
            Production production = new Production();
            production.NonTerminal = arr[0].trim();
            production.Expression = arr[1].trim();
            System.out.println("Trailing terminal\t:" + TrailingTerminal(production));
        }
    }
}
