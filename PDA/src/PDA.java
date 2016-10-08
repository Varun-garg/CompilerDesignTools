import java.util.Stack;
import java.io.*;

class PDA {

    public static void main(String args[]) throws IOException {
        Stack<Character> stack = new Stack<>();
        String input;
        Character CurrentElement, TopElement;
        System.out.println("To check pda of equal no of a and b");
        System.out.print("Enter your string\t:");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        input = bufferedReader.readLine();
        for (int i = 0; i < input.length(); i++) {
            CurrentElement = input.charAt(i);

            if (stack.size() != 0)
                TopElement = stack.peek(); //get top element without popping
            else
                TopElement = null;  //empty stack

            if (TopElement == null || TopElement.equals(CurrentElement)) //empty stack or same element
                stack.push(CurrentElement);
            else
                stack.pop();
        }
        if (stack.size() == 0)
            System.out.println("Language Accepted");
        else
            System.out.println("Language not Accepted");
    }
}