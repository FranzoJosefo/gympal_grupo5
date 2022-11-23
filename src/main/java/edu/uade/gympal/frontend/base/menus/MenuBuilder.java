package edu.uade.gympal.frontend.base.menus;

import edu.uade.gympal.frontend.base.output.ITextOutput;

public class MenuBuilder {
    Menu building;
    int addedOption = 0;

    public MenuBuilder create(String title, ITextOutput console) {
        building = new Menu(console, title);
        addedOption = 0;
        return this;
    }

    public MenuBuilder addOption(String label, IOptionHandler optionHandler) {
        if (building != null) {
            addedOption++;
            building.addOption(new Option(addedOption, label, optionHandler));
        }
        return this;
    }

    public MenuBuilder addOptionIf(boolean condition, String label, IOptionHandler optionHandler) {
        if (condition) {
            return addOption(label, optionHandler);
        }
        return this;
    }

    public Menu get() {
        Menu built = building;
        building = null;
        return built;
    }
}
