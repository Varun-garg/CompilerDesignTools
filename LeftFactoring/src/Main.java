import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        String input, head, production, subProductions[], tempStr;
        int common_size = 0; // size of alpha
        System.out.println("Enter production in form of A -> bB|bC|bD");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        input = bufferedReader.readLine();
        head = input.replaceFirst("(.*)(->)(.*)", "$1").trim();
        production = input.replaceFirst("(.*)(->)(.*)", "$3").trim();
        subProductions = production.split("\\|");

        if (subProductions.length <= 1) {
            System.out.println("Only 1 sub production, no left factoring needed");
            return;
        }

        common_size = 0;
        int i, flag = 0;
        do {
            tempStr = subProductions[0].substring(0, common_size + 1);
            for (i = 1; i < subProductions.length; i++) {
                if (!subProductions[i].substring(0, common_size + 1).equals(tempStr)) {
                    flag = 1;
                    break;
                }

            }
            if (flag == 1) break;
            common_size++;
        } while (common_size != subProductions[0].length());

        if (common_size == 0) {
            System.out.println("no common prefix in sub productions, no left factoring needed");
            return;
        }
        tempStr = subProductions[0].substring(0, common_size);
        System.out.println(head + " -> " + tempStr + head + "'");
        System.out.print(head + "' -> " + subProductions[0].substring(common_size));
        for (i = 1; i < subProductions.length; i++) {
            System.out.print("|" + subProductions[i].substring(common_size));
        }
    }
}