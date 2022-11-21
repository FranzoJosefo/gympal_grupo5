package edu.uade.frontend.app.views;

import edu.uade.frontend.base.input.UserInputInteger;
import edu.uade.frontend.base.input.UserInputString;
import edu.uade.frontend.base.menus.Menu;
import edu.uade.frontend.base.output.ITextOutput;

public class InputUtils {
    public static String read(ITextOutput console, String prompt, int minChars, int maxChars) {
        UserInputString input = new UserInputString(console);
        return input.read(prompt, "Por favor, ingrese entre " + minChars + " y " + maxChars + " caracteres.", minChars, maxChars);
    }

    public static int readInt(ITextOutput console, String prompt, int min, int max) {
        UserInputInteger input = new UserInputInteger(console);
        return input.read(prompt, "Por favor, ingrese entre " + min + " y " + max + " caracteres.", min, max);
    }

    public static void chooseOption(ITextOutput console, Menu fromMenu) {
        UserInputInteger input = new UserInputInteger(console);
        fromMenu.chooseOption(input.read("Ingrese la opción deseada:", "Opción incorrecta", 1, fromMenu.optionCount()));
    }
}
