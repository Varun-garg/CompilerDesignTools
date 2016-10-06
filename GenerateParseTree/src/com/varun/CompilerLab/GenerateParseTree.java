package com.varun.CompilerLab;

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
    final static String Keywords[] = {"int","float","char","double","long"};

    //now we define elements of tree
    final static String Top[] = {"Assignment Operator","Special Assignment Operator"};
    final static String Parents[] = {"Arithmetic Symbol","Comparison Operator","Logical Operator","Shift Operator"};
    final static String Children[] = {"Variable","Keyword","Punctuation","Preprocessor Operator"};

    public static String getContent

    public static void main(String[] args) {
        String input;
        System.out.println("Characterizing tokens using special symbols characterized at");
        System.out.println("https://www.tutorialspoint.com/compiler_design/compiler_design_lexical_analysis.htm");
    }
}
