package edu.uade.frontend.base.menus;

public interface IMenu {
    void addOption(IOption option);
    void chooseOption(int optionId);
    void show();
}
