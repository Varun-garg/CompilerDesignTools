package com.varun.CompilerLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckStringFromGrammar {

    public static void main(String[] args) throws IOException {
        String input;
        System.out.println("Grammar  :\n" +
                "\n" +
                "S – > 122S\n" +
                "S – > 12S\n" +
                "S – > 1S\n" +
                "S – > ");
        System.out.print("Enter your string\t:");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        input = bufferedReader.readLine();

        int i, length, flag;
        length = input.length();
        i = 0; //index
        flag = 0;
        while (true) {
            if ((i + 2) < length && input.substring(i, i + 2 + 1).equals("122")) {
                //(in substring endIndex is exclusive)
                i += 3;
                continue;
            }
            if ((i + 1) < length && input.substring(i, i + 1 + 1).equals("12")) {
                i += 2;
                continue;
            }
            if (i < length && input.charAt(i) == '1') {
                i++;
                continue;
            }
            if (i == length) {
                break;
            } else {
                flag = 1;
                break;
            }
        }
        if (flag == 0)
            System.out.println("Given string can be generated from given grammar");
        else
            System.out.println("Given string can NOT be generated from given grammar");
    }
}
