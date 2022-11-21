package edu.uade.frontend.base.output;

public class TextOutputConsole implements ITextOutput {

    @Override
    public void print(String message) {
        if (message != null && message.length() > 0) {
            System.out.println(message);
        }
    }
}
