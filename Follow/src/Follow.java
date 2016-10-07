import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Follow {

    public static class Production {
        public String NonTerminal;
        public String Expression;
    }

    public static class FirstItem {
        public String NonTerminal;
        public ArrayList<Character> First;
        public boolean FirstCalculated;
    }

    public static class FollowItem {
        public String NonTerminal;
        public ArrayList<Character> Follow;
        public boolean FollowCalculated;
    }

    public static void CalculateFirst(ArrayList<Production> productions, ArrayList<FirstItem> UniqueNonTerminals, FirstItem firstItem) { //using @ for epsilon / null

        if (firstItem.FirstCalculated)
            return;

        for (int i = 0; i < productions.size(); i++) {
            if (!productions.get(i).NonTerminal.equals(firstItem.NonTerminal))
                continue;

            String expression = productions.get(i).Expression;

            if (expression.length() == 0)
                continue;

            char firstChar = expression.charAt(0);

            if (Character.isLowerCase(firstChar) || firstChar == '@')
                firstItem.First.add(firstChar);

            if (Character.isUpperCase(firstChar)) {
                String firstChStr = Character.toString(firstChar);
                FirstItem nextFirstItem = UniqueNonTerminals.stream().filter(o -> o.NonTerminal.
                        equals(firstChStr)).findFirst().orElse(null);

                if (nextFirstItem == null) {
                    System.out.println("Found Non Terminal " + firstChStr + " without any derivation");
                    System.exit(-1);
                }

                if (!nextFirstItem.FirstCalculated)
                    CalculateFirst(productions, UniqueNonTerminals, nextFirstItem);

                firstItem.First.addAll(nextFirstItem.First);
            }
        }
        firstItem.FirstCalculated = true;
    }

    public static void BeginCalculateFollow(ArrayList<Production> productions, ArrayList<FirstItem> FirstItems, ArrayList<FollowItem> followItems, FollowItem followItem) {
        followItem.Follow.add('$'); //Rule 1
        CalculateFollow(productions, FirstItems, followItems, followItem);
    }

    public static void CalculateFollow(ArrayList<Production> productions, ArrayList<FirstItem> FirstItems, ArrayList<FollowItem> followItems, FollowItem followItem) {
        //using @ for epsilon / null

        if (followItem.FollowCalculated)
            return;

        for (int i = 0; i < productions.size(); i++) {
            if (!productions.get(i).Expression.contains(followItem.NonTerminal))
                continue;

            String expression = productions.get(i).Expression;

            int position = expression.indexOf(followItem.NonTerminal);
            int nextPosition = position + 1;

            if (nextPosition < expression.length()) {
                //Rule 2
                char nextChar = expression.charAt(nextPosition);

                if (Character.isUpperCase(nextChar)) {
                    String nextFollowStr = Character.toString(nextChar);
                    FirstItem nextFirstItem = FirstItems.stream().filter(o -> o.NonTerminal.equals(nextFollowStr)).
                            findFirst().orElse(null);

                    if (nextFirstItem == null) {
                        System.out.println("Found Non Terminal " + nextFollowStr + " without any derivation");
                        System.exit(-1);
                    }

                    //if it exists first must already be calculated
                    followItem.Follow.addAll(nextFirstItem.First);
                } else {
                    followItem.Follow.add(nextChar);
                }
            } else if (nextPosition == expression.length()) {
                //Rule 3
                FollowItem nextFollowItem = followItems.stream().filter(o -> o.NonTerminal.equals(followItem.NonTerminal))
                        .findFirst().orElse(null);

                if (nextFollowItem == null) {
                    System.out.println("Found Non Terminal " + followItem.NonTerminal + " without any derivation");
                    System.exit(-1);
                }

                if (!nextFollowItem.FollowCalculated)
                    CalculateFollow(productions, FirstItems, followItems, nextFollowItem);

                followItem.Follow.addAll(nextFollowItem.Follow);
            }
        }
        followItem.FollowCalculated = true;
    }


    public static void main(String[] args) throws IOException {
        ArrayList<Production> productions = new ArrayList<>();
        ArrayList<FirstItem> UniqueNonTerminals = new ArrayList<>();
        ArrayList<FollowItem> FollowItems = new ArrayList<>();

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
            if (!productions.stream().filter(o -> o.NonTerminal.equals(production.NonTerminal)).findFirst().isPresent()) {
                FirstItem firstItem = new FirstItem();
                firstItem.NonTerminal = production.NonTerminal;
                firstItem.First = new ArrayList<>();
                firstItem.FirstCalculated = false;
                UniqueNonTerminals.add(firstItem);

                FollowItem followItem = new FollowItem();
                followItem.NonTerminal = production.NonTerminal;
                followItem.Follow = new ArrayList<>();
                followItem.FollowCalculated = false;
                FollowItems.add(followItem);
            }
            productions.add(production);
        }

        for (int i = 0; i < UniqueNonTerminals.size(); i++)
            CalculateFirst(productions, UniqueNonTerminals, UniqueNonTerminals.get(i));

        for (int i = 0; i < FollowItems.size(); i++)
            BeginCalculateFollow(productions, UniqueNonTerminals, FollowItems, FollowItems.get(i));

        System.out.println("Follow for following Non Terminals is as follows");

        for (int i = 0; i < FollowItems.size(); i++)
            System.out.println(FollowItems.get(i).NonTerminal + " : \t" + FollowItems.get(i).Follow);
    }
}
