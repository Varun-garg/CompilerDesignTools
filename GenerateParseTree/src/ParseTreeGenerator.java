import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Varun Garg on 04/10/2016.
 */
public class ParseTreeGenerator {

    //using table at https://www.tutorialspoint.com/compiler_design/compiler_design_lexical_analysis.htm
    final static String ArithmeticSymbols[] = {"+", "-", "%", "*", "/"};
    final static String Punctuations[] = {",", ";", ".", "->"};
    final static String Assignment[] = {"="};
    final static String SpecialAssignment[] = {"+=", "/=", "*=", "-="};
    final static String Comparison[] = {"==", "!=", "<", "<=", ">", ">="};
    final static String Preprocessor[] = {"#"};
    final static String Logical[] = {"&", "&&", "|", "||", "!"};
    final static String ShiftOperators[] = {">>", ">>>", "<<", "<<<"};

    //additionally we add some keyworkds
    final static String Keywords[] = {"int", "float", "char", "double", "long"};

    //now we define elements of tree
    final static String Top[] = {"Assignment Operator", "Special Assignment Operator"};
    final static String Parents[] = {"Arithmetic Symbol", "Comparison Operator", "Logical Operator", "Shift Operator"};
    final static String Children[] = {"Variable", "Keyword", "Punctuation", "Preprocessor Operator"};

    public static class Token {
        String token;
        String tokenType;
    }

    public static class Node<Token> {
        public Token data;
        public Node<Token> parent;
        public List<Node<Token>> children;

        public Node<Token> InsertElement(Token data) {
            Node<Token> child = new Node<>();
            child.children = new ArrayList<>();
            child.data = data;

            this.children.add(child);
            child.parent = this;

            return child;
        }
    }

    public static void GenerateParseTree(Node<Token> parent, int index, int direction, ArrayList<Token> TokenList) {

        if (direction == 0 || direction == -1) //backward + center
        {
            int NextIndex = index - 2;
            int FoundNextParent = 0;

            while (NextIndex != -1) //exceed bound
            {
                if (Arrays.asList(Parents).contains(TokenList.get(NextIndex).tokenType)) {
                    Node<Token> child = parent.InsertElement(TokenList.get(NextIndex));
                    GenerateParseTree(child, NextIndex, -1, TokenList);
                    FoundNextParent = 1;
                    break;
                }
                NextIndex--;
            }

            //no next parent element so we take next element as child
            if (FoundNextParent == 0 && (index - 1) != -1) {
                parent.InsertElement(TokenList.get(index - 1));
            }
        }

        if (direction == -1) //backward only
        {
            parent.InsertElement(TokenList.get(index + 1));
        }

        if (direction == 1) //forward only
        {
            parent.InsertElement(TokenList.get(index - 1));
        }

        if (direction == 0 || direction == 1) //forward + center
        {
            int NextIndex = index + 1;
            int FoundNextParent = 0;

            while (NextIndex < TokenList.size()) //exceed bound
            {
                if (Arrays.asList(Parents).contains(TokenList.get(NextIndex).tokenType)) {
                    Node<Token> child = parent.InsertElement(TokenList.get(NextIndex));
                    GenerateParseTree(child, NextIndex, 1, TokenList);
                    FoundNextParent = 1;
                    break;
                }
                NextIndex++;
            }

            //no next parent element so we take next element as child
            if (FoundNextParent == 0 && (index + 1) < TokenList.size()) {
                parent.InsertElement(TokenList.get(index + 1));
            }
        }
    }

    public static String getTokenType(String token) {
        String currentType;
        if (Arrays.asList(ArithmeticSymbols).contains(token))
            currentType = "Arithmetic Symbol";
        else if (Arrays.asList(Punctuations).contains(token))
            currentType = "Punctuation";
        else if (Arrays.asList(Assignment).contains(token))
            currentType = "Assignment Operator";
        else if (Arrays.asList(SpecialAssignment).contains(token))
            currentType = "Special Assignment Operator";
        else if (Arrays.asList(Comparison).contains(token))
            currentType = "Comparison Operator";
        else if (Arrays.asList(Preprocessor).contains(token))
            currentType = "Preprocessor Operator";
        else if (Arrays.asList(Logical).contains(token))
            currentType = "Logical Operator";
        else if (Arrays.asList(ShiftOperators).contains(token))
            currentType = "Shift Operator";
        else if (Arrays.asList(Keywords).contains(token))
            currentType = "Keyword";
        else
            currentType = "Variable";
        return currentType;
    }

    public static void PrintParseTree(Node<Token> rootNode, int level, boolean isTail) {
        for (int i = 0; i < level; i++) {
            System.out.print("│   ");
        }

        if (isTail == false)
            System.out.print("├── ");
        else
            System.out.print("└──");

        System.out.println(rootNode.data.token);

        for (int i = 0; i < rootNode.children.size(); i++) {
            boolean isChildTail = false;
            if (i == (rootNode.children.size() - 1))
                isChildTail = true;

            PrintParseTree(rootNode.children.get(i), level + 1, isChildTail);
        }
    }

    public static void main(String[] args) throws IOException {
        String input;
        System.out.println("Characterizing tokens using special symbols characterized at");
        System.out.println("https://www.tutorialspoint.com/compiler_design/compiler_design_lexical_analysis.htm");

        System.out.print("Enter your string\t:");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        input = bufferedReader.readLine();

        String tokens[] = input.trim().split("\\s+");

        ArrayList<Token> TokenArray = new ArrayList<Token>();

        int TopIndex = -1;

        for (int i = 0; i < tokens.length; i++) {
            Token token = new Token();
            token.token = tokens[i];
            token.tokenType = getTokenType(tokens[i]);
            TokenArray.add(token);

            if (Arrays.asList(Top).contains(token.tokenType))
                TopIndex = i;
        }

        if (TopIndex == -1) {
            System.out.println("Unable to find top element");
            return;
        }

        Node<Token> rootNode = new Node<>();
        rootNode.data = TokenArray.get(TopIndex);
        rootNode.children = new ArrayList<>();

        GenerateParseTree(rootNode, TopIndex, 0, TokenArray);
        PrintParseTree(rootNode, 0, false);
    }
}
