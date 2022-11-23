package edu.uade.gympal.frontend.base.menus;

public class Option implements IOption {
    int id;
    String name;
    IOptionHandler handler;

    public Option(int id, String name, IOptionHandler handler) {
        this.id = id;
        this.name = name;
        this.handler = handler;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void handle() {
        if (handler != null) {
            handler.handle();
        }
    }
}
