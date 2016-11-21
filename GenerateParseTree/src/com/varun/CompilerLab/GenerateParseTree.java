package com.varun.CompilerLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class GenerateParseTree {

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

        for (int i = 0; i < tokens.length;i++)
        {
            Token token = new Token();
            token.token = tokens[i];
            token.tokenType = getTokenType(tokens[i]);
            TokenArray.add(token);

            if(Arrays.asList(Top).contains(token.tokenType))
                TopIndex = i;
        }

        if(TopIndex == -1)
        {
            System.out.println("Unable to find top element");
            return;
        }

        Tree tree = new Tree(TokenArray.get(TopIndex).token);

        System.out.println("Top " + TokenArray.get(TopIndex).token);
    }
}
