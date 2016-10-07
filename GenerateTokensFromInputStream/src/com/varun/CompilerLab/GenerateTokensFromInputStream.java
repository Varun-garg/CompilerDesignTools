package com.varun.CompilerLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GenerateTokensFromInputStream {

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
    final static String Keywords[] = {"int","float","char","double","long"};

    public static void main(String[] args) throws IOException {
        String input;
        System.out.println("Characterizing tokens using special symbols characterized at");
        System.out.println("https://www.tutorialspoint.com/compiler_design/compiler_design_lexical_analysis.htm");

        System.out.print("Enter your string\t:");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        input = bufferedReader.readLine();


        String tokens[] = input.trim().split("\\s+");
        System.out.print("Tokens :");
        for (int i = 0; i < tokens.length; i++) {
            if (i == 0)
                System.out.print(tokens[i]);
            else
                System.out.print(", " + tokens[i]);
        }

        System.out.println("\nCharacterizing tokens");
        String currentType;
        for (int i = 0; i < tokens.length; i++) {

            if (Arrays.asList(ArithmeticSymbols).contains(tokens[i]))
                currentType = "Arithmetic Symbol";
            else if (Arrays.asList(Punctuations).contains(tokens[i]))
                currentType = "Punctuation";
            else if (Arrays.asList(Assignment).contains(tokens[i]))
                currentType = "Assignment Operator";
            else if (Arrays.asList(SpecialAssignment).contains(tokens[i]))
                currentType = "Special Assignment Operator";
            else if (Arrays.asList(Comparison).contains(tokens[i]))
                currentType = "Comparison Operator";
            else if (Arrays.asList(Preprocessor).contains(tokens[i]))
                currentType = "Preprocessor Operator";
            else if (Arrays.asList(Logical).contains(tokens[i]))
                currentType = "Logical Operator";
            else if (Arrays.asList(ShiftOperators).contains(tokens[i]))
                currentType = "Shift Operator";
            else if (Arrays.asList(Keywords).contains(tokens[i]))
                currentType = "Keyword";
            else
                currentType = "Variable";

            System.out.println(tokens[i] + " : " + currentType);
        }
    }
}
