package edu.uade.frontend.base.input;

import edu.uade.frontend.base.output.ITextOutput;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInputInteger {
    ITextOutput console;
    Scanner input = new Scanner(System.in);

    public UserInputInteger(ITextOutput output) {
        this.console = output;
    }

    public int read(String message, String errorMessage, int min, int max) {
        if (message != null && message.length() > 0) {
            console.print(message);
        }

        int userInput;
        try {
            userInput = input.nextInt();
        } catch (InputMismatchException ex) {
            userInput = min - 1;
            input.nextLine();
        }

        if (userInput < min || userInput > max) {
            if (errorMessage != null && errorMessage.length() > 0) {
                console.print(errorMessage);
            }
            return read(message, errorMessage, min, max);
        }
        return userInput;
    }
}
