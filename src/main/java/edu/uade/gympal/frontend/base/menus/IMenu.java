package edu.uade.gympal.frontend.base.menus;

public interface IMenu {
    void addOption(IOption option);
    void chooseOption(int optionId);
    int optionCount();
    void show();
}
