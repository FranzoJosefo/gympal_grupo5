package edu.uade.frontend.base.menues;

public interface IMenu {
    void addOption(IOption option);
    void chooseOption(int optionId);
    void show();
}
