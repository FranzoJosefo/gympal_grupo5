package edu.uade.frontend.base.input;

import edu.uade.frontend.base.output.ITextOutput;

import java.util.Scanner;

public class UserInputFloat extends UserInputNumber<Float> {
    public UserInputFloat(ITextOutput output) {
        super(output, Scanner::nextFloat, (Float value, Float min, Float max) -> value >= min && value <= max, (Float lower, Float upper) -> lower - 1);
    }
}
