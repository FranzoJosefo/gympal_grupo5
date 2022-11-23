package edu.uade.frontend.base.input;

import edu.uade.frontend.base.output.ITextOutput;

import java.util.Scanner;

public class UserInputInteger extends UserInputNumber<Integer> {
    public UserInputInteger(ITextOutput output) {
        super(output, Scanner::nextInt, (Integer value, Integer min, Integer max) -> value >= min && value <= max, (Integer lower, Integer upper) -> lower - 1);
    }
}
