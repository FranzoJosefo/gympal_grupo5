package edu.uade.frontend.app.views;

import edu.uade.frontend.base.input.UserInputString;
import edu.uade.frontend.base.output.ITextOutput;

public class InputUtils {
    public static String read(ITextOutput console, String prompt, int minChars, int maxChars) {
        UserInputString input = new UserInputString(console);
        return input.read(prompt, "Por favor, ingrese entre " + minChars + " y " + maxChars + " caracteres.", minChars, maxChars);
    }
}
