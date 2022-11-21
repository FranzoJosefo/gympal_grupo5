package edu.uade.frontend.base.output;

public class TextOutputConsole implements ITextOutput {

    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
