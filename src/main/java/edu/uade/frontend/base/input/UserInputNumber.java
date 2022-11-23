package edu.uade.frontend.base.input;

import edu.uade.frontend.base.output.ITextOutput;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInputNumber<T> {
    ITextOutput console;
    Scanner input = new Scanner(System.in);
    IInputSpecifier<T> inputSpecifier;
    IBoundComparator<T> boundComparator;
    IOutOfBoundsProvider<T> outOfBoundsProvider;

    public interface IInputSpecifier<T> {
        T next(Scanner fromScanner);
    }

    public interface IBoundComparator<T> {
        boolean withinBounds(T value, T lowerBound, T upperBound);
    }

    public interface IOutOfBoundsProvider<T> {
        T getOutOfBounds(T lowerBound, T upperBound);
    }

    public UserInputNumber(ITextOutput output, IInputSpecifier<T> inputSpecifier, IBoundComparator<T> boundComparator, IOutOfBoundsProvider<T> outOfBoundsProvider) {
        this.console = output;
        this.inputSpecifier = inputSpecifier;
        this.boundComparator = boundComparator;
        this.outOfBoundsProvider = outOfBoundsProvider;
    }

    public T read(String message, String errorMessage, T min, T max) {
        if (message != null && message.length() > 0) {
            console.print(message);
        }

        T userInput;
        try {
            userInput = inputSpecifier.next(input);
        } catch (InputMismatchException ex) {
            userInput = outOfBoundsProvider.getOutOfBounds(min, max);
            input.nextLine();
        }

        if (!boundComparator.withinBounds(userInput, min, max)) {
            if (errorMessage != null && errorMessage.length() > 0) {
                console.print(errorMessage);
            }
            return read(message, errorMessage, min, max);
        }
        return userInput;
    }
}
