package edu.uade.frontend.base.salida;

public class TextOutputConsole implements ITextOutput {

    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
