package edu.uade.frontend.base.menus;

import edu.uade.frontend.base.output.ITextOutput;

import java.util.ArrayList;

public class Menu implements IMenu {
    ArrayList<IOption> options = new ArrayList<>();
    ITextOutput console;
    String name;

    public Menu(ITextOutput console, String menuName) {
        this.console = console;
        name = menuName;
    }

    @Override
    public void addOption(IOption option) {
        options.add(option);
    }

    @Override
    public int optionCount() {
        return options.size();
    }

    @Override
    public void chooseOption(int optionId) {
        for (IOption option: options) {
            if (option.getId() == optionId) {
                option.handle();
            }
        }
    }

    @Override
    public void show() {
        console.print(name);
        for (IOption option: options) {
            console.print("" + option.getId() + " - " + option.getName());
        }
    }
}
