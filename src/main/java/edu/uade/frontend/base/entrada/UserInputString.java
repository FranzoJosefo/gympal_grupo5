package edu.uade.frontend.base.entrada;

import edu.uade.frontend.base.salida.ITextOutput;

import java.util.Scanner;

public class UserInputString {
    ITextOutput console;
    Scanner input = new Scanner(System.in);

    public UserInputString(ITextOutput console) {
        this.console = console;
    }

    public String read(String message, String errorMessage, int minChars, int maxChars) {
        if (message != null && message.length() > 0) {
            console.print(message);
        }
        String userInput = input.next();
        if (userInput == null || userInput.length() < minChars || userInput.length() > maxChars) {
            if (errorMessage != null && errorMessage.length() > 0) {
                console.print(errorMessage);
            }
            return read(message, errorMessage, minChars, maxChars);
        }
        return userInput;
    }
}
